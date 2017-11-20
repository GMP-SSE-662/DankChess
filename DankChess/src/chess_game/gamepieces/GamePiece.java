package chess_game.gamepieces;

import chess_game.Board;
import chess_game.Constants;
import chess_game.Drawable;
import chess_game.Location;
import chess_game.colors.PieceColor;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GamePiece implements Drawable {
    private PieceColor pieceColor;
    private Location location;

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract ArrayList<Location> getValidMoves(Board board);

    public ArrayList<Location> removeInvalidMoves(ArrayList<Location> potentialMoves, Board board) {
        ArrayList<Location> validMoves = potentialMoves;
        Location moveInQuestion;
        for (int i = 0; i < potentialMoves.size(); i++) {
            moveInQuestion = potentialMoves.get(i);
            if(isOffBoard(moveInQuestion)) {
                validMoves.remove(i);
                i--;
                continue;
            }
            if(isInvalidCollision(moveInQuestion, board)) {
                validMoves.remove(i);
                i--;
            }
        }
        return validMoves;
    }

    protected ArrayList<Location> getDiagonalMoves(Location currentLocation, Board board) {
        ArrayList<Location> validMoves = new ArrayList<>();
        Location locationToTest;
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() + i, currentLocation.getRow() + i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() + i, currentLocation.getRow() - i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() - i, currentLocation.getRow() + i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() - i, currentLocation.getRow() - i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        return validMoves;
    }

    protected ArrayList<Location> getLateralMoves(Location currentLocation, Board board) {
        ArrayList<Location> validMoves = new ArrayList<>();
        Location locationToTest;
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() + i, currentLocation.getRow());
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn() - i, currentLocation.getRow());
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn(), currentLocation.getRow() + i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        for (int i = 1; i <= Constants.TILES_PER_SIDE; i++) {
            locationToTest = new Location(currentLocation.getColumn(), currentLocation.getRow() - i);
            if (isOffBoard(locationToTest)) break;
            if (isInvalidCollision(locationToTest, board)) break;
            validMoves.add(locationToTest);
            if (isAttack(locationToTest, board)) break;
        }
        return validMoves;
    }

    protected boolean isOffBoard(Location move) {
        return move.getRow() > Constants.TILES_PER_SIDE - 1 || move.getRow() < 0 ||
                move.getColumn() > Constants.TILES_PER_SIDE - 1 || move.getColumn() < 0;
    }

    protected boolean isInvalidCollision(Location move, Board board) {
        return board.tiles[move.getColumn()][move.getRow()].piece != null &&
                board.tiles[move.getColumn()][move.getRow()].piece.getPieceColor().equals(this.getPieceColor());
    }

    protected boolean isAttack(Location move, Board board) {
        return board.tiles[move.getColumn()][move.getRow()].piece != null &&
                !board.tiles[move.getColumn()][move.getRow()].piece.getPieceColor().equals(this.getPieceColor());
    }

    public abstract String getBoardSprite();

    public void draw(GraphicsContext gc) {
        gc.strokeText(getBoardSprite(), getLocation().getColumn() * Constants.TILE_SIZE + Constants.TILE_SIZE / 3,
                (getLocation().getRow() + 1) * Constants.TILE_SIZE - Constants.TILE_SIZE / 3, Constants.TILE_SIZE / 3);
    }
}
