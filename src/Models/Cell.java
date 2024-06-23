package Models;

public class Cell {
    private final int row;
    private final int col;
    private final Player player;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        player=null;
    }

    public Player getPlayer() {
        return player;
    }
}
