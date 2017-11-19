package chess_game;

import chess_game.factories.DarkPieceFactory;
import chess_game.factories.LightPieceFactory;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board extends Canvas {
    Player lightPlayer;
    Player darkPlayer;
    ArrayList<ChessPiece> pieces;
    ArrayList<Location> pieceLocations;
    ArrayList<Tile> tiles;

    private int boardSize;

    public Board(int desiredBoardSize) {
        super(desiredBoardSize, desiredBoardSize);
        boardSize = desiredBoardSize / Constants.tileSize;
        tiles = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                tiles.add(new Tile(i, j));
            }
        }
        lightPlayer = new Player(new LightPieceFactory());
        darkPlayer = new Player(new DarkPieceFactory());
    }

    public ArrayList<Location> getPieceLocations() {
        pieceLocations = new ArrayList<>();
        for(ChessPiece piece : pieces) {
            pieceLocations.add(piece.getLocation());
        }
        return pieceLocations;
    }

    public Player getLightPlayer() {
        return lightPlayer;
    }

    public Player getDarkPlayer() {
        return darkPlayer;
    }

    public void draw() {
        GraphicsContext context = this.getGraphicsContext2D();
        for(Tile tile : tiles) {
            tile.draw(context);
        }
    }
}
