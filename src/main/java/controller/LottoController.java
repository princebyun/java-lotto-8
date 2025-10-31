package controller;


import domain.LottoGame;
import service.LottoService;
import validation.UserInputValidation;
import view.UserInputView;

public class LottoController {

    private final UserInputView userInputView = new UserInputView();
    private final LottoService lottoService = new LottoService();
    private final UserInputValidation userInputValidation = new UserInputValidation();
    private LottoGame game;

    public void gameStart() {
        userInputPurchaseMoneySave();
    }

    public void userInputPurchaseMoneySave() {
        while (true) {
            try {
                String userInputValue = userInputView.userInputPurchaseMoney();
                int purchaseMoney = lottoService.valueConversion(userInputValue);
                this.game = new LottoGame(userInputValidation.purchaseMoneyValidation(purchaseMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
