import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HundredDoorsTests {
    @Test
    public void doorsStartClosed() {
        var doorsFlipper = new DoorsFlipper(1);

        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorEndsOpenedWhenFlippedFromClosed() {
        var doorsFlipper = new DoorsFlipper(1);
        doorsFlipper.flip(1);

        assertFalse(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorEndsClosedWhenFlippedFromOpened() {
        var doorsFlipper = new DoorsFlipper(1);
        doorsFlipper.flip(1);
        doorsFlipper.flip(1);

        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void canFlipMoreThanOneDoor() {
        var doorsFlipper = new DoorsFlipper(2);
        doorsFlipper.flip(1);

        assertFalse(doorsFlipper.isClosed(1));
        assertFalse(doorsFlipper.isClosed(2));
    }

    @Test
    public void canFlipWithStepBiggerThanOne() {
        var doorsFlipper = new DoorsFlipper(4);
        doorsFlipper.flip(2);

        assertTrue(doorsFlipper.isClosed(1));
        assertFalse(doorsFlipper.isClosed(2));
        assertTrue(doorsFlipper.isClosed(3));
        assertFalse(doorsFlipper.isClosed(4));
    }

    @Test
    public void flipAllDoorsWithManyPasses() {
        var doorsFlipper = new DoorsFlipper(4);
        doorsFlipper.flipAll();

        assertFalse(doorsFlipper.isClosed(1));
        assertTrue(doorsFlipper.isClosed(2));
        assertTrue(doorsFlipper.isClosed(3));
        assertFalse(doorsFlipper.isClosed(4));
    }

    @Test
    public void flipsCorrectlyForHundredDoors() {
        var doorsFlipper = new DoorsFlipper(100);
        doorsFlipper.flipAll();

        final List<Integer> opened = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        for (int doorPosition = 1; doorPosition <= 100; doorPosition++)
            assertEquals(!opened.contains(doorPosition),doorsFlipper.isClosed(doorPosition));
    }
}