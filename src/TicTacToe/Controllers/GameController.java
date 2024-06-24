package TicTacToe.Controllers;

import TicTacToe.Models.Board;
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
        Board board = new Board(size);
        board.printBoard();
        Game game = new Game();
        return game;
    }
}
