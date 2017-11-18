package view;

import chess_game.Constants;
import chess_game.Location;
import chess_game.powerups.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tile implements Drawable {
    private Location location;
    private Color color;

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(color);
        context.fillRect(location.getRow() * Constants.tileSize, location.getColumn() * Constants.tileSize,
                Constants.tileSize, Constants.tileSize);
    }
}
