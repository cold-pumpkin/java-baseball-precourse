package baseball.model;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.generateAnswerNumbers();
    }

    @DisplayName("세자리의 정답 숫자가 정상적으로 생성되었는지 확인한다.")
    @Test
    void generateAnswerNumbersTest() {
        assertThat(computer.getAnswerNumbers())
                .isNotEmpty()
                .hasOnlyElementsOfType(Integer.class)
                .hasSize(3)
                .doesNotContain(0);
    }
}