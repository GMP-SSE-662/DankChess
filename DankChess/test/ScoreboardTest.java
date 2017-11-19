import chess_game.ChessPiece;
import chess_game.Constants;
import chess_game.Player;
import chess_game.Scoreboard;
import chess_game.pieces.Knight;
import chess_game.pieces.Pawn;
import chess_game.pieces.Queen;
import chess_game.pieces.Rook;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreboardTest
{
    final int testBoardSize = Constants.smallBoardSize;

    Player testPlayer;
    Scoreboard testScoreboard;

    @BeforeEach
    public void beforeEachTest() {
        testPlayer = new Player(Constants.PlayerName.PLAYER1);
        testPlayer.takePiece(new Rook());
        testPlayer.takePiece(new Pawn());
        testPlayer.takePiece(new Pawn());
        testPlayer.takePiece(new Knight());
        testPlayer.takePiece(new Queen());
        testScoreboard = new Scoreboard(testPlayer, testBoardSize);
    }

    @Test
    public void newScoreboardTest() {
        testScoreboard = new Scoreboard(new Player(Constants.PlayerName.PLAYER1), testBoardSize);
        assertNotNull(testScoreboard);
    }

    @Test
    public void playerScoreboardTest() {
        testScoreboard = new Scoreboard(testPlayer, testBoardSize);
        assertEquals(testPlayer.getTakenPieces(), testScoreboard.getObservedPieces());
    }

    @Test
    public void testPlayerAttack() {
        testPlayer.takePiece(new Rook());
        assertEquals(testPlayer.getTakenPieces(), testScoreboard.getObservedPieces());
    }
}
