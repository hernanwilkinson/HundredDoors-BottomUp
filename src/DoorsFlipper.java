public class DoorsFlipper {
    public static final String INVALID_NUMBER_OF_DOORS = "Number of doors must be strictly positive";
    public static final String INVALID_FLIP_STEP = "Step must be between 1 and number of doors";
    private boolean opened[];

    public DoorsFlipper(int numberOfDoors) {
        assertValidNumberOfDoors(numberOfDoors);

        opened = new boolean[numberOfDoors];
    }

    private void assertValidNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <1) throw new IllegalArgumentException(INVALID_NUMBER_OF_DOORS);
    }

    public boolean isClosed(int doorPosition) {
        return !opened[doorPosition-1];
    }

    public void flipEvery(int step) {
        if (step<1) throw new IllegalArgumentException(INVALID_FLIP_STEP);

        for (int doorPosition = step-1; doorPosition < opened.length; doorPosition+=step)
            opened[doorPosition] = !opened[doorPosition];
    }

    public void flipAll() {
        for (int step = 1; step <= opened.length; step++)
            flipEvery(step);
    }
}
