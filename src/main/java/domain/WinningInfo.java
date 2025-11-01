package domain;

public enum WinningInfo {

    일등(6, 0, 2000000000),
    이등(5, 1, 30000000),
    삼등(5, 0, 1500000),
    사등(4, 0, 50000),
    오등(3, 0, 5000);


    private final int winningNumber;
    private final int bonusNumber;
    private final int winningMoney;

    WinningInfo(int winningNumber, int bonusNumber, int winningMoney) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = winningMoney;
    }


    public int getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }


}
