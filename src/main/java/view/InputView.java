package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputOneNumber(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public int inputWinningNumbers(){
        String input = Console.readLine();
        input = input.replaceAll(",","");
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<'0'||input.charAt(i)>'9'){
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(input);
    }
}
