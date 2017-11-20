package chess_game.gamepieces.movements;

import chess_game.Board;
import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class Knight extends MovementPiece {

    private GamePiece gamePiece;

    public Knight(GamePiece gamePiece) {
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
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() + 2));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() + 2));
        validMoves.add(new Location(getLocation().getColumn() + 2, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() - 2, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() - 2));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() - 2));
        validMoves.add(new Location(getLocation().getColumn() + 2, getLocation().getRow() - 1));
        validMoves.add(new Location(getLocation().getColumn() - 2, getLocation().getRow() - 1));
        validMoves = removeInvalidMoves(validMoves, board);
        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "Kn";
    }
}
