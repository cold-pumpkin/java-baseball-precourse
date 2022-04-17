package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.model.Computer.NUMBER_OF_DIGITS;
import static baseball.model.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("입력값에 숫자가 아닌 값이 포함되어 있으면 IllegalArgumentException을 발생시킨다.")
    void validateInputTypeTest() {
        assertThatThrownBy(() -> {
            validateInputType("A12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요!");
    }

    @Test
    @DisplayName("입력값이 정해진 길이가 아니면 IllegalArgumentException을 발생시킨다.")
    void validateInputSizeTest() {
        assertThatThrownBy(() -> {
            validateInputSize("3129");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 " + NUMBER_OF_DIGITS + "개를 입력해주세요!");
    }

    @Test
    @DisplayName("입력값에 중복값이 존재하면 IllegalArgumentException을 발생시킨다.")
    void validateInputDuplicateTest() {
        assertThatThrownBy(() -> {
            validateInputDuplicate("166");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복일 수 없습니다.");
    }

}