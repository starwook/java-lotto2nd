package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 통합_테스트(){
        LottoMachine lottoMachine = new LottoMachine(11000, Arrays.asList(1,2,3,4,5,6),7);
        List<Lotto> lottos = lottoMachine.getLottos();
        for(int i=0;i<lottos.size();i++) {
            System.out.println(lottos.get(i).getNumbers());
        };
        System.out.println(lottoMachine.getLottoResult().getTotalPrice());
    }

    // 아래에 추가 테스트 작성 가능
}
