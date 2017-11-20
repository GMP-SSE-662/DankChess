package chess_game.gamepieces.movements;

import chess_game.Board;
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
    public void setLocation(Location location) {
        gamePiece.setLocation(location);
    }

    @Override
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = gamePiece.getValidMoves(board);
        ArrayList<Location> locationsToTest = new ArrayList<>();
        locationsToTest.add(new Location(getLocation().getColumn() + 1, getLocation().getRow()));
        locationsToTest.add(new Location(getLocation().getColumn() - 1, getLocation().getRow()));
        locationsToTest.add(new Location(getLocation().getColumn(), getLocation().getRow() + 1));
        locationsToTest.add(new Location(getLocation().getColumn(), getLocation().getRow() - 1));
        locationsToTest.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() + 1));
        locationsToTest.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() - 1));
        locationsToTest.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() + 1));
        locationsToTest.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() - 1));
        for (Location l : locationsToTest) {
            if (!isOffBoard(l)) {
                if (!isInvalidCollision(l, board)) {
                    validMoves.add(l);
                }
            }
        }
        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "K";
    }
}
