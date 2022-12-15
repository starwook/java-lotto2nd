package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static int LOTTO_PRICE =1000;
    private static int LOTTO_SIZE =6;
    private static int RANGE_START =1;
    private static int RANGE_END =45;
    private WinningLotto winningLotto;
    private List<Lotto> lottos = new ArrayList<>();
    private int lottoCount;
    private double returnRate;

    public LottoMachine(int purchase,List<Integer> numberInput,int bonusNumberInput){
        validatePurchase(purchase);
        validateNumbersInRange(numberInput);

    }

    private void validateNumbersInRange(List<Integer> numberInput) {
        for(int i = 0; i< numberInput.size(); i++){
            validateNumberInRange(numberInput.get(i));
        }
    }

    private void validateNumberInRange(int number) {
        if(number>RANGE_END || number<RANGE_START){
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchase(int purchase) {
        if(purchase %LOTTO_PRICE!=0 && purchase ==0){
            throw new IllegalArgumentException();
        }
        lottoCount = purchase /LOTTO_PRICE;
    }


}
