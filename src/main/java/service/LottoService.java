package service;

public class LottoService {

    public int valueConversion(String purchaseMoney) {
        try {
            return Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액이 정수로 변환불가");
        }
    }


}
