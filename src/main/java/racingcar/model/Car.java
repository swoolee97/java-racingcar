package racingcar.model;

public class Car {
    private static final int MIN_MOVE_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void decideToMove(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
            position.movePosition();
        }
    }

    public boolean isWinner(Position maxPosition) {
        if (maxPosition.equals(position)) {
            return true;
        }
        return false;
    }

    public boolean isGreaterPositionThan(Position maxPosition) {
        return position.isGreaterThan(maxPosition);
    }

    public String getResultFormat() {
        return getNameFormat() + " : " + getPositionFormat();
    }

    public String getNameFormat() {
        return name.format();
    }

    private String getPositionFormat() {
        return position.format();
    }

    public Position position() {
        return this.position;
    }
}
