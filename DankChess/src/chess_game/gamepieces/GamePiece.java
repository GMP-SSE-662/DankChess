package chess_game.gamepieces;

import chess_game.Board;
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

    public abstract ArrayList<Location> getValidMoves(Board board);

    public abstract String getBoardSprite();

    public void draw(GraphicsContext gc) {
        gc.strokeText(getBoardSprite(), getLocation().getColumn() * Constants.TILE_SIZE + Constants.TILE_SIZE / 3,
                (getLocation().getRow() + 1) * Constants.TILE_SIZE - Constants.TILE_SIZE / 3, Constants.TILE_SIZE / 3);
    }
}
