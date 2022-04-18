package baseball.view;

public class GameMessageViewer {

    private static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void showInputGuideMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE);
    }

    public static void showSuccessMessage() {
        System.out.println(ANSWER_MESSAGE);
    }

    public static void showHintMessage(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(buildHintMessage(balls, strikes));
    }

    private static String buildHintMessage(int balls, int strikes) {
        StringBuilder hintMessage = new StringBuilder();
        if (balls > 0) {
            hintMessage.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            hintMessage.append(strikes).append("스트라이크");
        }
        return hintMessage.toString().trim();
    }

}
