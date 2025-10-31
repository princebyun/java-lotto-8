package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    @DisplayName("보너스 번호 밸리데이션 테스트")
    void bonusNumberValidation() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);

        String bonusNumber1 = "asdasd";
        String bonusNumber2 = "-1";
        String bonusNumber3 = "1.1";
        String bonusNumber4 = "111";
        String bonusNumber5 = "4";

        assertThatThrownBy(() -> {
            userInputValidation.bonusNumberValidation(bonusNumber1, winningNumbers);
            userInputValidation.bonusNumberValidation(bonusNumber2, winningNumbers);
            userInputValidation.bonusNumberValidation(bonusNumber3, winningNumbers);
            userInputValidation.bonusNumberValidation(bonusNumber4, winningNumbers);
            userInputValidation.bonusNumberValidation(bonusNumber5, winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}