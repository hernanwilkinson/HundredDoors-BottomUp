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

    public void flip() {
        for (int j = 0; j < opened.length; j++) {
            opened[j] = !opened[j];
        }

    }
}
