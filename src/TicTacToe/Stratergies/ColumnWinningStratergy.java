package TicTacToe.Stratergies;

import TicTacToe.Models.Board;
import TicTacToe.Models.*;

import java.util.Objects;

public class ColumnWinningStratergy implements WinningStratergy{

    @Override
    public boolean checkWin(Board board, Cell lastMove) {
        int col = lastMove.getCol();

        //check row win
        for(int i=0;i< board.getDimensions();i++){
            if(board.getCells().get(i).get(col).getPlayer()==null ||
                    !Objects.equals(board.getCells().get(i).get(col).getPlayer().getSymbol(), lastMove.getPlayer().getSymbol())){
                return false;
            }
        }
        return true;
    }
}
