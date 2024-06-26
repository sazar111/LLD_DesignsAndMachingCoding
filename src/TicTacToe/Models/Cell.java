package TicTacToe.Models;

public class Cell {
    private final int row;
    private final int col;
    private final Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.player = null;
    }

    public Cell(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
