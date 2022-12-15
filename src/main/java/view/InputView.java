package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int inputOneNumber(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers(){
        String input = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        input = input.replaceAll(",","");
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<'0'||input.charAt(i)>'9'){
                throw new IllegalArgumentException();
            }
            winningNumbers.add(input.charAt(i)-'0');
        }
        return winningNumbers;
    }
}
