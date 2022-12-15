package view;

import Resource.ErrorResource;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int inputOneNumber(){
        String input = Console.readLine();
        try{
            return Integer.parseInt(input);
        }
        catch (Exception e){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.NOT_NUMBER);
        }

    }

    public List<Integer> inputWinningNumbers(){
        String input = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> splitNumber = List.of(input.split(","));
        for(int i=0;i<splitNumber.size();i++){
            changeToNumber(winningNumbers, splitNumber, i);
        }
        return winningNumbers;
    }

    private void changeToNumber(List<Integer> winningNumbers, List<String> splitNumber, int i) {
        try{
            winningNumbers.add(Integer.parseInt(splitNumber.get(i)));
        }
        catch (Exception e){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.NOT_WINNING_NUMBER);
        }
    }
}
