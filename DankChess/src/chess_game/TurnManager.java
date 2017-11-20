package chess_game;

import java.util.Observable;

public class TurnManager extends Observable{
    Board board = null;

    public TurnManager(Board gameBoard){
        board = gameBoard;
    }

}
