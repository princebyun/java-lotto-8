package lotto;

import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        inputPurchaseMoney(lottoController);
        lottoController.makeLottoList();
        inputWinningNumbers(lottoController);
        inputBonusNumber(lottoController);
        lottoController.lottoMatch();
    }

    private static void inputPurchaseMoney(LottoController lottoController) {
        while (true) {
            try {
                lottoController.userInputPurchaseMoneySave();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void inputWinningNumbers(LottoController lottoController) {
        while (true) {
            try {
                lottoController.userInputWinningNumbersSave();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void inputBonusNumber(LottoController lottoController) {
        while (true) {
            try {
                lottoController.userInputBonusNumberSave();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
