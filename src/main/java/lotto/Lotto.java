package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void duplicateCheck(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);
        if (uniqueValues.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 값을 입력해주세요.");
        }
    }


}
