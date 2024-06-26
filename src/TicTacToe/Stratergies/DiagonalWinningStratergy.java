package TicTacToe.Stratergies;

import TicTacToe.Models.Board;
import TicTacToe.Models.*;

public class DiagonalWinningStratergy implements WinningStratergy{

    @Override
    public boolean checkWin(Board board, Cell lastMove) {
        int row = lastMove.getRow();
        int col = lastMove.getCol();
        int dimension= board.getDimensions();
        if((row==0&&col==0)||(row==dimension-1&&col==1)||(row==0&&col==dimension-1)||(row==dimension-1&&col==dimension-1)){
            if((row==0&&col==0)||(row==dimension-1&&col==dimension-1)){
                for(int i=0; i<dimension; i++){
                    if(board.getCells().get(i).get(i).getPlayer()==null || !board.getCells().get(i).get(i).getPlayer().equals(lastMove.getPlayer())){
                        return false;
                    }
                }
            }else{
                for(int i=0; i<dimension; i++){
                    if(board.getCells().get(dimension-i-1).get(i).getPlayer()==null || !board.getCells().get(dimension-i-1).get(i).getPlayer().equals(lastMove.getPlayer())){
                        return false;
                    }
                }
            }

        }else{
            return false;
        }

        return true;
    }
}
