import chess_game.Location;
import chess_game.gamepieces.BaseChessPiece;
import chess_game.gamepieces.GamePiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GamePieceTests {
    GamePiece testPiece;

    @BeforeEach
    public void beforeEachTest() {
        testPiece = new BaseChessPiece();
    }

    @Test
    public void newBaseChessPieceTest() {
        assertNotNull(testPiece);
    }

    @Test
    public void getNullBaseLocationTest() {
        assertNull(testPiece.getLocation());
    }

    @Test
    public void getSetBaseLocationTest() {
        testPiece.setLocation(new Location (4, 4));
        assertEquals(testPiece.getLocation(), new Location(4, 4));
    }
}