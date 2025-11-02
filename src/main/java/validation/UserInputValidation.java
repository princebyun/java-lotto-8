package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.LottoMessage;

public class UserInputValidation {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_ZERO = 0;
    private static final int LOTTO_PAY = 1000;

    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        numberNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void numberNegative(int purchaseMoney) {
        if (purchaseMoney < LOTTO_ZERO) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_NEGATIVE.getLottoMessage());
        }
    }

    public void purchaseMoneyRemainder(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PAY != LOTTO_ZERO) {
            throw new IllegalArgumentException(LottoMessage.PURCHASE_MONEY_REMAINDER.getLottoMessage());
        }
    }

    public int integerConversion(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.ERROR_NOT_NUMBER.getLottoMessage());
        }
    }

    public void bonusNumberValidation(String userInput, List<Integer> winningNumbers) {
        checkDecimalPoint(userInput);
        int bonusNumber = integerConversion(userInput);
        numberNegative(bonusNumber);
        numbersRangeValidation(bonusNumber);
        winningNumbersDuplicateCheck(bonusNumber, winningNumbers);
    }

    public void winningNumbersDuplicateCheck(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoMessage.WINNING_NUMBERS_DUPLICATE_CHECK.getLottoMessage());
        }
    }

    public void winningNumbersValidation(String[] userInput) {
        duplicateCheck(userInput);
        for (String value : userInput) {
            checkDecimalPoint(value);
            int winningNumber = integerConversion(value);
            numberNegative(winningNumber);
            numbersRangeValidation(winningNumber);
        }
        lengthCheck(userInput);
    }

    public void lengthCheck(String[] userInput) {
        if (userInput.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoMessage.LENGTH_CHECK.getLottoMessage());
        }
    }

    public void duplicateCheck(String[] userInput) {
        Set<String> uniqueValues = new HashSet<>(Arrays.asList(userInput));
        if (uniqueValues.size() != userInput.length) {
            throw new IllegalArgumentException(LottoMessage.DUPLICATE_CHECK_WINNING_NUMBER.getLottoMessage());
        }
    }


    public void checkDecimalPoint(String winningNumber) {
        if (winningNumber.contains(".")) {
            throw new IllegalArgumentException(LottoMessage.CHECK_DECIMAL_POINT.getLottoMessage());
        }
    }


    public void numbersRangeValidation(int winningNumber) {
        if (winningNumber < LOTTO_START || LOTTO_END < winningNumber) {
            throw new IllegalArgumentException(LottoMessage.NUMBERS_RANGE_VALIDATION.getLottoMessage());
        }
    }

}
