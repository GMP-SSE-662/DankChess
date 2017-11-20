package chess_game;

import java.util.Observable;

public class TurnWarden extends Observable{
    Board board = null;

    public TurnWarden(Board gameBoard){
        board = gameBoard;
    }

}
