package baseball.model;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.init();
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

    @DisplayName("볼 카운트 기능을 확인한다.")
    @Test
    void countBallsTest() {
        List<Integer> playNumbers = Arrays.asList(6, 4, 1);
        List<Integer> answerNumbers = Arrays.asList(1, 4, 6);
        Computer computer = new Computer(answerNumbers);

        assertThat(computer.countBalls(playNumbers))
                .isEqualTo(2);
    }

    @DisplayName("스트라이크 카운트 기능을 확인한다.")
    @Test
    void countStrikesTest() {
        List<Integer> playNumbers = Arrays.asList(6, 4, 1);
        List<Integer> answerNumbers = Arrays.asList(1, 4, 6);
        Computer computer = new Computer(answerNumbers);

        assertThat(computer.countStrikes(playNumbers))
                .isEqualTo(1);
    }

}