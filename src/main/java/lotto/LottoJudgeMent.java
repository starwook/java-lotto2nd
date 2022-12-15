package lotto;

import java.util.List;

public class LottoJudgeMent {
    public int matchCount;
    public boolean isBonusMatch;
    private int countToCheckBonus;

    public LottoJudgeMent(WinningLotto winningLotto, Lotto lotto,int countToCheckBonus){
        this.countToCheckBonus = countToCheckBonus;
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        getLottoResult(lotto, winningNumbers, winningLotto.getBonusNumber());
        makeRank();
    }

    private void getLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        matchCount = lotto.countMatchingNumber(winningNumbers);
        isBonusMatch = lotto.checkContainBonusNumber(bonusNumber);
    }
    public Rank makeRank(){
        List<Rank> ranks = List.of(Rank.values());
        for(int i=0;i<ranks.size();i++){
            if(checkMatchCount(ranks.get(i))){
                return checkIfBonusCorrect(ranks, i);
            }
        }
        return null;
    }

    private Rank checkIfBonusCorrect(List<Rank> ranks, int i) {
        if(countToCheckBonus ==matchCount &&isBonusMatch){
            return Rank.SECOND;
        }
        return ranks.get(i);
    }

    private boolean checkMatchCount(Rank rank) {
        if(matchCount == rank.getCountOfMatch()){
            return true;
        }
        return false;
    }
}
