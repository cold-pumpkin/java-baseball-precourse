package baseball.model;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

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

    @DisplayName("정답 숫자에 중복이 없는지 확인한다.")
    @Test
    void answerNumberDuplicateTest() {
        Set<Integer> answerSet = new HashSet<>(computer.getAnswerNumbers());
        assertThat(answerSet)
                .hasSize(3);
    }

}