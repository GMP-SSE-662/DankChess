import chess_game.ChessPiece;
import chess_game.Player;
import chess_game.Scoreboard;
import chess_game.pieces.Knight;
import chess_game.pieces.Pawn;
import chess_game.pieces.Queen;
import chess_game.pieces.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreBoardTest
{
    Player testPlayer;
    Scoreboard testScoreboard;

    @BeforeEach
    public void beforeEachTest() {
        testPlayer = new Player();
        testPlayer.takePiece(new Rook());
        testPlayer.takePiece(new Pawn());
        testPlayer.takePiece(new Pawn());
        testPlayer.takePiece(new Knight());
        testPlayer.takePiece(new Queen());
        testScoreboard = new Scoreboard(testPlayer);
    }

    @Test
    public void newScoreboardTest() {
        Scoreboard testScoreboard = new Scoreboard(new Player());
        assertNotNull(testScoreboard);
    }

    @Test
    public void playerScoreboardTest() {
        Scoreboard testScoreboard = new Scoreboard(testPlayer);
        assertEquals(testPlayer.getTakenPieces(), testScoreboard.getObservedPieces());
    }

    @Test
    public void testPlayerAttack() {
        testPlayer.takePiece(new Rook());
        assertEquals(testPlayer.getTakenPieces(), testScoreboard.getObservedPieces());
    }
}
