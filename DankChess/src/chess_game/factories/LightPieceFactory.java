package chess_game.factories;

import chess_game.Location;
import chess_game.gamepieces.BaseChessPiece;
import chess_game.gamepieces.GamePiece;
import chess_game.colors.LightColor;
import chess_game.gamepieces.movements.*;

public class LightPieceFactory implements ChessPieceFactory {

    @Override
    public GamePiece createPawn(Location location) {
        return new Pawn(createLightPiece(location));
    }

    @Override
    public GamePiece createRook(Location location) {
        return new Rook(createLightPiece(location));
    }

    @Override
    public GamePiece createKnight(Location location) {
        return new Knight(createLightPiece(location));
    }

    @Override
    public GamePiece createBishop(Location location) {
        return new Bishop(createLightPiece(location));
    }

    @Override
    public GamePiece createQueen(Location location) {
        return new Queen(createLightPiece(location));
    }

    @Override
    public GamePiece createKing(Location location) {
        return new King(createLightPiece(location));
    }

    private GamePiece createLightPiece(Location location) {
        GamePiece piece = new BaseChessPiece();
        piece.setPieceColor(LightColor.getLightPieceColor());
        piece.setLocation(location);
        return piece;
    }
}
