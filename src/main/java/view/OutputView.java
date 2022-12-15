package view;

import lotto.Rank;

public class OutputView {
    private static String INPUT_PURCHASE ="구입금액을 입력해 주세요.";
    private static String COUNT_OF_LOTTO ="개를 구매했습니다";
    private static String INPUT_WINNING_NUMBER ="당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER ="보너스 번호를 입력해 주세요.";
    private static String RESULT_START = "당첨통계\n---";
    private static String COUNT_OF_CORRECT ="개 일치";
    private static String BONUS_CORRECT =", 보너스 볼 일치";
    private static String SUM_RATE_START = "총 수익률은 ";
    private static String SUM_RATE_END ="%입니다";
    private static String NUM = "개";
    private static String IS = " - ";
    private static String MONEY_LEFT = "(";
    private static String MONEY_RIGHT = "원)";

    public void inputPurchase(){
        System.out.println(INPUT_PURCHASE);
    }

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount+COUNT_OF_LOTTO);
    }

    public void inputWinning(){
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printResult(){
        System.out.println(RESULT_START);
    }

    public void printEachResult(Rank rank,int count, boolean bonus){
        System.out.print(rank.getCountOfMatch()+COUNT_OF_CORRECT);
        if(bonus){
            System.out.print(BONUS_CORRECT);
        }
        System.out.println(MONEY_LEFT+rank.getWinningMoney()+MONEY_RIGHT+IS+count+NUM);
    }

    public void printSumRate(double sumRate){
        System.out.println(SUM_RATE_START+ sumRate+SUM_RATE_END);
    }
}
