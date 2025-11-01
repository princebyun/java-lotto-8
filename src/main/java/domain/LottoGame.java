package domain;

import java.util.List;
import lotto.Lotto;

public class LottoGame {
    private int purchaseMoney;
    private List<Lotto> lottoGameList;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setPurchaseMoney(int purchaseMoney) {
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

    public void getCounts(WinningInfo winningInfo) {
        if (winningInfo.getWinningNumber() == 6) {
            this.firstCount++;
            return;
        }
        if (winningInfo.getWinningNumber() == 5 && winningInfo.getBonusNumber() == 1) {
            this.secondCount++;
            return;
        }
        if (winningInfo.getWinningNumber() == 5) {
            this.thirdCount++;
            return;
        }
        if (winningInfo.getWinningNumber() == 4) {
            this.fourthCount++;
            return;
        }
        if (winningInfo.getWinningNumber() == 3) {
            this.fifthCount++;
        }
    }
}
