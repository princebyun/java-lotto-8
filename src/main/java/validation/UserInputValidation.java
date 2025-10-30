package validation;

public class UserInputValidation {


    public int purchaseMoneyRemainder(int purchaseMoney) {
        int remainder = purchaseMoney % 1000;
        if (remainder != 0) {
            throw new IllegalArgumentException("1,000원 단위가 아닙니다.");
        }
        return purchaseMoney;
    }
}
