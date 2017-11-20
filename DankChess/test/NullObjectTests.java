import chess_game.*;
import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;
import chess_game.colors.PieceColor;
import chess_game.factories.ChessPieceFactory;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.BaseChessPiece;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;
import chess_game.gamepieces.movements.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class NullObjectTests {
    private Location testLocation;
    private PieceColor testPieceColor;
    private DarkColor testDarkColor;
    private LightColor testLightColor;
    private GamePiece testGamePiece;
    private BaseChessPiece testBasePiece;
    private MovementPiece testMovePiece;
    private Bishop testBishop;
    private King testKing;
    private Knight testKnight;
    private Pawn testPawn;
    private Queen testQueen;
    private Rook testRook;
    private ChessPieceFactory testFactory;
    private DarkPieceFactory testDarkFactory;
    private LightPieceFactory testLightFactory;
    private Tile testTile;
    private Board testBoard;
    private Constants testConstants;
    private Drawable testDrawable;
    private TurnManager testTurnManger;

    @Test
    public void nullLocationTest() {
        assertNull(testLocation);
    }

    @Test
    public void nullPieceColorTest() {
        assertNull(testPieceColor);
    }

    @Test
    public void nullDarkColorTest() {
        assertNull(testDarkColor);
    }

    @Test
    public void nullLightColorTest() {
        assertNull(testLightColor);
    }

    @Test
    public void nullGamePieceTest() {
        assertNull(testGamePiece);
    }

    @Test
    public void nullBasePieceTest() {
        assertNull(testBasePiece);
    }

    @Test
    public void nullMovePieceTest() {
        assertNull(testMovePiece);
    }

    @Test
    public void nullBishopTest() {
        assertNull(testBishop);
    }

    @Test
    public void nullKingTest() {
        assertNull(testKing);
    }

    @Test
    public void nullKnightTest() {
        assertNull(testKnight);
    }

    @Test
    public void nullPawnTest() {
        assertNull(testPawn);
    }

    @Test
    public void nullQueenTest() {
        assertNull(testQueen);
    }

    @Test
    public void nullRookTest() {
        assertNull(testRook);
    }

    @Test
    public void nullChessPieceFactoryTest() {
        assertNull(testFactory);
    }

    @Test
    public void nullDarkPieceFactoryTest() {
        assertNull(testDarkFactory);
    }

    @Test
    public void nullLightPieceFactoryTest() {
        assertNull(testLightFactory);
    }

    @Test
    public void nullTileTest() {
        assertNull(testTile);
    }

    @Test
    public void nullBoardTest() {
        assertNull(testBoard);
    }

    @Test
    public void nullConstantsTest() {
        assertNull(testConstants);
    }

    @Test
    public void nullDrawableTest() {
        assertNull(testDrawable);
    }

    @Test
    public void nullTurnMangerTest() {
        assertNull(testTurnManger);
    }
}
