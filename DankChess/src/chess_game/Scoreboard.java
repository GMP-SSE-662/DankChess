package chess_game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Scoreboard extends Canvas implements Observer {

    private Observable observable;
    private ArrayList<ChessPiece> observedPieces;

    public Scoreboard(Observable obs, int desiredBoardSize) {
        super(Constants.scoreboardWidth, desiredBoardSize);
        observable = obs;
        observable.addObserver(this);
        if (obs instanceof Player) {
            Player player = (Player)obs;
            observedPieces = player.getTakenPieces();
        }
        drawScore(this.getGraphicsContext2D());
    }

    public ArrayList<ChessPiece> getObservedPieces() {
        return observedPieces;
    }

    public void drawScore(GraphicsContext context) {
        int horizontal = 0, vertical = 0;
        for (ChessPiece piece : observedPieces) {
            piece.drawOnScoreboard(context, horizontal, vertical);
            if (horizontal >= 5) {
                horizontal = 0;
                vertical++;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Player) {
            Player player = (Player)o;
            ArrayList<ChessPiece> takenPieces = player.getTakenPieces();
            takenPieces.forEach(takenPiece -> {
                if (!observedPieces.contains(takenPiece)) {
                    observedPieces.add(takenPiece);
                }
            });
        }
        drawScore(this.getGraphicsContext2D());
    }
}
