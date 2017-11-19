package chess_game;

import chess_game.factories.ChessPieceFactory;
import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.GamePiece;

import java.util.ArrayList;

public class Player {
    private ChessPieceFactory pieceFactory;
    private ArrayList<GamePiece> playerPieces;
    private ArrayList<GamePiece> takenPieces;

    public Player(ChessPieceFactory pieceFactory) {
        this.pieceFactory = pieceFactory;
        playerPieces = new ArrayList<>();
        takenPieces = new ArrayList<>();
    }

    public Player(ChessPieceFactory pieceFactory, ArrayList<GamePiece> playerPieces) {
        this.pieceFactory = pieceFactory;
        this.playerPieces = playerPieces;
        takenPieces = new ArrayList<>();
    }

    public void addPlayerPiece(GamePiece piece) {
        playerPieces.add(piece);
    }

    public void removePlayerPiece(GamePiece piece) {
        playerPieces.remove(piece);
    }

    public ArrayList<GamePiece> getPlayerPieces() {
        return playerPieces;
    }

    public void takePiece(GamePiece piece) {
        takenPieces.add(piece);
    }

    public ArrayList<GamePiece> getTakenPieces() {
        return takenPieces;
    }

    @Override
    public String toString() {
        if (pieceFactory instanceof DarkPieceFactory) {
            return Constants.DARK_PLAYER_NAME;
        } else if (pieceFactory instanceof LightPieceFactory) {
            return Constants.LIGHT_PLAYER_NAME;
        } else {
            return Constants.ERROR_STRING;
        }
    }
}
