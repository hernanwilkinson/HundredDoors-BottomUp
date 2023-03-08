public class DoorsFlipper {
    private boolean opened[];

    public DoorsFlipper(int i) {
        opened = new boolean[i];
    }

    public DoorsFlipper() {
        this(1);
    }

    public boolean isClosed(int i) {
        return !opened[i-1];
    }

    public void flip(int step) {
        for (int j = step-1; j < opened.length; j+=step) {
            opened[j] = !opened[j];
        }

    }
}
