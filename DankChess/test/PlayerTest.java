
import chess_game.Player;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {
    Player testPlayer;

    @BeforeEach
    public void beforeEachTest() {

    }

    @Test
    public void newPlayerTest() {
        testPlayer = new Player(null);
        assertNotNull(testPlayer);
    }

    @Test
    public void nullPlayerFactoryToStringTest() {
        testPlayer = new Player(null);
        assertEquals(testPlayer.toString(), "ERROR");
    }

    @Test
    public void lightPlayerFactoryToStringTest() {
        testPlayer = new Player(new LightPieceFactory());
        assertEquals(testPlayer.toString(), "Light Player");
    }

    @Test
    public void darkPlayerFactoryToStringTest() {
        testPlayer = new Player(new DarkPieceFactory());
        assertEquals(testPlayer.toString(), "Dark Player");
    }
}
