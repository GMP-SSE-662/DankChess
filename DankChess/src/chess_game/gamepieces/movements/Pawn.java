package chess_game.gamepieces.movements;

import chess_game.Board;
import chess_game.Location;
import chess_game.colors.LightColor;
import chess_game.colors.PieceColor;
import chess_game.gamepieces.GamePiece;
import chess_game.gamepieces.MovementPiece;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Pawn extends MovementPiece {

    GamePiece gamePiece;

    public Pawn(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    @Override
    public PieceColor getPieceColor() {
        return gamePiece.getPieceColor();
    }

    @Override
    public Location getLocation() {
        return gamePiece.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        gamePiece.setLocation(location);
    }

    /**
     * Row + 1 is down on the board, so the direction for dark pieces (starting at the top)
     * is positive while light pieces (starting at the bottom) is negative.
     * @return all potentially valid moves.
     */
    @Override
    public ArrayList<Location> getValidMoves(Board board) {
        ArrayList<Location> validMoves = gamePiece.getValidMoves(board);
        int direction = getPieceColor() instanceof LightColor ? -1 : 1;
        Location locationToTest = new Location(getLocation().getColumn(), getLocation().getRow() + direction);
        if (!isOffBoard(locationToTest)) {
            if (!isInvalidCollision(locationToTest, board) && !isAttack(locationToTest, board)) {
                validMoves.add(locationToTest);
            }
        }
        locationToTest = new Location(getLocation().getColumn() + 1, getLocation().getRow() + direction);
        if (!isOffBoard(locationToTest)) {
            if (!isInvalidCollision(locationToTest, board) && isAttack(locationToTest, board)) {
                validMoves.add(locationToTest);
            }
        }
        locationToTest = new Location(getLocation().getColumn() - 1, getLocation().getRow() + direction);
        if (!isOffBoard(locationToTest)) {
            if (!isInvalidCollision(locationToTest, board) && isAttack(locationToTest, board)) {
                validMoves.add(locationToTest);
            }
        }
        return validMoves;
    }

    public void draw(GraphicsContext context, String sprite){
        gamePiece.draw(context, sprite);
    }

    @Override
    public String getBoardSprite() {
        return gamePiece.getBoardSprite() + "P";
    }
}
