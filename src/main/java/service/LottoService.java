package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import model.LottoGame;
import model.LottoMessage;
import model.WinningInfo;

public class LottoService {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_PAY = 1000;
    private static final Double LOTTO_RESULT = 100.0;

    public int valueIntegerConversion(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.getError(LottoMessage.ERROR_NOT_NUMBER));
        }
    }

    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public List<Lotto> userPurchaseLottoListmake(int money) {
        List<Lotto> userPurchaseLottoList = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            List<Integer> lottoList = makeLotto();
            userPurchaseLottoList.add(new Lotto(lottoList));
        }
        return userPurchaseLottoList;
    }

    public String[] winningNumbersSplit(String userInput) {
        return userInput.split(",");
    }

    public List<Integer> winningNumbersConversion(String[] userInput) {
        return Arrays.stream(userInput).map(Integer::parseInt).sorted().collect(Collectors.toList());
    }


    public LottoGame winningNumberMatch(LottoGame lottoGame) {
        List<Lotto> lottoGameList = lottoGame.getLottoGameList();
        for (Lotto lotto : lottoGameList) {
            int matchNumberCount = matchNumberCount(lotto.getNumbers(), lottoGame.getWinningNumbers());
            int bonusNumberCheck = bonusNumberCheck(lotto.getNumbers(), lottoGame.getBonusNumber());
            WinningInfo winningInfo = WinningInfo.matchNumber(matchNumberCount, bonusNumberCheck);
            lottoGame.getCounts(winningInfo);
        }

        return lottoGame;
    }

    public int bonusNumberCheck(List<Integer> lotto, int bonusNumber) {
        return lotto.stream().filter(element -> element == bonusNumber).toList().size();
    }

    public int matchNumberCount(List<Integer> lotto, List<Integer> winningNumbers) {
        return lotto.stream().filter(winningNumbers::contains).toList().size();
    }

    public double lottoResult(LottoGame lottoGame) {
        double allSumValue = (lottoGame.getFirstCount() * WinningInfo.RANK1.getWinningMoney())
                + (lottoGame.getSecondCount() * WinningInfo.RANK2.getWinningMoney())
                + (lottoGame.getThirdCount() * WinningInfo.RANK3.getWinningMoney())
                + (lottoGame.getFourthCount() * WinningInfo.RANK4.getWinningMoney())
                + (lottoGame.getFifthCount() * WinningInfo.RANK5.getWinningMoney());
        double purchaseMoney = Double.parseDouble(String.valueOf(lottoGame.getPurchaseMoney()));
        return (allSumValue / purchaseMoney) * LOTTO_RESULT;
    }

    public int purchaseMoneyRemain(int purchaseMoney) {
        return purchaseMoney / LOTTO_PAY;
    }

}
