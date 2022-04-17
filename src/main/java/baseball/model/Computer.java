package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {

    private static final int NUMBER_OF_DIGITS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private List<Integer> answerNumbers;

    // TODO: 정답 숫자 생성 기능 구현
    public void generateAnswerNumbers() {
        answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < NUMBER_OF_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answerNumbers.contains(number))
                answerNumbers.add(number);
        }
    }

    // TODO: 결과 판단(볼 카운트) 기능 구현

    // TODO: 결과 판단(스트라이크 카운트) 기능 구현
}
