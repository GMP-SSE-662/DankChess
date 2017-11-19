package chess_game;

import chess_game.colors.PieceColor;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class ChessPiece implements Drawable {
    private Image boardSprite;
    private Image scoreboardSprite;
    private Location location;
    private PieceColor pieceColor;
    Constants.PlayerName owner;

    public ChessPiece(Constants.PlayerName owner, int row, int column){
        this.location = new Location(row, column);
        this.owner = owner;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(int row, int column){
        location = new Location(row, column);
    }

    public void setBoardSprite(Image image){
        this.boardSprite = image;
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
