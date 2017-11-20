package chess_game.gamepieces.movements;

import chess_game.Board;
import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class Queen extends MovementPiece {

    public Queen(GamePiece gamePiece) {
        setPiece(gamePiece);
    }

    @Override
    public PieceColor getPieceColor() {
        return getPiece().getPieceColor();
    }

    @Override
    public Location getLocation() {
        return getPiece().getLocation();
    }

    @Override
    public void setLocation(Location location) {
        getPiece().setLocation(location);
    }

    @Override
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = getPiece().getValidMoves(board);
        validMoves.addAll(getDiagonalMoves(getLocation(), board));
        validMoves.addAll(getLateralMoves(getLocation(), board));
        validMoves = removeInvalidMoves(validMoves, board);

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return getPiece().getBoardSprite() + "Q";
    }
}
