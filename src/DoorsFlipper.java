public class DoorsFlipper {
    private boolean closed[];

    public DoorsFlipper(int i) {
        closed = new boolean[i];
    }

    public DoorsFlipper() {
        this(1);
    }

    public boolean isClosed(int i) {
        return !closed[i-1];
    }

    public void flip() {
        for (int j = 0; j < closed.length; j++) {
            closed[j] = !closed[j];
        }

    }
}
