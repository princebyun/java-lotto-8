package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidationTest {

    UserInputValidation userInputValidation = new UserInputValidation();

    @DisplayName("음수,1000원단위 밸리데이션 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 8500})
    public void userInputPurchaseMoneySave(int number) {

        assertThatThrownBy(() -> {
            userInputValidation.purchaseMoneyRemainder(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}