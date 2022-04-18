package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.model.Computer.*;
import static baseball.utils.InputUtils.convertToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilsTest {

    @Test
    @DisplayName("입력 문자열을 잘라 Integer 리스트로 변환한다.")
    void convertToIntegerListTest() {
        List<Integer> playerNumbers = convertToIntegerList("927");
        assertThat(playerNumbers)
                .isNotEmpty()
                .hasSize(NUMBER_OF_DIGITS)
                .isInstanceOf(List.class)
                .hasOnlyElementsOfType(Integer.class)
                .allSatisfy(number ->
                        assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER));
    }

    @Test
    @DisplayName("입력 문자열을 Integer 리스트로 변환에 실패하면 IllegalArgumentException을 발생시킨다.")
    void convertToIntegerListExceptionTest() {
        assertThatThrownBy(() -> {
            convertToIntegerList("9A7");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 변환 에러입니다!");
    }

}