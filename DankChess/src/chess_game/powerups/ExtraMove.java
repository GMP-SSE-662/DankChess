package chess_game.powerups;

import chess_game.ChessPiece;
import chess_game.Location;
import chess_game.Powerup;

import java.util.ArrayList;

public class ExtraMove extends Powerup {

    ChessPiece chessPiece;

    public ExtraMove(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    @Override
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = chessPiece.getValidMoves();
        return validMoves;
    }
}
