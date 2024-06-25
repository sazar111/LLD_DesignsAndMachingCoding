package TicTacToe.Controllers;

import TicTacToe.Models.Game;
import TicTacToe.Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    public Game startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Players");
        int numPlayers = sc.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Enter Player %d Name: ", (i + 1));
            String playerName = sc.next();
            System.out.println("Enter Player Symbol: ");
            String playerSymbol = sc.next();
            Player player = new Player(playerName, playerSymbol);
            players.add(player);
        }
        System.out.println("Enter Size of the Board");

        int size = sc.nextInt();
        return Game.getBuilder().setDimension(size).setPlayers(players).build();
    }

    public void makeMove(Game game){
        if(!checkAtLeastOneSpace()){
            System.out.println("Draw");
            return;
        }
        Player currentPlayer= game.getPlayers().get(game.getCurrentPlayer());
        System.out.printf("Player %s : Please make your move: ",currentPlayer.getName());
    }

    public boolean checkAtLeastOneSpace(){
        return true;
    }
}
