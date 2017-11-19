package chess_game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Scoreboard implements Observer {

    private Observable observable;
    private ArrayList<ChessPiece> playerPieces;

    public Scoreboard(Observable obs) {
        observable = obs;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Player) {
        }
    }
}
