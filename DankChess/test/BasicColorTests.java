import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;
import chess_game.colors.PieceColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicColorTests {
    private PieceColor testColor;

    @Test
    public void newDarkColorTest() {
        testColor = new DarkColor();
        assertNotNull(testColor);
    }

    @Test
    public void newLightColorTest() {
        testColor = new LightColor();
        assertNotNull(testColor);
    }

    @Test
    public void darkInstanceOfTest() {
        testColor = new DarkColor();
        assertTrue(testColor instanceof PieceColor && testColor instanceof DarkColor);
        assertFalse(testColor instanceof LightColor);
    }

    @Test
    public void lightInstanceOfTest() {
        testColor = new LightColor();
        assertTrue(testColor instanceof PieceColor && testColor instanceof LightColor);
        assertFalse(testColor instanceof DarkColor);
    }
}
