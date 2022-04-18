package baseball.controller;

import baseball.model.Game;

import static baseball.model.InputReceiver.getRestartYn;
import static baseball.model.constant.Constraint.YES;
import static baseball.view.ControllerMessageViewer.showRestartGuideMessage;

public class GameController {

    public GameController() {}

    public void execute() {
        Game game = new Game();
        do {
            game.init();
            game.play();
            showRestartGuideMessage();
        } while (isRestart());
    }

    private boolean isRestart() {
        return YES.equals(getRestartYn());
    }

}
