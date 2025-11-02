package model;

public enum LottoMessage {
    USER_INPUT_PURCHASE_MONEY_VIEW("구입금액을 입력해 주세요."),
    USER_INPUT_WINNING_NUMBERS_VIEW("\n당첨 번호를 입력해 주세요."),
    USER_INPUT_BONUS_NUMBER_VIEW("\n보너스 번호를 입력해 주세요."),

    PURCHASE_LOTTO_COUNT_VIEW("\n%d개를 구매했습니다."),
    LOTTO_STATISTICS_VIEW("\n당첨 통계\n---"),
    INFO_RANK_5("3개 일치 (5,000원) - %d개"),
    INFO_RANK_4("4개 일치 (50,000원) - %d개"),
    INFO_RANK_3("5개 일치 (1,500,000원) - %d개"),
    INFO_RANK_2("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    INFO_RANK_1("6개 일치 (2,000,000,000원) - %d개"),
    LOTTO_RESULT("총 수익률은 %.1f%%입니다."),

    PURCHASE_MONEY_REMAINDER("[ERROR] 1,000원 단위가 아닙니다."),
    NUMBER_NEGATIVE("[ERROR] 음수는 입력이 안됩니다."),
    ERROR_NOT_NUMBER("[ERROR] 문자는 입력할수 없습니다."),
    CHECK_DECIMAL_POINT("[ERROR] 입력값은 정수어야 합니다."),
    NUMBERS_RANGE_VALIDATION("[ERROR] 입력값은 1부터 45 사이의 중복되지 않는 정수입니다."),
    DUPLICATE_CHECK_WINNING_NUMBER("[ERROR] 중복되지 않은 당첨 번호를 입력해주세요."),
    WINNING_NUMBERS_DUPLICATE_CHECK("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LENGTH_CHECK("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String lottoMessage;

    LottoMessage(String lottoMessage) {
        this.lottoMessage = lottoMessage;
    }

    public String getLottoMessage() {
        return lottoMessage;
    }

    public String format(Object value) {
        return String.format(lottoMessage, value);
    }
}
