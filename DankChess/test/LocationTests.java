import chess_game.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTests {
    private Location testLocation;
    private final int testCol = 4;
    private final int testRow = 4;
    private final int incorrectCol = 7;
    private final int incorrectRow = 10;

    @BeforeEach
    public void beforeEachTest() {
        testLocation = new Location(testCol, testRow);
    }

    @Test
    public void newLocationTest() {
        assertNotNull(testLocation);
    }

    @Test
    public void getColumnTest() {
        assertEquals(testLocation.getColumn(), testCol);
    }

    @Test void getRowTest() {
        assertEquals(testLocation.getRow(), testRow);
    }

    @Test
    public void getColumnIncorrectTest() {
        assertNotEquals(testLocation.getColumn(), incorrectCol);
    }

    @Test
    public void getRowIncorrectTest() {
        assertNotEquals(testLocation.getRow(), incorrectRow);
    }

    @Test
    public void locationEqualsNotInstanceTest() {
        assertFalse(testLocation.equals("Quidditch"));
    }

    @Test
    public void locationEqualsFalseColTest() {
        assertFalse(testLocation.equals(new Location(incorrectCol, testRow)));
    }

    @Test
    public void locationEqualsFalseRowTest() {
        assertFalse(testLocation.equals(new Location(testCol, incorrectRow)));
    }

    @Test
    public void locationEqualsFalseRowColTest() {
        assertFalse(testLocation.equals(new Location(incorrectCol, incorrectRow)));
    }

    @Test
    public void locationEqualsTrueTest() {
        assertTrue(testLocation.equals(new Location(testCol, testRow)));
    }
}
