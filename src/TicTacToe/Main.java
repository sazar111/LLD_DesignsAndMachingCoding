package TicTacToe;

import TicTacToe.Controllers.BoardController;
import TicTacToe.Controllers.GameController;
import TicTacToe.Enums.GameState;
import TicTacToe.Models.Game;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BoardController());
        Game game= gameController.startGame();

        while(game.getGameState()== GameState.IN_PROGRESS){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
        if(game.getGameState()==GameState.DRAW){
            System.out.println("Its a Draw!");
        }else if(game.getGameState()==GameState.USER_WON){
            System.out.printf("%s Won the game! Cheers!",game.getPlayers().get(game.getCurrentPlayerIndex()).getName());
        }
    }
}