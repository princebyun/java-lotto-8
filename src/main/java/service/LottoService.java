package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

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


    public List<Lotto> userPurchaseLottoListmake(int money) {
        List<Lotto> userPurchaseLottoList = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            List<Integer> lottoList = makelotto();
            userPurchaseLottoList.add(new Lotto(lottoList));
        }
        return userPurchaseLottoList;
    }

}
