package TicTacToe;

import TicTacToe.Controllers.GameController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.startGame();
    }
}