package chess_game;

import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.GamePiece;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board extends Canvas {
    ArrayList<GamePiece> lightPlayer;
    ArrayList<GamePiece> darkPlayer;
    ArrayList<GamePiece> pieces;
    ArrayList<Location> pieceLocations;
    ArrayList<Tile> tiles;

    private int boardSize;

    public Board(int desiredBoardSize) {
        super(desiredBoardSize, desiredBoardSize);
        boardSize = desiredBoardSize / Constants.TILE_SIZE;
        tiles = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                tiles.add(new Tile(i, j));
            }
        }
        initializePlayers();
    }

    private void initializePlayers() {
        lightPlayer = new ArrayList<>();
        darkPlayer = new ArrayList<>();
        LightPieceFactory lpf = new LightPieceFactory();
        DarkPieceFactory dpf = new DarkPieceFactory();
        for (int i = 0; i < boardSize; i++) {
            lightPlayer.add(lpf.createPawn(new Location(boardSize - 2, i)));
            darkPlayer.add(dpf.createPawn(new Location(1, i)));
        }
    }

    public ArrayList<Location> getPieceLocations() {
        pieceLocations = new ArrayList<>();
        for(GamePiece piece : pieces) {
            pieceLocations.add(piece.getLocation());
        }
        return pieceLocations;
    }

    public void draw() {
        GraphicsContext context = this.getGraphicsContext2D();
        for (Tile tile : tiles) {
            tile.draw(context);
        }
        for (GamePiece gp : lightPlayer) {
            gp.draw(context);
        }
        for (GamePiece gp : darkPlayer) {
            gp.draw(context);
        }
    }
}
