package chess_game.gamepieces.movements;

import chess_game.Location;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;

import java.util.ArrayList;

public class Bishop extends MovementPiece {

    GamePiece gamePiece;

    public Bishop(GamePiece gamePiece) {
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

        //TODO: Implement appropriate move abilities.

        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "B";
    }
}
