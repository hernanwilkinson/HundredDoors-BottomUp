import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HundredDoorsTests {
    @Test
    public void doorsStartClosed() {
        var doorsFlipper = new DoorsFlipper();

        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorEndsOpenedWhenFlippedFromClosed() {
        var doorsFlipper = new DoorsFlipper();
        doorsFlipper.flip();

        assertFalse(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorEndsClosedWhenFlippedFromOpened() {
        var doorsFlipper = new DoorsFlipper();
        doorsFlipper.flip();
        doorsFlipper.flip();

        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void canFlipMoreThanOneWithAStep() {
        var doorsFlipper = new DoorsFlipper(2);
        doorsFlipper.flip();

        assertFalse(doorsFlipper.isClosed(1));
        assertFalse(doorsFlipper.isClosed(2));
    }
}