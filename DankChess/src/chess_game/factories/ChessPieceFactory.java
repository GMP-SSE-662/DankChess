package chess_game.factories;

import chess_game.Location;
import chess_game.gamepieces.GamePiece;

public interface ChessPieceFactory {
    GamePiece createPawn(Location location);
    GamePiece createRook(Location location);
    GamePiece createKnight(Location location);
    GamePiece createBishop(Location location);
    GamePiece createQueen(Location location);
    GamePiece createKing(Location location);
}
