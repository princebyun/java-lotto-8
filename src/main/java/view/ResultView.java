package view;

import domain.LottoGame;
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

    public void lottoStatisticsView(LottoGame lottoGame) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoGame.getFifthCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoGame.getFourthCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoGame.getThirdCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoGame.getSecondCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoGame.getFirstCount() + "개");
    }

    public void lottoResult(Double resultValue) {
        String resultString = String.format("%.1f", resultValue);
        System.out.println("총 수익률은 " + resultString + "%입니다.");
    }

}
