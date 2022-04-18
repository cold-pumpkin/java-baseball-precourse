package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {

    private InputConverter() {}

    public static List<Integer> convertToIntegerList(String input) {
        List<Integer> numberList = new ArrayList<>();
        for (String s : input.split("")) {
            numberList.add(convertStringToInt(s));
        }
        return numberList;
    }

    private static int convertStringToInt(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 변환 에러입니다!");
        }
        return number;
    }

}
