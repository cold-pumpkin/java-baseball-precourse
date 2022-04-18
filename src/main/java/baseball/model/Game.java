package baseball.model;

import java.util.List;

import static baseball.model.constant.Constraint.NUMBER_OF_DIGITS;
import static baseball.model.InputReceiver.getInputNumbers;
import static baseball.view.GameMessageViewer.*;

public class Game {

    private int balls;
    private int strikes;
    private final Computer computer;

    public Game () {
        this.balls = 0;
        this.strikes = 0;
        this.computer = new Computer();
    }

    public void init() {
        balls = 0;
        strikes = 0;
        computer.init();
    }

    public void play() {
        List<Integer> playerNumbers;
        while (!isAllStrike()) {
            showInputGuideMessage();
            playerNumbers = getInputNumbers();

            balls = computer.countBalls(playerNumbers);
            strikes = computer.countStrikes(playerNumbers);

            showHintMessage(balls, strikes);
        }
        showSuccessMessage();
    }

    private boolean isAllStrike() {
        return strikes >= NUMBER_OF_DIGITS;
    }

}
