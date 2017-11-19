package chess_game.gamepieces.movements;

import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class Knight extends MovementPiece {

    GamePiece gamePiece;

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
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = gamePiece.getValidMoves();

        validMoves.add(new Location(getLocation().getRow() + 1, getLocation().getColumn() + 2));
        validMoves.add(new Location(getLocation().getRow() - 1, getLocation().getColumn() + 2));
        validMoves.add(new Location(getLocation().getRow() + 2, getLocation().getColumn() + 1));
        validMoves.add(new Location(getLocation().getRow() - 2, getLocation().getColumn() + 1));
        validMoves.add(new Location(getLocation().getRow() + 1, getLocation().getColumn() - 2));
        validMoves.add(new Location(getLocation().getRow() - 1, getLocation().getColumn() - 2));
        validMoves.add(new Location(getLocation().getRow() + 2, getLocation().getColumn() - 1));
        validMoves.add(new Location(getLocation().getRow() - 2, getLocation().getColumn() - 1));

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "Kn";
    }
}
