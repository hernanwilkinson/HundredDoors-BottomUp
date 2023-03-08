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
        doorsFlipper.flipEvery(1);

        assertFalse(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorEndsClosedWhenFlippedFromOpened() {
        var doorsFlipper = new DoorsFlipper(1);
        doorsFlipper.flipEvery(1);
        doorsFlipper.flipEvery(1);

        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void canFlipMoreThanOneDoor() {
        var doorsFlipper = new DoorsFlipper(2);
        doorsFlipper.flipEvery(1);

        assertFalse(doorsFlipper.isClosed(1));
        assertFalse(doorsFlipper.isClosed(2));
    }

    @Test
    public void canFlipWithStepBiggerThanOne() {
        var doorsFlipper = new DoorsFlipper(4);
        doorsFlipper.flipEvery(2);

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

    @Test
    public void numberOfDoorsMustBeStrictlyPositive() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                ()->new DoorsFlipper(0));
        assertEquals(DoorsFlipper.INVALID_NUMBER_OF_DOORS,exception.getMessage());
    }

    @Test
    public void flipStepMustBeStrictlyPositive() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                IllegalArgumentException.class,
                ()->doorsFlipper.flipEvery(0));
        assertEquals(DoorsFlipper.INVALID_FLIP_STEP,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void flipStepMustLessOrEqualToDoorsSize() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                IllegalArgumentException.class,
                ()->doorsFlipper.flipEvery(2));
        assertEquals(DoorsFlipper.INVALID_FLIP_STEP,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(1));
    }

    @Test
    public void doorPositionMustBeStrictlyPositive() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                IllegalArgumentException.class,
                ()->doorsFlipper.isClosed(0));
        assertEquals(DoorsFlipper.INVALID_DOOR_POSITION,exception.getMessage());
    }

    @Test
    public void doorPositionMustLessOrEqualToNumberOfDoors() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                IllegalArgumentException.class,
                ()->doorsFlipper.isClosed(2));
        assertEquals(DoorsFlipper.INVALID_DOOR_POSITION,exception.getMessage());
    }
}