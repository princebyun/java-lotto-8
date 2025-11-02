package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.LottoMessage;

public class UserInputView {

    public String userInputPurchaseMoneyView() {
        System.out.println(LottoMessage.USER_INPUT_PURCHASE_MONEY_VIEW.getLottoMessage());
        return readLine();
    }

    public String userInputWinningNumbersView() {
        System.out.println(LottoMessage.USER_INPUT_WINNING_NUMBERS_VIEW.getLottoMessage());
        return readLine();
    }

    public String userInputBonusNumberView() {
        System.out.println(LottoMessage.USER_INPUT_BONUS_NUMBER_VIEW.getLottoMessage());
        return readLine();
    }
}
