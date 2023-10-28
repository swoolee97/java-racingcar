package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import racingcar.validator.InputValidator;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        InputValidator.validateCarNames(names);
        cars = generateCars(names);
    }

    private List<Car> generateCars(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNamesArray = names.replace(" ", "").split(",");
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void decideToMove() {
        cars.forEach(Car::decideToMove);
    }

    public void forEachCar(BiConsumer<Name, Position> carConsumer) {
        for (Car car : cars) {
            car.processNameAndPosition(carConsumer);
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> maxPosition == car.getCarPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

}
