package chess_game.pieces;

import chess_game.ChessPiece;
import chess_game.Constants;
import chess_game.Location;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class King extends ChessPiece {

    public King(Constants.PlayerName owner, int row, int column){
        super(owner, row, column);
        ImageView spriteSheet = new ImageView("src/resources/linux_chess_set_by_sethness.png");
        spriteSheet.setViewport(new Rectangle2D(400, 3, 100, 150));
        setBoardSprite(spriteSheet.getImage());
    }

    @Override
    public ArrayList<Location> getValidMoves() {
        return null;
    }
}
