package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {

    public static final int NUMBER_OF_DIGITS = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private List<Integer> answerNumbers;

    Computer(){};

    Computer(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    // TODO: 정답 숫자 생성 기능 구현
    public void generateAnswerNumbers() {
        answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < NUMBER_OF_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addUniqueNumber(number);
        }
    }

    private void addUniqueNumber(int number) {
        if (!answerNumbers.contains(number))
            answerNumbers.add(number);
    }

    // TODO: 결과 판단(볼 카운트) 기능 구현
    public int countBalls(List<Integer> playerNumbers) {
        int balls = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            balls += addBallByCondition(answerNumbers.get(i), playerNumbers.get(i));
        }
        return balls;
    }

    private int addBallByCondition(int answerNumber, int playerNumber) {
        if (answerNumber != playerNumber
                && answerNumbers.contains(playerNumber)) {
            return 1;
        }
        return 0;
    }

    // TODO: 결과 판단(스트라이크 카운트) 기능 구현
    public int countStrikes(List<Integer> playerNumbers) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            strikes += addStrikeByCondition(answerNumbers.get(i), playerNumbers.get(i));
        }
        return strikes;
    }

    private int addStrikeByCondition(int answerNumber, int playerNumber) {
        if (answerNumber == playerNumber) {
            return 1;
        }
        return 0;
    }

    // ** Getter
    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

}
