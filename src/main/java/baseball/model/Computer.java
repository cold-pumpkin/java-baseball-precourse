package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.constant.Constraint.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {

    private List<Integer> answerNumbers;

    Computer(){};

    // 테스트 코드에서만 사용
    Computer(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void init() {
        answerNumbers = new ArrayList<>();
        generateAnswerNumbers();
    }

    public int countBalls(List<Integer> playerNumbers) {
        int balls = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            balls += addBallByCondition(answerNumbers.get(i), playerNumbers.get(i));
        }
        return balls;
    }

    public int countStrikes(List<Integer> playerNumbers) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            strikes += addStrikeByCondition(answerNumbers.get(i), playerNumbers.get(i));
        }
        return strikes;
    }


    private void generateAnswerNumbers() {
        while (answerNumbers.size() < NUMBER_OF_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addUniqueNumber(number);
        }
    }

    private void addUniqueNumber(int number) {
        if (!answerNumbers.contains(number))
            answerNumbers.add(number);
    }

    private int addBallByCondition(int answerNumber, int playerNumber) {
        if (answerNumber != playerNumber
                && answerNumbers.contains(playerNumber)) {
            return 1;
        }
        return 0;
    }

    private int addStrikeByCondition(int answerNumber, int playerNumber) {
        if (answerNumber == playerNumber) {
            return 1;
        }
        return 0;
    }

    // 테스트 코드에서만 사용
    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

}
