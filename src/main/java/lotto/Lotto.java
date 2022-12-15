package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberSize(numbers);
    }

    private void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoMachine.getLottoSize()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    public int countMatchingNumber(List<Integer> winningNumbers){
        int matchCount =0;
        for(int i=0;i<winningNumbers.size();i++){
            if(numbers.contains(winningNumbers.get(i))){
                matchCount++;
            }
        }
        return matchCount;
    }
    public boolean checkContainBonusNumber(int bonusNumber){
        if (numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
