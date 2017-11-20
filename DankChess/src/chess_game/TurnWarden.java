package chess_game;

import java.util.Observable;

public class TurnWarden extends Observable {
    private boolean isLightPlayerTurn;

    public TurnWarden() {
        isLightPlayerTurn = false;
    }

    /**
     * Toggles the current player turn and updates observers.
     */
    void toggleTurn() {
        isLightPlayerTurn = !isLightPlayerTurn;
        setChanged();
        notifyObservers(isLightPlayerTurn);
    }
}
