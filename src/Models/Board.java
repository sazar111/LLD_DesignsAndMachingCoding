package Models;
import java.util.*;

public class Board {
    List<List<Cell>> cells;
    int dimensions;
    public Board(int size){
        this.dimensions= size;
        cells = new ArrayList<>();
        for(int i = 0; i<this.dimensions; i++){
            List<Cell> row= new ArrayList<>();
            for(int j = 0; j<this.dimensions; j++){
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public void printBoard(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(cells.get(i).get(j).getPlayer() == null){
                    System.out.print("|   |");
                }else{
                    System.out.printf("| %s |",cells.get(i).get(j).getPlayer());
                }
            }
            System.out.println(" ");
        }
    }
}
