package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidationTest {

    UserInputValidation userInputValidation = new UserInputValidation();

    @DisplayName("음수,1000원단위 밸리데이션 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 8500})
    void userInputPurchaseMoneySave(int number) {

        assertThatThrownBy(() -> {
            userInputValidation.purchaseMoneyRemainder(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("당첨번호 밸리데이션 테스트")
    void winningNumbersValidation() {
        String[] value1 = {"1", "2", "2", "2", "2", "2"};
        String[] value2 = {"1", "-2", "3", "4", "5", "6"};
        String[] value3 = {"1", "222", "3", "4", "5", "6"};
        String[] value4 = {"rksk", "2", "3", "4", "5", "6"};
        String[] value5 = {"1.1", "2.2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> {
            userInputValidation.winningNumbersValidation(value1);
            userInputValidation.winningNumbersValidation(value2);
            userInputValidation.winningNumbersValidation(value3);
            userInputValidation.winningNumbersValidation(value4);
            userInputValidation.winningNumbersValidation(value5);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}