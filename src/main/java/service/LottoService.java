package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoService {

    public int valueConversion(String purchaseMoney) {
        try {
            return Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액이 정수로 변환불가");
        }
    }

    public List<Integer> makelotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}
