package chess_game;

import chess_game.colors.PieceColor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class ChessPiece implements Drawable {
    private Image boardSprite;
    private Image scoreboardSprite;
    private Location location;
    private PieceColor pieceColor;

    public Location getLocation(){
        return location;
    }

    public void setLocation(int row, int column){
        location = new Location(row, column);
    }

    public abstract ArrayList<Location> getValidMoves();

    public void draw(GraphicsContext gc) {
        gc.drawImage(boardSprite, location.getRow() * Constants.tileSize, location.getColumn() * Constants.tileSize);
    }

    public void drawOnScoreboard(GraphicsContext gc, int horizontalIndex, int verticalIndex) {
        gc.drawImage(scoreboardSprite, horizontalIndex * Constants.scoreboardPieceSize,
                verticalIndex * Constants.scoreboardPieceSize);
    }
}
