package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputValidation {


    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        numberNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void numberNegative(int purchaseMoney) {
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

    public void bonusNumberValidation(String userInput, List<Integer> winningNumbers) {
        checkDecimalPoint(userInput);
        int bonusNumber = numbersConversionValidation(userInput);
        numberNegative(bonusNumber);
        numbersRangeValidation(bonusNumber);
        winningNumbersDuplicateCheck(bonusNumber, winningNumbers);
    }

    public void winningNumbersDuplicateCheck(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public void winningNumbersValidation(String[] userInput) {
        duplicateCheck(userInput);
        for (String value : userInput) {
            checkDecimalPoint(value);
            int winningNumber = numbersConversionValidation(value);
            numberNegative(winningNumber);
            numbersRangeValidation(winningNumber);
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


    public Integer numbersConversionValidation(String winningNumber) {
        try {
            return Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("쉼표로 구분하며,숫자만 입력해야합니다.");
        }
    }


    public void numbersRangeValidation(int winningNumber) {
        if (winningNumber < 1 || 45 < winningNumber) {
            throw new IllegalArgumentException("입력값은 1부터 45 사이의 중복되지 않는 정수입니다.");
        }
    }

}
