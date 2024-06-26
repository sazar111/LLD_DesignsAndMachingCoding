package TicTacToe.Stratergies;

import TicTacToe.Models.Board;
import TicTacToe.Models.*;

public class RowWinningStratergy implements WinningStratergy{
    @Override
    public boolean checkWin(Board board, Cell lastMove) {
        int row = lastMove.getRow();

        for(int i=0;i<board.getDimensions();i++){
            if(board.getCells().get(row).get(i).getPlayer()==null ||
                    !board.getCells().get(row).get(i).getPlayer().equals(lastMove.getPlayer())){
                return false;
            }
        }
        return true;
    }
}
