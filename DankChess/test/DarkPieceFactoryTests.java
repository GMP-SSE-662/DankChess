import chess_game.Location;
import chess_game.colors.DarkColor;
import chess_game.factories.ChessPieceFactory;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.movements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DarkPieceFactoryTests {
    private ChessPieceFactory testFactory;
    private GamePiece testPiece;
    private final int testCol = 4;
    private final int testRow = 4;

    @BeforeEach
    public void beforeEachTest() {
        testFactory = new DarkPieceFactory();
    }

    @Test
    public void newDarkPieceFactoryTest() {
        assertNotNull(testFactory);
    }

    @Test
    public void darkFactoryInstanceOfTest() {
        assertTrue(testFactory instanceof ChessPieceFactory && testFactory instanceof DarkPieceFactory);
        assertFalse(testFactory instanceof LightPieceFactory);
    }

    @Test
    public void createDarkPawnTest() {
        testPiece = testFactory.createPawn(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Pawn);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_P");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createDarkRookTest() {
        testPiece = testFactory.createRook(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Rook);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_R");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createDarkKnightTest() {
        testPiece = testFactory.createKnight(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Knight);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_Kn");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createDarkBishopTest() {
        testPiece = testFactory.createBishop(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Bishop);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_B");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createDarkQueenTest() {
        testPiece = testFactory.createQueen(new Location(testCol, testRow));
        assertTrue(testPiece instanceof Queen);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_Q");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }

    @Test
    public void createDarkKingTest() {
        testPiece = testFactory.createKing(new Location(testCol, testRow));
        assertTrue(testPiece instanceof King);
        assertTrue(testPiece.getPieceColor() instanceof DarkColor);
        assertEquals(testPiece.getBoardSprite(), "d_K");
        assertEquals(testPiece.getLocation(), new Location(testCol, testRow));
    }
}
