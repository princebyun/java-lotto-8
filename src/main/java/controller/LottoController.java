package controller;


import domain.LottoGame;
import service.LottoService;
import view.UserInputView;

public class LottoController {

    private final UserInputView userInputView = new UserInputView();
    private final LottoService lottoService = new LottoService();
    private LottoGame game;

    public void gameStart() {
        userInputPurchaseMoneySave();
    }

    public void userInputPurchaseMoneySave() {
        String userInputValue = userInputView.userInputPurchaseMoney();
        int purchaseMoney = lottoService.valueConversion(userInputValue);
        this.game = new LottoGame(purchaseMoney);
    }


}
