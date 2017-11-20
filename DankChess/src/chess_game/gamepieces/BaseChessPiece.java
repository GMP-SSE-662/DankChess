package chess_game.gamepieces;

import chess_game.Board;
import chess_game.Constants;
import chess_game.Location;
import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;

import java.util.ArrayList;

public class BaseChessPiece extends GamePiece {

    @Override
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = new ArrayList<>();
        return validMoves;
    }

    @Override
    public String getBoardSprite() {
        if (DarkColor.getDarkPieceColor().equals(getPieceColor())) {
            return "d_";
        } else if (LightColor.getLightPieceColor().equals(getPieceColor())) {
            return "l_";
        } else {
            return Constants.ERROR_STRING;
        }
    }
}
