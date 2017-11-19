package chess_game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Scoreboard implements Observer {

    private Observable observable;
    private ArrayList<ChessPiece> observedPieces;

    public Scoreboard(Observable obs) {
        observable = obs;
        observable.addObserver(this);
        if (obs instanceof Player) {
            Player player = (Player)obs;
            observedPieces = player.getPlayerPieces();
        }
    }

    public ArrayList<ChessPiece> getObservedPieces() {
        return observedPieces;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Player) {
            Player player = (Player)o;
            ArrayList<ChessPiece> playerPieces = player.getPlayerPieces();
            playerPieces.forEach(playerPiece -> {
                if (!observedPieces.contains(playerPiece)) {
                    observedPieces.add(playerPiece);
                }
            });
            observedPieces.forEach(playerPiece -> {
                if (!playerPieces.contains(playerPiece)) {
                    observedPieces.remove(playerPiece);
                }
            });
        }
    }
}
