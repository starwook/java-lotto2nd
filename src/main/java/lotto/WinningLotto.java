package lotto;

import Resource.ErrorResource;

public class WinningLotto {
    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(Lotto lotto,Integer bonusNumber){
        validateWinningLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLotto(Lotto lotto, Integer bonusNumber) {
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.NUMBER_DUPLICATE);
        }
    }

    public Lotto getLotto(){
        return lotto;
    }
    public Integer getBonusNumber(){
        return bonusNumber;
    }
}
