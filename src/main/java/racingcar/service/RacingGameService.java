package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;

public class RacingGameService {

    private Cars cars;
    private TryNumber tryNumber;

    public void play() {
        initialize();
        raceStart();
        displayWinners();
    }

    private void initialize() {
        cars = new Cars(InputService.readCarNames());
        tryNumber = new TryNumber(InputService.readTryNumber());
    }

    private void raceStart() {
        int count = 0;
        OutputService.startDisplayRoundResults();
        while (!tryNumber.isOver(count)) {
            cars.decideToMove();
            OutputService.displayRoundResult(cars);
            count++;
        }
    }

    private void displayWinners() {
        List<String> winners = cars.getWinners();
        OutputService.displayWinners(winners);
    }

}
