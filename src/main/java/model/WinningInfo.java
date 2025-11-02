package model;

public enum WinningInfo {

    일등(6, 0, 2000000000),
    이등(5, 1, 30000000),
    삼등(5, 0, 1500000),
    사등(4, 0, 50000),
    오등(3, 0, 5000),
    낙첨(0, 0, 0);

    private final int winningNumber;
    private final int bonusNumber;
    private final int winningMoney;

    WinningInfo(int winningNumber, int bonusNumber, int winningMoney) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = winningMoney;
    }


    public static WinningInfo matchNumber(int matchCount, int bonusNumberCheck) {
        if (matchCount == 6) {
            return 일등;
        }
        if (matchCount == 5 && bonusNumberCheck == 1) {
            return 이등;
        }
        if (matchCount == 5) {
            return 삼등;
        }
        if (matchCount == 4) {
            return 사등;
        }
        if (matchCount == 3) {
            return 오등;
        }
        return 낙첨;
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
