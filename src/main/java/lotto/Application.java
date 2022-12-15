package lotto;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        try {
            lottoService.init();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        // TODO: 프로그램 구현
    }
}
