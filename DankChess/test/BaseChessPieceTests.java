import chess_game.Location;
import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;
import chess_game.gamepieces.BaseChessPiece;
import chess_game.gamepieces.GamePiece;
import javafx.scene.effect.Light;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BaseChessPieceTests {
    GamePiece testPiece;
    private final int testCol = 4;
    private final int testRow = 4;
    private final int incorrectCol = 7;
    private final int incorrectRow = 10;

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
        testPiece.setLocation(new Location (testCol, testRow));
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
        assertNotEquals(testPiece.getLocation(), new Location(incorrectCol, incorrectRow));
    }

    @Test
    public void getNullBaseColorTest() {
        assertNull(testPiece.getPieceColor());
    }

    @Test
    public void getSetBaseColorTest() {
        testPiece.setPieceColor(new DarkColor());
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertFalse(testPiece.getPieceColor() instanceof LightColor);
        testPiece.setPieceColor(new LightColor());
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertFalse(testPiece.getPieceColor() instanceof DarkColor);
    }

    @Test
    public void getBaseValidMovesTest() {
        assertEquals(testPiece.getValidMoves(null), new ArrayList<Location>());
    }

    @Test
    public void getBaseSpriteTest() {
        assertEquals(testPiece.getBoardSprite(), "ERROR");
        testPiece.setPieceColor(new DarkColor());
        assertEquals(testPiece.getBoardSprite(), "d_");
        testPiece.setPieceColor(new LightColor());
        assertEquals(testPiece.getBoardSprite(), "l_");
    }
}