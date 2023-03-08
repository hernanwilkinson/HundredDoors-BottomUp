public class DoorsFlipper {
    public static final String INVALID_NUMBER_OF_DOORS = "Number of doors must be strictly positive";
    public static final String INVALID_FLIP_STEP = "Step must be between 1 and number of doors";
    public static final String INVALID_DOOR_POSITION = "Door position must be between 1 and number of doors";
    private boolean opened[];

    public DoorsFlipper(int numberOfDoors) {
        assertValidNumberOfDoors(numberOfDoors);

        opened = new boolean[numberOfDoors];
    }

    private void assertValidNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <1) throw new IllegalArgumentException(INVALID_NUMBER_OF_DOORS);
    }

    public boolean isClosed(int doorPosition) {
        try {
            return !opened[doorPosition - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_DOOR_POSITION);
        }
    }

    public void flipEvery(int step) {
        assertIsValidStep(step);

        for (int doorPosition = step-1; doorPosition < opened.length; doorPosition+=step)
            opened[doorPosition] = !opened[doorPosition];
    }

    private void assertIsValidStep(int step) {
        if (step <1 || step >opened.length) throw new IllegalArgumentException(INVALID_FLIP_STEP);
    }

    public void flipAll() {
        for (int step = 1; step <= opened.length; step++)
            flipEvery(step);
    }
}
