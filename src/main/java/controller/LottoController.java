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
    private LottoGame lottoGame;

    public void gameStart() {
        userInputPurchaseMoneySave();
        makeLottoList();
        userInputWinningNumbersSave();
        userInputBonusNumberSave();
    }

    public void userInputPurchaseMoneySave() {
        while (true) {
            try {
                String userInputValue = userInputView.userInputPurchaseMoneyView();
                int purchaseMoney = lottoService.valueConversion(userInputValue);
                lottoGame = new LottoGame(userInputValidation.purchaseMoneyValidation(purchaseMoney));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void makeLottoList() {
        int money = lottoGame.getPurchaseMoney() / 1000;
        List<Lotto> userPurchaseLottoList = lottoService.userPurchaseLottoListmake(money);
        lottoGame.setLottoGameList(userPurchaseLottoList);
        resultView.purchaseLottoCountView(lottoGame.getLottoGameList().size());
        resultView.userPurchaseLottoListView(lottoGame.getLottoGameList());
    }

    public void userInputWinningNumbersSave() {
        while (true) {
            try {
                String userInput = userInputView.userInputWinningNumbers();
                String[] userInputSplit = lottoService.winningNumbersSplit(userInput);
                userInputValidation.winningNumbersValidation(userInputSplit);
                lottoGame.setWinningNumbers(lottoService.winningNumbersConversion(userInputSplit));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void userInputBonusNumberSave() {
        while (true) {
            try {
                String userInput = userInputView.userInputBonusNumber();
                userInputValidation.bonusNumberValidation(userInput, lottoGame.getWinningNumbers());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 컨트롤러 테스트를 위해 작성
     */
    public LottoGame getLottoGame() {
        return lottoGame;
    }
}
