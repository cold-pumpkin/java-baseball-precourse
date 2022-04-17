package baseball.model;

import java.util.HashMap;
import java.util.Map;

import static baseball.model.Computer.NUMBER_OF_DIGITS;

public class Validator {

    private Validator() {
    }

    public static void validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요!");
        }
    }

    public static void validateInputSize(String input) {
        if (input.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("숫자 " + NUMBER_OF_DIGITS + "개를 입력해주세요!");
        }
    }

    public static void validateInputDuplicate(String input) {
        Map<Character, Boolean> inputMap = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            inputMap.put(ch, true);
        }
        if (inputMap.size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("숫자는 중복일 수 없습니다.");
        }
    }

}
