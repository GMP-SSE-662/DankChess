package chess_game.factories;

import chess_game.pieces.*;

public interface ChessPieceFactory {
    Pawn createPawn();
    Rook createRook();
    Knight createKnight();
    Bishop createBishop();
    Queen createQueen();
    King createKing();
}
