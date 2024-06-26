package TicTacToe.Controllers;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;

public class BoardController {
    public void applyMove(Board board, Cell move){
        int row=move.getRow();
        int col=move.getCol();
        if(row>=board.getDimensions() || col>=board.getDimensions()){
            throw new IndexOutOfBoundsException("Invalid row or column: Values higher that board dimensions");
        }
        if(board.getCells().get(row).get(col).getPlayer()!=null){
            throw new IllegalArgumentException("Cell already occupied");
        }

        board.getCells().get(row).set(col, move);
    }
}
