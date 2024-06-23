package Models;
import Controllers.GameController;
import Controllers.GameController;

import java.util.*;
public class Game {
    //GameController gameManager;
    List<Player> players;
    Board board;
    List<WinningStratergy> WinningStratergies;

    static class Builder{
        Board board;
        List<Player> players;
        List<WinningStratergy> WinningStratergies;
        public Builder(){

        }
    }
}
