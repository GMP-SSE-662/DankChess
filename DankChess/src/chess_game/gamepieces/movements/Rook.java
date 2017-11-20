package chess_game.gamepieces.movements;

import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class Rook extends MovementPiece {

    GamePiece gamePiece;

    public Rook(GamePiece gamePiece) {
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

        for (int i = 1; i <= 16; i++) {
            validMoves.add(new Location(getLocation().getColumn() + i, getLocation().getRow()));
            validMoves.add(new Location(getLocation().getColumn() - i, getLocation().getRow()));
            validMoves.add(new Location(getLocation().getColumn(), getLocation().getRow() + i));
            validMoves.add(new Location(getLocation().getColumn(), getLocation().getRow() - i));
        }

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "R";
    }
}
