package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService service = new LottoService();

    @Test
    @DisplayName("사용자 입력받은  string 타입 값 바꾸기")
    void valueConversionTest() {
        String value = "글자는 에러";

        assertThatThrownBy(() -> {
            service.valueConversion(value);
        }).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("로또발행 테스트")
    void makeLotto() {
        List<Integer> lottoList = service.makelotto();

        assertThat(lottoList.size()).isEqualTo(6);
    }

}