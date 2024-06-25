package TicTacToe.Models;

import TicTacToe.Stratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class Game {
    //GameController gameManager;
    List<Player> players;
    Board board;
    List<WinningStratergy> WinningStratergies;
    int currentPlayer;

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public List<WinningStratergy> getWinningStratergies() {
        return WinningStratergies;
    }

    private Game(Builder builder){

        validateInputs(builder);
        this.players = builder.players;
        this.WinningStratergies= builder.WinningStratergies;
        this.board= new Board(builder.dimension);
        this.currentPlayer= 0;
        System.out.println("Game created");
    }

    private static void validateInputs(@org.jetbrains.annotations.NotNull Builder builder){
        if(builder.players.size()<2){
            throw new IllegalArgumentException("Number of players cannot be less than 2.");
        }
        if(builder.dimension<3){
            throw new IllegalArgumentException("Dimension cannot be less than 3.");
        }
        HashSet<String> symbols= new HashSet<>();
        for(Player p: builder.players){
            symbols.add(p.Symbol);
        }
        if(symbols.size()!= builder.players.size()){
            throw new IllegalArgumentException("Symbols must be unique for each User.");
        }
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder {
        List<Player> players;
        List<WinningStratergy> WinningStratergies;
        int dimension;

        public Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.WinningStratergies=null;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
            WinningStratergies = winningStratergies;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}
