package TicTacToe.Models;

import TicTacToe.Stratergies.WinningStratergy;

import java.util.List;

public class Game {
    //GameController gameManager;
    List<Player> players;
    Board board;
    List<WinningStratergy> WinningStratergies;

    static class Builder {
        Board board;
        List<Player> players;
        List<WinningStratergy> WinningStratergies;

        public Builder() {

        }
    }
}
