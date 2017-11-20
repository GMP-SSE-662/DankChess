package chess_game;

public class Location {
    private int row;
    private int column;

    /**
     * Creates a location object.
     * @param column factor of x-value.
     * @param row factor of y-value.
     */
    public Location(int column, int row) {
        this.column = column;
        this.row = row;
    }

    /**
     * Gets the column of the location.
     * @return factor of x-value, column.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the row of the location.
     * @return factor of y-value, row.
     */
    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            return row == ((Location)obj).getRow() && column == ((Location)obj).getColumn();
        } else {
            return false;
        }
    }
}
