package chess_game;

import java.util.ArrayList;
import java.util.Observable;

public class Player extends Observable {

    private ArrayList<ChessPiece> playerPieces;

    public Player() {
        playerPieces = new ArrayList<>();
    }

    public Player(ArrayList<ChessPiece> playerPieces) {
        this.playerPieces = playerPieces;
    }

    public void addPiece(ChessPiece piece) {
        playerPieces.add(piece);
        setChanged();
        notifyObservers();
    }

    public void removePiece(ChessPiece piece) {
        playerPieces.remove(piece);
        setChanged();
        notifyObservers();
    }

    public ArrayList<ChessPiece> getPlayerPieces() {
        return playerPieces;
    }
}
