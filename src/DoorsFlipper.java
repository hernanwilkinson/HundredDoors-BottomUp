public class DoorsFlipper {
    private boolean closed = true;

    public boolean isClosed(int i) {
        return closed;
    }

    public void flip() {
        closed = false;
    }
}
