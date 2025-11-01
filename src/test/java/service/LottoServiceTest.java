package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService service = new LottoService();

    @Test
    @DisplayName("사용자 입력받은  string 타입 값 바꾸기")
    void valueConversionTest() {
        String value = "글자는 에러";

        assertThatThrownBy(() -> {
            service.valueIntegerConversion(value);
        }).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("로또발행 테스트")
    void makeLotto() {
        List<Integer> lottoList = service.makeLotto();
        assertThat(lottoList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자 구입 금액 로또 발행")
    void userPurchaseLottoListmake() {
        int money = 8;

        List<Lotto> result = service.userPurchaseLottoListmake(money);

        assertThat(result.size()).isEqualTo(money);
        assertThat(result.getFirst().getNumbers().size()).isEqualTo(6);
    }


    @Test
    @DisplayName("스트림을 이용한 리스트 변환")
    void winningNumbersConversion() {
        List<Integer> compairList = new ArrayList<>();
        compairList.add(1);
        compairList.add(2);
        compairList.add(3);
        compairList.add(4);

        String[] valueList = {"4", "2", "3", "1"};

        assertThat(service.winningNumbersConversion(valueList)).isEqualTo(compairList);

    }

    @Test
    @DisplayName("매칭넘버 테스트")
    void winningNumberMatch() {
        List<Integer> lottoList = new ArrayList<>();
        lottoList.add(1);
        lottoList.add(2);
        lottoList.add(3);
        lottoList.add(4);
        lottoList.add(5);
        lottoList.add(6);

        List<Integer> lottoList2 = new ArrayList<>();
        lottoList2.add(1);
        lottoList2.add(2);
        lottoList2.add(3);
        lottoList2.add(7);
        lottoList2.add(8);
        lottoList2.add(9);

        assertThat(service.matchNumberCount(lottoList, lottoList2)).isEqualTo(3);
        assertThat(service.bonusNumberCheck(lottoList2, 9)).isEqualTo(1);
    }

}