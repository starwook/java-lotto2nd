package lotto;

import java.util.List;

public class LottoJudgeMent {
    private int matchCount;
    private boolean isBonusMatch;

    public LottoJudgeMent(WinningLotto winningLotto, List<Lotto> lottos){
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        checkEachLotto(lottos, winningNumbers, bonusNumber);
    }

    private void checkEachLotto(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for(int i = 0; i< lottos.size(); i++){
            Lotto lotto = lottos.get(i);
            matchCount = lotto.countMatchingNumber(winningNumbers);
            isBonusMatch = lotto.checkContainBonusNumber(bonusNumber);
        }
    }
}
