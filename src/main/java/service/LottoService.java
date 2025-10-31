package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoService {

    public int valueConversion(String purchaseMoney) {
        try {
            return Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액이 정수로 변환불가");
        }
    }

    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public List<Lotto> userPurchaseLottoListmake(int money) {
        List<Lotto> userPurchaseLottoList = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            List<Integer> lottoList = makeLotto();
            userPurchaseLottoList.add(new Lotto(lottoList));
        }
        return userPurchaseLottoList;
    }

    public String[] winningNumbersSplit(String userInput) {
        return userInput.split(",");
    }

    public List<Integer> winningNumbersConversion(String[] userInput) {
        return Arrays.stream(userInput).map(Integer::parseInt).sorted().collect(Collectors.toList());
    }


}
