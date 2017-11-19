package chess_game;

import chess_game.powerups.Drawable;
import javafx.scene.canvas.GraphicsContext;
import view.Tile;

import java.util.ArrayList;

public class Board implements Drawable {
    ArrayList<ChessPiece> pieces;
    ArrayList<Location> pieceLocations;
    ArrayList<Tile> tiles;

    private int boardSize;

    Board(int size){
        boardSize = size;
        tiles = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tiles.add(new Tile(i, j));
            }
        }
    }

    public ArrayList<Location> getPieceLocations(){
        pieceLocations = new ArrayList<>();

        for(ChessPiece piece: pieces){
            pieceLocations.add(piece.getLocation());
        }

        return pieceLocations;
    }

    public void draw(GraphicsContext context){
        for(Tile tile: tiles){
            tile.draw(context);
        }
    }
}
