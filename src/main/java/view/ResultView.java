package view;

import java.util.List;
import lotto.Lotto;
import model.LottoGame;
import model.LottoMessage;

public class ResultView {

    public void purchaseLottoCountView(int money) {
        System.out.println(LottoMessage.PURCHASE_LOTTO_COUNT_VIEW.format(money));
    }

    public void userPurchaseLottoListView(List<Lotto> userPurchaseLottoList) {
        for (Lotto lotto : userPurchaseLottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void lottoStatisticsView(LottoGame lottoGame) {
        System.out.println(LottoMessage.LOTTO_STATISTICS_VIEW.getLottoMessage());
        System.out.println(LottoMessage.INFO_RANK_5.format(lottoGame.getFifthCount()));
        System.out.println(LottoMessage.INFO_RANK_4.format(lottoGame.getFourthCount()));
        System.out.println(LottoMessage.INFO_RANK_3.format(lottoGame.getThirdCount()));
        System.out.println(LottoMessage.INFO_RANK_2.format(lottoGame.getSecondCount()));
        System.out.println(LottoMessage.INFO_RANK_1.format(lottoGame.getFirstCount()));
    }

    public void lottoResult(Double resultValue) {
        System.out.println(LottoMessage.LOTTO_RESULT.format(resultValue));
    }

}
