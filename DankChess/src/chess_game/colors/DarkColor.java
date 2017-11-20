package chess_game.colors;

public class DarkColor implements PieceColor {
    @Override
    public String getColor() {
        return "dark";
    }

    public boolean equals(PieceColor color){
        if (color.getColor().equals(this.getColor())) return true;
        else return false;
    }
}
