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
        outputView.inputPurchase();
        int purchase = inputView.inputOneNumber();

        lottoMachine = new LottoMachine(purchase);

        outputView.printLottoCount(lottoMachine.getLottoCount());
        List<Lotto> lottos = lottoMachine.getLottos();
        for(int i=0;i<lottos.size();i++){
            System.out.println(lottos.get(i).getNumbers());
        }

        outputView.inputWinning();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.inputBonusNumber();
        int bonusNumber = inputView.inputOneNumber();

        lottoMachine.makeWinningLotto(winningNumbers,bonusNumber);

        lottoMachine.checkEachLotto();

        LottoResult lottoResult = lottoMachine.getLottoResult();

        outputView.printResult();
        for(Rank key : lottoResult.getRankCount().keySet()){
            outputView.printEachResult(key,lottoResult.getRankCount().get(key));
        }

        outputView.printSumRate(lottoResult.getSumRate());

    }
}
