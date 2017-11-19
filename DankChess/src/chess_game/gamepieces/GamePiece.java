package chess_game.gamepieces;

import chess_game.Constants;
import chess_game.Drawable;
import chess_game.Location;
import chess_game.colors.PieceColor;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GamePiece implements Drawable {
    private PieceColor pieceColor;
    private Location location;

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(int row, int column) {
        location = new Location(row, column);
    }

    public abstract ArrayList<Location> getValidMoves();

    public abstract String getBoardSprite();

    public void draw(GraphicsContext gc) {
        gc.strokeText(getBoardSprite(), getLocation().getRow() * Constants.TILE_SIZE,
                (getLocation().getColumn() + 1) * Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}