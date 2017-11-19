package chess_game;

import chess_game.factories.ChessPieceFactory;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;

import java.util.ArrayList;
import java.util.Observable;

public class Player extends Observable {

    private ChessPieceFactory pieceFactory;
    private ArrayList<ChessPiece> playerPieces;
    private ArrayList<ChessPiece> takenPieces;

    public Player(ChessPieceFactory pieceFactory) {
        this.pieceFactory = pieceFactory;
        playerPieces = new ArrayList<>();
        takenPieces = new ArrayList<>();
    }

    public Player(ChessPieceFactory pieceFactory, ArrayList<ChessPiece> playerPieces) {
        this.pieceFactory = pieceFactory;
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

    @Override
    public String toString() {
        if (pieceFactory instanceof DarkPieceFactory) {
            return "Dark Player";
        } else if (pieceFactory instanceof LightPieceFactory) {
            return "Light Player";
        } else {
            return "ERROR";
        }
    }
}
