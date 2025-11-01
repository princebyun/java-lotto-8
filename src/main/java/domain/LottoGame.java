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

    public void setFirstCount(int firstCount) {
        this.firstCount = firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public void setSecondCount(int secondCount) {
        this.secondCount = secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public void setThirdCount(int thirdCount) {
        this.thirdCount = thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public void setFourthCount(int fourthCount) {
        this.fourthCount = fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public void setFifthCount(int fifthCount) {
        this.fifthCount = fifthCount;
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
}
