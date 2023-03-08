public class DoorsFlipper {
    private boolean opened[];

    public DoorsFlipper(int i) {
        opened = new boolean[i];
    }

    public DoorsFlipper() {
        this(1);
    }

    public boolean isClosed(int doorPosition) {
        return !opened[doorPosition-1];
    }

    public void flip(int step) {
        for (int doorPosition = step-1; doorPosition < opened.length; doorPosition+=step) {
            opened[doorPosition] = !opened[doorPosition];
        }

    }
}
