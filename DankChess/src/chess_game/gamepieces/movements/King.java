package chess_game.gamepieces.movements;

import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class King extends MovementPiece {

    GamePiece gamePiece;

    public King(GamePiece gamePiece) {
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
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = gamePiece.getValidMoves();

        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow()));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow()));
        validMoves.add(new Location(getLocation().getColumn(), getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn(), getLocation().getRow() - 1));
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() - 1));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() - 1));

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "K";
    }
}
