package chess_game.colors;

public class DarkColor implements PieceColor {
    private static PieceColor instance;

    public static PieceColor getDarkPieceColor() {
        if (instance == null) {
            instance = new DarkColor();
        }
        return instance;
    }

    private DarkColor(){}
}
