package chess_game.gamepieces.movements;

import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;
import chess_game.colors.LightColor;

import java.util.ArrayList;

public class Pawn extends MovementPiece {

    GamePiece gamePiece;

    public Pawn(GamePiece gamePiece) {
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

    /**
     * Row + 1 is down on the board, so the direction for dark pieces (starting at the top)
     * is positive while light pieces (starting at the bottom) is negative.
     * @return all potentially valid moves.
     */
    @Override
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = gamePiece.getValidMoves();
        int direction = getPieceColor() instanceof LightColor ? -1 : 1;

        validMoves.add(new Location(getLocation().getColumn(), getLocation().getRow() + direction));
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() + direction));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() + direction));

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "P";
    }
}
