package chess_game;

import chess_game.powerups.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class ChessPiece implements Drawable {
    private Image sprite;

    private Location location;

    public Location getLocation(){
        return location;
    }

    public void setLocation(int row, int column){
        location = new Location(row, column);
    }

    public abstract ArrayList<Location> getValidMoves();

    public void draw(GraphicsContext gc){
        gc.drawImage(sprite, location.getRow() * Constants.tileSize, location.getColumn() * Constants.tileSize);
    }
}
