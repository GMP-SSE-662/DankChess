package chess_game;

import java.util.Observable;

public class TurnWarden extends Observable{
    Board board = null;

    boolean playerOneTurn = false;

    public TurnWarden(Board gameBoard){
        board = gameBoard;
    }

    /**
     * Gets isPlayerOneTurn
     * @return boolean isPlayerOneTurn
     */
    public boolean getIsPlayerOneTurn() {
        return playerOneTurn;
    }

    /**
     * Toggles the current player turn
     * @return boolean isPlayerOneTurn
     */
    boolean toggleTurn(){
        setChanged();
        notifyObservers();
        return playerOneTurn = !playerOneTurn;
    }
}
