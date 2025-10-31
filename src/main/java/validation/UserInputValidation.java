package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInputValidation {


    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        valueNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void valueNegative(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException("음수는 입력이 안됩니다.");
        }
    }

    public void purchaseMoneyRemainder(int purchaseMoney) {
        int remainder = purchaseMoney % 1000;
        if (remainder != 0) {
            throw new IllegalArgumentException("1,000원 단위가 아닙니다.");
        }
    }


    public void winningNumbersValidation(String[] userInput) {
        duplicateCheck(userInput);
        for (String value : userInput) {
            checkDecimalPoint(value);
            int winningNumber = winningNumbersConversionValidation(value);
            valueNegative(winningNumber);
            winningNumbersRangeValidation(winningNumber);
        }
    }

    public void duplicateCheck(String[] userInput) {
        Set<String> uniqueValues = new HashSet<>(Arrays.asList(userInput));
        if (uniqueValues.size() != userInput.length) {
            throw new IllegalArgumentException("중복되지 않은 값을 입력해주세요.");
        }
    }


    public void checkDecimalPoint(String winningNumber) {
        if (winningNumber.contains(".")) {
            throw new IllegalArgumentException("입력값은 정수어야 합니다.");
        }
    }


    public Integer winningNumbersConversionValidation(String winningNumber) {
        try {
            return Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("쉼표로 구분하며,숫자만 입력해야합니다.");
        }
    }


    public void winningNumbersRangeValidation(int winningNumber) {
        if (winningNumber < 1 || 45 < winningNumber) {
            throw new IllegalArgumentException("입력값은 1부터 45 사이의 중복되지 않는 정수입니다.");
        }
    }

}
