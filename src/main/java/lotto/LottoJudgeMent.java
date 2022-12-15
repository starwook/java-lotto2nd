package lotto;

import java.util.List;

public class LottoJudgeMent {
    private int matchCount;
    private boolean isBonusMatch;

    public LottoJudgeMent(WinningLotto winningLotto, Lotto lotto){
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        getLottoResult(lotto, winningNumbers, winningLotto.getBonusNumber());
    }

    private void getLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        matchCount = lotto.countMatchingNumber(winningNumbers);
        isBonusMatch = lotto.checkContainBonusNumber(bonusNumber);
    }
}
