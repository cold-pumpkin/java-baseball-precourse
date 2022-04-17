package baseball.model;

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

}
