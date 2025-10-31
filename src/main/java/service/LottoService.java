package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoService {

    public int valueIntegerConversion(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자는 입력할수 없습니다.");
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
