package baseball.view;

public class ControllerMessageViewer {

    private static final String RESTART_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void showRestartGuideMessage() {
        System.out.println(RESTART_GUIDE_MESSAGE);
    }

}
