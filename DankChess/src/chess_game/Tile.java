package chess_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tile implements Drawable {
    private Location location;

    public Tile(int row, int column){
        location = new Location(row, column);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(location.getRow() * Constants.tileSize, location.getColumn() * Constants.tileSize,
                Constants.tileSize, Constants.tileSize);
    }

    private Color getColor() {
        if (location.getRow() % 2 == 0) {
            if (location.getColumn() % 2 == 0) {
                return Color.WHITESMOKE;
            } else {
                return Color.WHEAT;
            }
        } else {
            if (location.getColumn() % 2 == 0) {
                return Color.WHEAT;
            } else {
                return Color.WHITESMOKE;
            }
        }
    }
}
