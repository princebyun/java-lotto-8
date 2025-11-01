package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    LottoController lottoController = new LottoController();

    @Test
    @DisplayName("유저금액입력메스드테스트케이스작성")
    void userInputPurchaseMoneySave() {
        assertSimpleTest(() -> {
            run("3000", "1,2,3,4,5,6", "7");

            lottoController.gameStart();

            String consoleOutput = output();
            assertThat(consoleOutput).isNotInstanceOfAny(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("유저금액로또저장테스트작성")
    void makeLottoList() {
        assertSimpleTest(() -> {
            run("3000", "1,2,3,4,5,6", "7");

            lottoController.gameStart();

            /*List<Lotto> resultList = lottoController.getLottoGame().getLottoGameList();
            assertThat(resultList.size()).isEqualTo(3);*/

            String consoleOutput = output();
            assertThat(consoleOutput).isNotInstanceOfAny(IllegalArgumentException.class);
        });
    }


    @Override
    protected void runMain() {
    }
}