package view;

import java.util.List;
import lotto.Lotto;

public class ResultView {

    public void purchaseLottoCountView(int money) {
        System.out.println();
        System.out.println(money + "개를 구매했습니다.");
    }

    public void userPurchaseLottoListView(List<Lotto> userPurchaseLottoList) {
        for (Lotto lotto : userPurchaseLottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

}
