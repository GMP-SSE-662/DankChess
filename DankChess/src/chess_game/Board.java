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
    public Tile[][] tiles;
    TurnWarden warden;

    public int boardSize;
    Tile activeTile;

    public Board() {
        super(Constants.BOARD_SIZE, Constants.BOARD_SIZE);
        tiles = new Tile[Constants.TILES_PER_SIDE][Constants.TILES_PER_SIDE];
        warden = new TurnWarden(this);
        for (int i = 0; i < Constants.TILES_PER_SIDE; i++) {
            for (int j = 0; j < Constants.TILES_PER_SIDE; j++) {
                tiles[i][j] = new Tile(i, j, this);
                warden.addObserver(tiles[i][j]);
            }
        }
        initializePlayers();
    }

    private void initializePlayers() {
        lightPlayer = new ArrayList<>();
        darkPlayer = new ArrayList<>();
        lpf = new LightPieceFactory();
        dpf = new DarkPieceFactory();
        int boardSize = Constants.TILES_PER_SIDE;
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


        for(GamePiece piece: lightPlayer){
            tiles[piece.getLocation().getColumn()][piece.getLocation().getRow()].piece = piece;
        }

        for(GamePiece piece: darkPlayer){
            tiles[piece.getLocation().getColumn()][piece.getLocation().getRow()].piece = piece;
        }

    }

    public void highlightMoves(ArrayList<Location> moves){
        for(int i = 0; i < Constants.TILES_PER_SIDE; i++){
            for(int j = 0; j < Constants.TILES_PER_SIDE; j++){
                tiles[i][j].draw(this.getGraphicsContext2D());
                if (tiles[i][j].isHighlighted()) tiles[i][j].setOutlineNormal(this.getGraphicsContext2D());
            }
        }

        for(Location move: moves){
            tiles[move.getColumn()][move.getRow()].setOutlineMovable(this.getGraphicsContext2D());
        }

    }

    public void setActiveTile(Tile tile){
        activeTile = tile;
    }

    public Tile getActiveTile(){
        return activeTile;
    }

    public void clearActiveTile(){
        activeTile.piece = null;
        activeTile = null;
        draw();
    }

    public void draw() {
        GraphicsContext context = this.getGraphicsContext2D();
        for (int i = 0; i < Constants.TILES_PER_SIDE; i++){
            for (int j = 0; j < Constants.TILES_PER_SIDE; j++){
                tiles[i][j].draw(context);
            }
        }
        for (GamePiece gp : lightPlayer) {
            gp.draw(context);
        }
        for (GamePiece gp : darkPlayer) {
            gp.draw(context);
        }
    }

    public void nextTurn(){
        warden.toggleTurn();
    }
}
