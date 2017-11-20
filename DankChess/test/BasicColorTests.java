import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;
import chess_game.colors.PieceColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicColorTests {
    private PieceColor testColor;

    @Test
    public void newDarkColorTest() {
        testColor = DarkColor.getDarkPieceColor();
        assertNotNull(testColor);
    }

    @Test
    public void newLightColorTest() {
        testColor = LightColor.getLightPieceColor();
        assertNotNull(testColor);
    }

    @Test
    public void darkInstanceOfTest() {
        testColor = DarkColor.getDarkPieceColor();
        assertTrue(testColor instanceof PieceColor && testColor instanceof DarkColor);
        assertFalse(testColor instanceof LightColor);
    }

    @Test
    public void lightInstanceOfTest() {
        testColor = LightColor.getLightPieceColor();
        assertTrue(testColor instanceof PieceColor && testColor instanceof LightColor);
        assertFalse(testColor instanceof DarkColor);
    }
}
