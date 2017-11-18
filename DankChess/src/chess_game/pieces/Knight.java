package chess_game.pieces;

import chess_game.ChessPiece;
import chess_game.Location;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    @Override
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = new ArrayList<>();

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
}
