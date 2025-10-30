package validation;

public class UserInputValidation {


    public int purchaseMoneyValidation(int purchaseMoney) {
        purchaseMoneyRemainder(purchaseMoney);
        purchaseMoneyNegative(purchaseMoney);
        return purchaseMoney;
    }


    public void purchaseMoneyNegative(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException("입력금액이 음수입니다.");
        }
    }

    public void purchaseMoneyRemainder(int purchaseMoney) {
        int remainder = purchaseMoney % 1000;
        if (remainder != 0) {
            throw new IllegalArgumentException("1,000원 단위가 아닙니다.");
        }
    }
}
