package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {
    private static int LOTTO_PRICE =1000;
    private static int LOTTO_SIZE =6;
    private static int RANGE_START =1;
    private static int RANGE_END =45;
    private WinningLotto winningLotto;
    private List<Lotto> lottos = new ArrayList<>();
    private int lottoCount;
    private double returnRate;

    public LottoMachine(int purchase,List<Integer> winningLottoInput,int bonusNumberInput){
        validatePurchase(purchase);
        makeWinningLotto(winningLottoInput, bonusNumberInput);
        makeLottos();
    }
    private void makeLottos() {
        for(int i=0;i<lottoCount;i++){
            List<Integer> lottoRandomNumbers = Randoms.pickUniqueNumbersInRange(RANGE_START,RANGE_END,LOTTO_SIZE);
            Lotto lotto = new Lotto(lottoRandomNumbers);
            lottos.add(lotto);
        }
    }

    private void makeWinningLotto(List<Integer> winningLottoInput, int bonusNumberInput) {
        validateNumbersInRange(winningLottoInput);
        validateNumberInRange(bonusNumberInput);
        winningLotto = new WinningLotto(new Lotto(winningLottoInput), bonusNumberInput);
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

    public static int getLottoSize(){
        return LOTTO_SIZE;
    }

}
