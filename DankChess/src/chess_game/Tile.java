package chess_game;

import chess_game.colors.DarkColor;
import chess_game.colors.LightColor;
import chess_game.gamepieces.GamePiece;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class Tile extends Rectangle implements Drawable, Observer {
    private Location location;
    public GamePiece piece = null;
    public Board board;
    private boolean isHighlighted = false;

    /**
     * Creates a new tile at the specified location.
     * @param row of board.
     * @param column of board.
     */
    public Tile(int column, int row, Board board) {
        location = new Location(column, row);
        setX(column*Constants.TILE_SIZE);
        setY(row*Constants.TILE_SIZE);
        setHeight(Constants.TILE_SIZE);
        setWidth(Constants.TILE_SIZE);
        setFill(Color.TRANSPARENT);

        this.board = board;
        setOnMouseClicked(e -> {
            if(isHighlighted){
                moveActivePiece(board);
            } else if (piece != null){
                board.highlightMoves(piece.getValidMoves(board));
                makeActiveTile(board);
            }
        });
    }

    /**
     * Gets the location of the tile.
     * @return the tile location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Draws the tile.
     * @param context the current canvas graphics context.
     */
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(location.getColumn() * Constants.TILE_SIZE, location.getRow() * Constants.TILE_SIZE,
                Constants.TILE_SIZE, Constants.TILE_SIZE);
        context.setStroke(Color.BLACK);
        if(piece != null) piece.draw(context);
    }

    /**
     * Sets the outline of the tile to specify a legal move.
     * @param context the current canvas graphics context.
     */
    public void setOutlineMovable(GraphicsContext context) {
        clearTile(context);
        draw(context);
        context.setStroke(Color.DARKBLUE);
        drawOutline(context);
        isHighlighted = true;
    }

    /**
     * Sets the outline of the tile to specify available pieces.
     * @param context the current canvas graphics context.
     */
    public void setOutlineYourPieces(GraphicsContext context) {
        draw(context);
        drawOutline(context);
        isHiglighted = true;
    }

    /**
     * Sets the outline of the tile to specify no legal move or just normal tile.
     * @param context the current canvas graphics context.
     */
    public void setOutlineNormal(GraphicsContext context) {
        clearTile(context);
        draw(context);
        context.setStroke(getColor());
        drawOutline(context);
        isHighlighted = false;
    }

    /**
     * Draws the an outline around a tile based on @param.
     * @param context the current canvas graphics context.
     */
    private void drawOutline(GraphicsContext context) {
        context.strokeRect(location.getColumn() * Constants.TILE_SIZE + 1, location.getRow() * Constants.TILE_SIZE + 1,
                Constants.TILE_SIZE - 2, Constants.TILE_SIZE - 2);
    }

    public boolean isHighlighted(){
        return isHighlighted;
    }

    /**
     * Clears the entire tile.
     * @param context the current canvas graphics context.
     */
    private void clearTile(GraphicsContext context) {
        context.clearRect(location.getColumn() * Constants.TILE_SIZE + 1, location.getRow() * Constants.TILE_SIZE + 1,
                Constants.TILE_SIZE - 2, Constants.TILE_SIZE - 2);
    }

    /**
     * Gets the color based on the tile location.
     * @return the tile's color.
     */
    private Color getColor() {
        if (location.getRow() % 2 == 0) {
            if (location.getColumn() % 2 == 0) {
                return Color.WHITESMOKE;
            } else {
                return Color.WHEAT;
            }
        } else {
            if (location.getColumn() % 2 == 0) {
                return Color.WHEAT;
            } else {
                return Color.WHITESMOKE;
            }
        }
    }

    public void makeActiveTile(Board board){
        board.setActiveTile(this);
    }

    public void moveActivePiece(Board board){
        this.piece = board.getActiveTile().piece;
        board.clearActiveTile();
        this.setOutlineNormal(board.getGraphicsContext2D());
    }

    /**
     * Updates tile to show which turn it is
     *
     */
    @Override
    public void update(Observable o, Object arg) {

        if(piece!=null){

            if(board.warden.playerOneTurn){
                if(piece.getPieceColor() instanceof DarkColor){
                    setOutlineMovable(board.getGraphicsContext2D());
                }else{

                }
            }else{
                if(piece.getPieceColor() instanceof LightColor){
                    setOutlineMovable(board.getGraphicsContext2D());
                }else{

                }
            }

        }
    }
}
