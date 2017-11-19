package chess_game;

import java.util.ArrayList;
import java.util.Observable;

public class Player extends Observable {

    private ArrayList<ChessPiece> playerPieces;
    private ArrayList<ChessPiece> takenPieces;
    Constants.PlayerName name;

    public Player(Constants.PlayerName name) {
        playerPieces = new ArrayList<>();
        takenPieces = new ArrayList<>();
        this.name = name;
    }

    public Player(ArrayList<ChessPiece> playerPieces) {
        this.playerPieces = playerPieces;
        takenPieces = new ArrayList<>();
    }

    public void addPlayerPiece(ChessPiece piece) {
        playerPieces.add(piece);
        setChanged();
        notifyObservers();
    }

    public void removePlayerPiece(ChessPiece piece) {
        playerPieces.remove(piece);
        setChanged();
        notifyObservers();
    }

    public ArrayList<ChessPiece> getPlayerPieces() {
        return playerPieces;
    }

    public void takePiece(ChessPiece piece) {
        takenPieces.add(piece);
    }

    public ArrayList<ChessPiece> getTakenPieces() {
        return takenPieces;
    }
}
