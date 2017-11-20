package chess_game.gamepieces.movements;

import chess_game.Board;
import chess_game.Constants;
import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Bishop extends MovementPiece {

    GamePiece gamePiece;

    public Bishop(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    @Override
    public PieceColor getPieceColor() {
        return gamePiece.getPieceColor();
    }

    @Override
    public Location getLocation() {
        return gamePiece.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        gamePiece.setLocation(location);
    }

    @Override
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = gamePiece.getValidMoves(board);
        validMoves.addAll(getDiagonalMoves(getLocation(), board));
        validMoves = removeInvalidMoves(validMoves, board);
        return validMoves;
    }

    public void draw(GraphicsContext context, String sprite){
        gamePiece.draw(context, sprite);
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "B";
    }
}
