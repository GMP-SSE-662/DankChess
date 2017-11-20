import chess_game.Location;
import chess_game.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TileTests {
    private Tile testTile;
    private final int testCol = 4;
    private final int testRow = 4;
    private final int incorrectCol = 7;
    private final int incorrectRow = 10;

//    @BeforeEach
//    public void beforeEachTest() {
//        testTile = new Tile(testCol, testRow);
//    }
//
//    @Test
//    public void getIncorrectLocationTest() {
//        testTile = new Tile(testCol, testRow);
//        assertNotEquals(testTile.getLocation(), new Location(incorrectCol, incorrectRow));
//    }
//
//    @Test
//    public void getCorrectLocationTest() {
//        testTile = new Tile(testCol, testRow);
//        assertEquals(testTile.getLocation(), new Location(testCol, testRow));
//    }
}
