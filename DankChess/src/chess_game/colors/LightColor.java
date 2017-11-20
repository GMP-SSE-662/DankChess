package chess_game.colors;

public class LightColor implements PieceColor {
    private static PieceColor instance;

    public static PieceColor getLightPieceColor() {
        if (instance == null) {
            instance = new LightColor();
        }
        return instance;
    }

    private LightColor(){}
}
