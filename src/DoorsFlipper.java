public class DoorsFlipper {
    private boolean closed = true;

    public DoorsFlipper(int i) {
        throw new RuntimeException();
    }

    public DoorsFlipper() {
        throw new RuntimeException();
    }

    public boolean isClosed(int i) {
        return closed;
    }

    public void flip(int i) {
        closed = !closed;
    }
}
