package chess_game.gamepieces.movements;

import chess_game.Constants;
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

        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() + 2));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() + 2));
        validMoves.add(new Location(getLocation().getColumn() + 2, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() - 2, getLocation().getRow() + 1));
        validMoves.add(new Location(getLocation().getColumn() + 1, getLocation().getRow() - 2));
        validMoves.add(new Location(getLocation().getColumn() - 1, getLocation().getRow() - 2));
        validMoves.add(new Location(getLocation().getColumn() + 2, getLocation().getRow() - 1));
        validMoves.add(new Location(getLocation().getColumn() - 2, getLocation().getRow() - 1));

        for(int i = 0; i < validMoves.size(); i++){
            if(validMoves.get(i).getRow() > Constants.TILES_PER_SIDE - 1 || validMoves.get(i).getRow() < 0 ||
                    validMoves.get(i).getColumn() > Constants.TILES_PER_SIDE - 1 || validMoves.get(i).getColumn() < 0){
                validMoves.remove(i);
                i--;
            }
        }
        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "Kn";
    }
}
