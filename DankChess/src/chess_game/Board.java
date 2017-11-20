package chess_game;

import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import chess_game.gamepieces.GamePiece;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board extends Canvas {
    LightPieceFactory lpf;
    DarkPieceFactory dpf;
    ArrayList<GamePiece> lightPlayer;
    ArrayList<GamePiece> darkPlayer;
    ArrayList<Tile> tiles;

    private int boardSize;

    public Board() {
        super(Constants.BOARD_SIZE, Constants.BOARD_SIZE);
        boardSize = Constants.BOARD_SIZE / Constants.TILE_SIZE;
        tiles = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                tiles.add(new Tile(j, i));
            }
        }
        initializePlayers();
    }

    private void initializePlayers() {
        lightPlayer = new ArrayList<>();
        darkPlayer = new ArrayList<>();
        lpf = new LightPieceFactory();
        dpf = new DarkPieceFactory();
        for (int i = 0; i < boardSize; i++) {
            lightPlayer.add(lpf.createPawn(new Location(i, boardSize - 2)));
            darkPlayer.add(dpf.createPawn(new Location(i, 1)));
        }
        lightPlayer.add(lpf.createRook(new Location(0, boardSize - 1)));
        lightPlayer.add(lpf.createRook(new Location(boardSize - 1, boardSize - 1)));
        lightPlayer.add(lpf.createKnight(new Location(1, boardSize - 1)));
        lightPlayer.add(lpf.createKnight(new Location(boardSize - 2, boardSize - 1)));
        lightPlayer.add(lpf.createBishop(new Location(2, boardSize - 1)));
        lightPlayer.add(lpf.createBishop(new Location(boardSize - 3, boardSize - 1)));
        lightPlayer.add(lpf.createQueen(new Location(3, boardSize - 1)));
        lightPlayer.add(lpf.createKing(new Location(boardSize - 4, boardSize - 1)));
        darkPlayer.add(dpf.createRook(new Location(0, 0)));
        darkPlayer.add(dpf.createRook(new Location(boardSize - 1, 0)));
        darkPlayer.add(dpf.createKnight(new Location(1, 0)));
        darkPlayer.add(dpf.createKnight(new Location(boardSize - 2, 0)));
        darkPlayer.add(dpf.createBishop(new Location(2, 0)));
        darkPlayer.add(dpf.createBishop(new Location(boardSize - 3, 0)));
        darkPlayer.add(dpf.createQueen(new Location(3, 0)));
        darkPlayer.add(dpf.createKing(new Location(boardSize - 4, 0)));

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
