package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;

public class OutputService {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String COMMA = ", ";
    private static final String WINNER_IS = "최종 우승자 : ";

    public static void startDisplayRoundResults() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void displayRoundResult(Cars cars) {
        cars.forEachCar((name, position) -> {
            System.out.println(name + " : " + "-".repeat(position.getPosition()));
        });
    }

    public static void displayWinners(List<String> winners) {
        String displayFormat = String.join(COMMA, winners);
        System.out.println(WINNER_IS + displayFormat);
    }
}
