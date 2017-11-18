package chess_game;

import java.util.ArrayList;

public abstract class ChessPiece {
    private Location location;

    public Location getLocation(){
        return location;
    }

    public void setLocation(int row, int column){
        location = new Location(row, column);
    }

    public abstract ArrayList<Location> getValidMoves();

}
