package domain;

import java.util.List;
import lotto.Lotto;

public class LottoGame {
    private final int purchaseMoney;
    private List<List<Lotto>> lottoGameList;

    public LottoGame(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public void setLottoGameList(List<Lotto> lottoList) {
        this.lottoGameList.add(lottoList);
    }


    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
