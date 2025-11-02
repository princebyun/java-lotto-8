package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.LottoMessage;
import service.LottoService;

public class UserInputValidation {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_ZERO = 0;
    private static final int LOTTO_PAY = 1000;

    LottoService lottoService = new LottoService();


    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        numberNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void numberNegative(int purchaseMoney) {
        if (purchaseMoney < LOTTO_ZERO) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.NUMBER_NEGATIVE));
        }
    }

    public void purchaseMoneyRemainder(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PAY != LOTTO_ZERO) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.PURCHASE_MONEY_REMAINDER));
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
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.WINNING_NUMBERS_DUPLICATE_CHECK));
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
        if (userInput.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.LENGTH_CHECK));
        }
    }

    public void duplicateCheck(String[] userInput) {
        Set<String> uniqueValues = new HashSet<>(Arrays.asList(userInput));
        if (uniqueValues.size() != userInput.length) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.DUPLICATE_CHECK_WINNING_NUMBER));
        }
    }


    public void checkDecimalPoint(String winningNumber) {
        if (winningNumber.contains(".")) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.CHECK_DECIMAL_POINT));
        }
    }


    public void numbersRangeValidation(int winningNumber) {
        if (winningNumber < LOTTO_START || LOTTO_END < winningNumber) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.NUMBERS_RANGE_VALIDATION));
        }
    }

}
