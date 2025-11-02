package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import model.LottoGame;
import model.WinningInfo;

public class LottoService {

    public int valueIntegerConversion(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자는 입력할수 없습니다.");
        }
    }

    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
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
        return (allSumValue / purchaseMoney) * 100.0;
    }

    public int purchaseMoneyRemain(int purchaseMoney) {
        return purchaseMoney / 1000;
    }

}
