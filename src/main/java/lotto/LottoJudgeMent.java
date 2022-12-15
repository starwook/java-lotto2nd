package lotto;

import java.util.List;

public class LottoJudgeMent {
    private int matchCount;
    private boolean isBonusMatch;
    private Rank rank;
    private int countToCheckBonus;

    public LottoJudgeMent(WinningLotto winningLotto, Lotto lotto,int countToCheckBonus){
        this.countToCheckBonus = countToCheckBonus;
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        getLottoResult(lotto, winningNumbers, winningLotto.getBonusNumber());
    }

    private void getLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        matchCount = lotto.countMatchingNumber(winningNumbers);
        isBonusMatch = lotto.checkContainBonusNumber(bonusNumber);
    }
    public Rank getRank(){
        List<Rank> ranks = List.of(Rank.values());
        for(int i=0;i<ranks.size();i++){
            checkEachRank(ranks, i);
        }
        return rank;
    }

    private void checkEachRank(List<Rank> ranks, int i) {
        if(matchCount == ranks.get(i).getCountOfMatch()){
            if(matchCount == countToCheckBonus && isBonusMatch){
                rank = Rank.SECOND;
                return;
            }
            rank = ranks.get(i);
        }
    }
}
