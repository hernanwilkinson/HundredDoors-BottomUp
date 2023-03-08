import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HundredDoorsTests {
    @Test
    public void doorsStartClosed() {
        var doorsFlipper = new DoorsFlipper();

        assertTrue(doorsFlipper.isClosed(1));
    }
}