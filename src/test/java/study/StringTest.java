package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {


    @Test
    void 요구사항1() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }


    @Test
    void 요구사항2() {
        String value = "(1,2)";

        String result = value.substring(0, 4);
        assertThat(result).contains("1,2");


    }

    @Test
    @DisplayName("스트링값에서 문자 위치값 가져오기 테스트 케이스")
    void 요구사항3() {

        String value = "abc";

        String result1 = String.valueOf(value.charAt(0));

        assertThat(result1).contains("a");
        assertThatThrownBy(() -> {
            String result2 = String.valueOf(value.charAt(6));
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 6 out of bounds for length 3");

    }


}
