package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputView {

    public String userInputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

}
