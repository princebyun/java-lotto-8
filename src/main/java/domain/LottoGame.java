package domain;

import java.util.List;
import lotto.Lotto;

public class LottoGame {
    private final int purchaseMoney;
    private List<Lotto> lottoGameList;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    
    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoGame(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setLottoGameList(List<Lotto> lottoList) {
        this.lottoGameList = lottoList;
    }

    public List<Lotto> getLottoGameList() {
        return lottoGameList;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
