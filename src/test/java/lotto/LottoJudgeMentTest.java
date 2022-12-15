package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoJudgeMentTest {
    Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    Lotto winningLotto = new Lotto(Arrays.asList(1,8,3,4,5,7));
    WinningLotto winning =new WinningLotto(winningLotto,5);


    @Test
    void 로또_져지먼트_테스트(){
        LottoJudgeMent lottoJudgeMent = new LottoJudgeMent(winning,lotto,6);
        Assertions.assertThat(lottoJudgeMent.makeRank().getCountOfMatch()).isEqualTo(Rank.FOURTH.getCountOfMatch());
        Assertions.assertThat(lottoJudgeMent.makeRank().getWinningMoney()).isEqualTo(Rank.FOURTH.getWinningMoney());
    }

}