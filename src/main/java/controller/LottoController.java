package controller;


import domain.LottoGame;
import java.util.List;
import lotto.Lotto;
import service.LottoService;
import validation.UserInputValidation;
import view.ResultView;
import view.UserInputView;

public class LottoController {

    private final UserInputView userInputView = new UserInputView();
    private final LottoService lottoService = new LottoService();
    private final UserInputValidation userInputValidation = new UserInputValidation();
    private final ResultView resultView = new ResultView();
    private LottoGame game;

    public void gameStart() {
        userInputPurchaseMoneySave();
        makeLottoList();
        userInputWinningNumbersSave();
    }

    public void userInputPurchaseMoneySave() {
        while (true) {
            try {
                String userInputValue = userInputView.userInputPurchaseMoneyView();
                int purchaseMoney = lottoService.valueConversion(userInputValue);
                game = new LottoGame(userInputValidation.purchaseMoneyValidation(purchaseMoney));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void makeLottoList() {
        int money = game.getPurchaseMoney() / 1000;
        List<Lotto> userPurchaseLottoList = lottoService.userPurchaseLottoListmake(money);
        game.setLottoGameList(userPurchaseLottoList);
        resultView.purchaseLottoCountView(game.getLottoGameList().size());
        resultView.userPurchaseLottoListView(game.getLottoGameList());
    }

    public void userInputWinningNumbersSave() {
        String userInput = userInputView.userInputWinningNumbers();
        String[] userInputSplit = lottoService.winningNumbersSplit(userInput);
        userInputValidation.winningNumbersValidation(userInputSplit);
    }


    /**
     * 컨트롤러 테스트를 위해 작성
     */
    public LottoGame getGame() {
        return game;
    }
}
