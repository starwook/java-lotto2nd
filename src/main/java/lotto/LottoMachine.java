package lotto;

import Resource.ErrorResource;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static int LOTTO_PRICE =1000;
    private static int LOTTO_SIZE =6;
    private static int RANGE_START =1;
    private static int RANGE_END =45;
    private static int countToCheckBonus =5;
    private WinningLotto winningLotto;
    private LottoJudgeMent lottoJudgeMent;
    private LottoResult lottoResult;
    private List<Lotto> lottos = new ArrayList<>();
    private int lottoCount;
    public LottoMachine(int purchase){
        validatePurchase(purchase);
        lottoResult = new LottoResult(purchase);
        makeLottos();
    }
    public int getLottoCount(){
        return lottoCount;
    }

    public int getCountToCheckBonus(){
        return countToCheckBonus;
    }
    public LottoMachine(int purchase,List<Integer> winningLottoInput,int bonusNumberInput){
        makeWinningLotto(winningLottoInput, bonusNumberInput);
        checkEachLotto();
    }
    public void checkEachLotto() {
        for(int i=0;i<lottos.size();i++){
            lottoJudgeMent = new LottoJudgeMent(winningLotto,lottos.get(i),countToCheckBonus);
            changeRankCountIfWin();
        }
    }
    private void changeRankCountIfWin() {
        if(lottoJudgeMent.makeRank()!=null){
            lottoResult.changeRankCount(lottoJudgeMent.makeRank());
        }
    }

    private void makeLottos() {
        for(int i=0;i<lottoCount;i++){
            List<Integer> lottoRandomNumbers = Randoms.pickUniqueNumbersInRange(RANGE_START,RANGE_END,LOTTO_SIZE);
            Lotto lotto = new Lotto(lottoRandomNumbers);
            lottos.add(lotto);
        }
    }

    public void makeWinningLotto(List<Integer> winningLottoInput, int bonusNumberInput) {
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
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.NUMBER_NOT_IN_RANGE);
        }
    }

    private void validatePurchase(int purchase) {
        if(purchase %LOTTO_PRICE!=0){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.PURCHASE_WRONG);
        }
        lottoCount = purchase /LOTTO_PRICE;
    }

    public static int getLottoSize(){
        return LOTTO_SIZE;
    }

    public LottoResult getLottoResult(){
        return lottoResult;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
