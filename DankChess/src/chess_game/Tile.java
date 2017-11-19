package chess_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tile implements Drawable {
    private Location location;

    public Tile(int row, int column){
        location = new Location(row, column);
    }

    /**
     * Draws the tile.
     * @param context the current canvas graphics context.
     */
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(location.getRow() * Constants.tileSize, location.getColumn() * Constants.tileSize,
                Constants.tileSize, Constants.tileSize);
    }

    /**
     * Sets the outline of the tile to specify a legal move.
     * @param context the current canvas graphics context.
     */
    public void setOutlineMovable(GraphicsContext context) {
        context.setStroke(Color.DARKBLUE);
        clearTile(context);
        draw(context);
        drawOutline(context);
    }

    /**
     * Sets the outline of the tile to specify no legal move or just normal tile.
     * @param context the current canvas graphics context.
     */
    public void setOutlineNormal(GraphicsContext context) {
        context.setStroke(getColor());
        clearTile(context);
        draw(context);
        drawOutline(context);
    }

    /**
     * Draws the an outline around a tile based on @param.
     * @param context the current canvas graphics context.
     */
    private void drawOutline(GraphicsContext context) {
        context.strokeRect(location.getRow() * Constants.tileSize + 1, location.getColumn() * Constants.tileSize + 1,
                Constants.tileSize - 2, Constants.tileSize - 2);
    }

    /**
     * Clears the entire tile.
     * @param context the current canvas graphics context.
     */
    private void clearTile(GraphicsContext context) {
        context.clearRect(location.getRow() * Constants.tileSize + 1, location.getColumn() * Constants.tileSize + 1,
                Constants.tileSize - 2, Constants.tileSize - 2);
    }

    /**
     * Gets the color based on the tile location.
     * @return the tile's color.
     */
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
