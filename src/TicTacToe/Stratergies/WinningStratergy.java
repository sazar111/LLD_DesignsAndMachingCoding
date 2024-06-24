package TicTacToe.Stratergies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;

public interface WinningStratergy {
    boolean checkWin(Board board, Cell lastMove);
}
