package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.view.GameMessageViewer.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameMessageViewerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("입력 안내 메시지가 정상적으로 출력되는지 확인한다.")
    void showInputGuideMessageTest() {
        showInputGuideMessage();

        assertThat(outputStreamCaptor.toString())
                .isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    @DisplayName("정답 메시지가 정상적으로 출력되는지 확인한다.")
    void showSuccessMessageTest() {
        showSuccessMessage();

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("볼과 스트라이크 모두 없는 경우 힌트 메시지가 정상적으로 출력되는지 확인한다.")
    void showHintMessageWhenNothingTest() {
        showHintMessage(0, 0);

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼만 있는 경우 힌트 메시지가 정상적으로 출력되는지 확인한다.11")
    void showHintMessageWhenOnlyBallTest() {
        showHintMessage(1, 0);
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("1볼");
    }

    @Test
    @DisplayName("볼과 스트라이크 모두 있는 경우 힌트 메시지가 정상적으로 출력되는지 확인한다.")
    void showHintMessageWhenBallAndStrikeTest() {
        showHintMessage(2, 1);

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("스트라이크만 있는 경우 힌트 메시지가 정상적으로 출력되는지 확인한다.11")
    void showHintMessageWhenOnlyStrikeTest() {
        showHintMessage(0, 2);

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("2스트라이크");
    }


}