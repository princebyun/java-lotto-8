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
    private final LottoGame lottoGame = new LottoGame();

    public void userInputPurchaseMoneySave() {
        String userInputValue = userInputView.userInputPurchaseMoneyView();
        int purchaseMoney = lottoService.valueIntegerConversion(userInputValue);
        lottoGame.setPurchaseMoney(userInputValidation.purchaseMoneyValidation(purchaseMoney));
    }

    public void makeLottoList() {
        int money = lottoGame.getPurchaseMoney() / 1000;
        List<Lotto> userPurchaseLottoList = lottoService.userPurchaseLottoListmake(money);
        lottoGame.setLottoGameList(userPurchaseLottoList);
        resultView.purchaseLottoCountView(lottoGame.getLottoGameList().size());
        resultView.userPurchaseLottoListView(lottoGame.getLottoGameList());
    }

    public void userInputWinningNumbersSave() {
        String userInput = userInputView.userInputWinningNumbersView();
        String[] userInputSplit = lottoService.winningNumbersSplit(userInput);
        userInputValidation.winningNumbersValidation(userInputSplit);
        lottoGame.setWinningNumbers(lottoService.winningNumbersConversion(userInputSplit));
    }

    public void userInputBonusNumberSave() {
        String userInput = userInputView.userInputBonusNumberView();
        userInputValidation.bonusNumberValidation(userInput, lottoGame.getWinningNumbers());
        lottoGame.setBonusNumber(lottoService.valueIntegerConversion(userInput));
    }

    public void lottoMatch() {
        lottoService.winningNumberMatch(lottoGame);
        resultView.lottoStatisticsView(lottoGame);
        resultView.lottoResult(lottoService.lottoResult(lottoGame));
    }

    /* *//**
     * 컨트롤러 테스트를 위해 작성
     *//*
    public LottoGame getLottoGame() {
        return lottoGame;
    }*/
}
