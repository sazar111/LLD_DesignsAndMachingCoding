package TicTacToe.Controllers;

import TicTacToe.Enums.GameState;
import TicTacToe.Models.Cell;
import TicTacToe.Models.Game;
import TicTacToe.Models.Player;
import TicTacToe.Models.Board;
import TicTacToe.Stratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private BoardController boardController;

    public GameController(BoardController boardController){
        this.boardController= boardController;
    }

    public void printBoard(Game game){
        game.getBoard().printBoard();
    }

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
        if(!checkAtLeastOneSpace(game.getBoard())){
            game.setGameState(GameState.DRAW);
            return;
        }
        Player currentPlayer= game.getPlayers().get(game.getCurrentPlayerIndex());

        Cell move= currentPlayer.makeMove();
        boardController.applyMove(game.getBoard(),move);

        if(checkWin(game.getBoard(),game.getWinningStratergies(),move)){
            game.setGameState(GameState.USER_WON);
        }
        game.setCurrentPlayerIndex( (game.getCurrentPlayerIndex()+1) % game.getPlayers().size() );
    }

    public boolean checkAtLeastOneSpace(Board board){
        int boardSize= board.getDimensions();
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                if(board.getCells().get(i).get(j).getPlayer() == null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin(Board board, List<WinningStratergy> stratergies, Cell move){
        for(WinningStratergy ws : stratergies){
            if(ws.checkWin(board,move)){
                return true;
            }
        }
        return false;
    }
}
