package chess_game.gamepieces;

import chess_game.Constants;
import chess_game.Location;
import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;

import java.util.ArrayList;

public class BaseChessPiece extends GamePiece {

    @Override
    public ArrayList<Location> getValidMoves() {
        ArrayList<Location> validMoves = new ArrayList<>();
        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        if (getPieceColor() instanceof DarkColor) {
            return "d_";
        } else if (getPieceColor() instanceof LightColor) {
            return "l_";
        } else {
            return Constants.ERROR_STRING;
        }
    }
}
