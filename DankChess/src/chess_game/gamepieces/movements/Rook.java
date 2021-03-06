package chess_game.gamepieces.movements;

import chess_game.Board;
import chess_game.Constants;
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
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = gamePiece.getValidMoves(board);

        for (int i = 1; i <= Constants.BOARD_SIZE / Constants.TILE_SIZE; i++) {
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
