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
        testPlayer = new Player(new ArrayList<ChessPiece>() {{
            add(new Pawn()); add(new Knight()); add(new Queen());
        }});
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
        assertEquals(testPlayer.getPlayerPieces(), testScoreboard.getObservedPieces());
    }

    @Test
    public void testPlayerPieceAddition() {
        testPlayer.addPiece(new Rook());
        assertEquals(testPlayer.getPlayerPieces(), testScoreboard.getObservedPieces());
    }

    @Test
    public void testPlayerPieceRemoval() {
        testPlayer.removePiece(testPlayer.getPlayerPieces().get(0));
        assertEquals(testPlayer.getPlayerPieces(), testScoreboard.getObservedPieces());
    }
}
