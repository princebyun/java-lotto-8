package model;

public enum WinningInfo {

    RANK1(6, 0, 2000000000),
    RANK2(5, 1, 30000000),
    RANK3(5, 0, 1500000),
    RANK4(4, 0, 50000),
    RANK5(3, 0, 5000),
    FALSE(0, 0, 0);

    private final int winningNumber;
    private final int bonusNumber;
    private final int winningMoney;

    WinningInfo(int winningNumber, int bonusNumber, int winningMoney) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = winningMoney;
    }

    public static WinningInfo matchNumber(int matchNumberCount, int bonusNumberCheck) {
        for (WinningInfo info : values()) {
            if (info.winningNumber == matchNumberCount && info.bonusNumber == bonusNumberCheck) {
                return info;
            }
        }
        return FALSE;
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
