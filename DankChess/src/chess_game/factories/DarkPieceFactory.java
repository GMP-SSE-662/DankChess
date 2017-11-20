package chess_game.factories;

import chess_game.Location;
import chess_game.gamepieces.BaseChessPiece;
import chess_game.gamepieces.GamePiece;
import chess_game.colors.DarkColor;
import chess_game.gamepieces.movements.*;

public class DarkPieceFactory implements ChessPieceFactory {

    @Override
    public GamePiece createPawn(Location location) {
        return new Pawn(createDarkPiece(location));
    }

    @Override
    public GamePiece createRook(Location location) {
        return new Rook(createDarkPiece(location));
    }

    @Override
    public GamePiece createKnight(Location location) {
        return new Knight(createDarkPiece(location));
    }

    @Override
    public GamePiece createBishop(Location location) {
        return new Bishop(createDarkPiece(location));
    }

    @Override
    public GamePiece createQueen(Location location) {
        return new Queen(createDarkPiece(location));
    }

    @Override
    public GamePiece createKing(Location location) {
        return new King(createDarkPiece(location));
    }

    private GamePiece createDarkPiece(Location location) {
        GamePiece piece = new BaseChessPiece();
        piece.setPieceColor(DarkColor.getDarkPieceColor());
        piece.setLocation(location);
        return piece;
    }
}
