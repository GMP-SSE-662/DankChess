package chess_game.colors;

public class LightColor implements PieceColor {
    @Override
    public String getColor() {
        return "light";
    }

    public boolean equals(PieceColor color){
        if (color.getColor().equals(this.getColor())) return true;
        else return false;
    }
}
