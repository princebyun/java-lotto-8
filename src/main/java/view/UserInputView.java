package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputView {

    public String userInputPurchaseMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public String userInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

}
