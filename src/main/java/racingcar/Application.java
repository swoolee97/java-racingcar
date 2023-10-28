package racingcar;

import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        RacingGameService racingGame = new RacingGameService();
        racingGame.play();
    }
}
