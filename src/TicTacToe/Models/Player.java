package TicTacToe.Models;

import java.util.Scanner;

public class Player {
    String Name;
    String Symbol;

    public Player(String Name, String Symbol) {
        this.Name = Name;
        this.Symbol = Symbol;
    }

    public String getName() {
        return Name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public Cell makeMove(){
        System.out.printf("Player %s : Please make your move: \n Enter Row: ",this.getName());
        Scanner sc= new Scanner(System.in);
        int row = sc.nextInt();
        System.out.println("Enter Col: ");
        int col = sc.nextInt();
        return new Cell(row, col,this);
    }
}
