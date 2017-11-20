package chess_game.gamepieces;

import chess_game.Board;
import chess_game.Location;
import chess_game.colors.PieceColor;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class MovementPiece extends GamePiece {

    public abstract PieceColor getPieceColor();

    public abstract Location getLocation();

    public abstract ArrayList<Location> getValidMoves(Board board);

    public abstract String getBoardSprite();

    public abstract void draw(GraphicsContext context, String sprite);

    public abstract void setLocation(Location location);
}
