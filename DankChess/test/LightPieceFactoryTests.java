import chess_game.Location;
import chess_game.colors.LightColor;
import chess_game.factories.ChessPieceFactory;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.movements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightPieceFactoryTests {
    private ChessPieceFactory testFactory;
    private GamePiece testPiece;
    private final int testCol = 4;
    private final int testRow = 4;

    @BeforeEach
    public void beforeEachTest() {
        testFactory = new LightPieceFactory();
    }

    @Test
    public void newLightPieceFactoryTest() {
        assertNotNull(testFactory);
    }

    @Test
    public void lightFactoryInstanceOfTest() {
        assertTrue(testFactory instanceof ChessPieceFactory && testFactory instanceof LightPieceFactory);
        assertFalse(testFactory instanceof DarkPieceFactory);
    }

    @Test
    public void createLightPawnTest() {
        testPiece = testFactory.createPawn(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Pawn);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_P");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createLightRookTest() {
        testPiece = testFactory.createRook(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Rook);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_R");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createLightKnightTest() {
        testPiece = testFactory.createKnight(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Knight);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_Kn");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createLightBishopTest() {
        testPiece = testFactory.createBishop(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Bishop);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_B");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createLightQueenTest() {
        testPiece = testFactory.createQueen(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Queen);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_Q");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createLightKingTest() {
        testPiece = testFactory.createKing(new Location(testCol, testRow));
        assertTrue(testPiece instanceof King);
        assertTrue(testPiece.getPieceColor() instanceof LightColor);
        assertEquals(testPiece.getBoardSprite(), "l_K");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }
}
