package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import service.LottoService;

public class UserInputValidation {
    LottoService lottoService = new LottoService();

    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        numberNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void numberNegative(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력이 안됩니다.");
        }
    }

    public void purchaseMoneyRemainder(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위가 아닙니다.");
        }
    }

    public void bonusNumberValidation(String userInput, List<Integer> winningNumbers) {
        checkDecimalPoint(userInput);
        int bonusNumber = lottoService.valueIntegerConversion(userInput);
        numberNegative(bonusNumber);
        numbersRangeValidation(bonusNumber);
        winningNumbersDuplicateCheck(bonusNumber, winningNumbers);
    }

    public void winningNumbersDuplicateCheck(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public void winningNumbersValidation(String[] userInput) {
        duplicateCheck(userInput);
        for (String value : userInput) {
            checkDecimalPoint(value);
            int winningNumber = lottoService.valueIntegerConversion(value);
            numberNegative(winningNumber);
            numbersRangeValidation(winningNumber);
        }
        lengthCheck(userInput);
    }

    public void lengthCheck(String[] userInput) {
        if (userInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리를 입력해주세요.");
        }
    }

    public void duplicateCheck(String[] userInput) {
        Set<String> uniqueValues = new HashSet<>(Arrays.asList(userInput));
        if (uniqueValues.size() != userInput.length) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 값을 입력해주세요.");
        }
    }


    public void checkDecimalPoint(String winningNumber) {
        if (winningNumber.contains(".")) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수어야 합니다.");
        }
    }


    public void numbersRangeValidation(int winningNumber) {
        if (winningNumber < 1 || 45 < winningNumber) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1부터 45 사이의 중복되지 않는 정수입니다.");
        }
    }

}
