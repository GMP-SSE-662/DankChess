package chess_game;

import java.util.Observable;

public class TurnWarden extends Observable{
    Board board = null;
    boolean playerOneTurn = true;

    public TurnWarden(Board gameBoard){
        board = gameBoard;
    }

    /**
     * Toggles the current player turn
     * @return boolean isPlayerOneTurn
     */
    boolean toggleTurn(){
        setChanged();
        return playerOneTurn = !playerOneTurn;
    }
}
