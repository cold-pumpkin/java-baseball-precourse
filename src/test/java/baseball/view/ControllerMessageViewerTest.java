package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.view.ControllerMessageViewer.showRestartGuideMessage;
import static org.assertj.core.api.Assertions.assertThat;

class ControllerMessageViewerTest {

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
        showRestartGuideMessage();

        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}