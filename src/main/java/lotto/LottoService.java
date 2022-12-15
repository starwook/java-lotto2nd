package lotto;

import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoService {
    LottoMachine lottoMachine;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void init(){
        makeLottoMachine();
        showLottos();
        makeWinningLotto();
        checkEachLotto();
        LottoResult lottoResult = getLottoResult();
        showResult(lottoResult);
    }

    private void checkEachLotto() {
        lottoMachine.checkEachLotto();
    }

    private void makeWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        lottoMachine.makeWinningLotto(winningNumbers,bonusNumber);
    }

    private void makeLottoMachine() {
        outputView.inputPurchase();
        int purchase = inputView.inputOneNumber();

        lottoMachine = new LottoMachine(purchase);
    }

    private void showLottos() {
        outputView.printLottoCount(lottoMachine.getLottoCount());
        List<Lotto> lottos = lottoMachine.getLottos();
        for(int i=0;i<lottos.size();i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    private List<Integer> getWinningNumbers() {
        outputView.inputWinning();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        return winningNumbers;
    }

    private int getBonusNumber() {
        outputView.inputBonusNumber();
        int bonusNumber = inputView.inputOneNumber();
        return bonusNumber;
    }

    private LottoResult getLottoResult() {
        LottoResult lottoResult = lottoMachine.getLottoResult();
        lottoResult.calculateSumRate();
        return lottoResult;
    }

    private void showResult(LottoResult lottoResult) {
        outputView.printResult();
        for(Rank key : lottoResult.getRankCount().keySet()){
            boolean bonus =false;
            if(key == Rank.SECOND){
                bonus = true;
            }
            outputView.printEachResult(key, lottoResult.getRankCount().get(key),bonus);
        }
        outputView.printSumRate(lottoResult.getSumRate());
    }
}
