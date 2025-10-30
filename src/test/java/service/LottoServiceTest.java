package service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}