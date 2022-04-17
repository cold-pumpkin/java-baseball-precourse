package baseball.model;

import static baseball.model.Validator.*;

public class Game {

    // TODO: 숫자 입력 안내 기능 구현

    // TODO: 입력값 체크 기능 구현
    private void validatePlayerInput(String playerInput) {
        validateInputType(playerInput);
        validateInputSize(playerInput);
        validateInputDuplicate(playerInput);
        validateInputRange(playerInput);
    }

    // TODO: 결과 메시지 출력 기능 구현
}
