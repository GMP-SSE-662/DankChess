import chess_game.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTests {

    @Test
    public void boardSizeTest() {
        assertEquals(Constants.BOARD_SIZE, 720);
    }

    @Test
    public void tileSizeTest() {
        assertEquals(Constants.TILE_SIZE, 90);
    }

    @Test
    public void tileNumberTest() {
        assertEquals(Constants.TILES_PER_SIDE, 8);
    }

    @Test
    public void errorStringTest() {
        assertEquals(Constants.ERROR_STRING, "ERROR");
    }
}
