package baseball.model;

import java.util.List;

import static baseball.model.Validator.*;
import static baseball.utils.InputUtils.convertToIntegerList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputReceiver {

    public static List<Integer> getInputNumbers() {
        String inputNumbers = readLine();
        validateInputNumbers(inputNumbers);
        return convertToIntegerList(inputNumbers);
    }

    public static String getRestartYn() {
        String restartYn = readLine();
        validateRestartYn(restartYn);
        return restartYn;
    }

    private static void validateInputNumbers(String input) {
        validateInputType(input);
        validateInputSize(input);
        validateInputDuplicate(input);
        validateInputRange(input);
    }

    private static void validateRestartYn(String input) {
        validateInputYn(input);
    }

}
