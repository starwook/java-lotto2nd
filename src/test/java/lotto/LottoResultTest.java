package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 수익률_계산(){
        LottoResult lottoResult = new LottoResult(8000);
        lottoResult.changeRankCount(Rank.FIFTH);
        lottoResult.calculateSumRate();
        assertThat(lottoResult.getSumRate()).isEqualTo(62.5);
    }

}