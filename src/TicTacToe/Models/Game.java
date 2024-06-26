package TicTacToe.Models;

import TicTacToe.Enums.GameState;
import TicTacToe.Stratergies.ColumnWinningStratergy;
import TicTacToe.Stratergies.DiagonalWinningStratergy;
import TicTacToe.Stratergies.RowWinningStratergy;
import TicTacToe.Stratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class Game {
    //GameController gameManager;
    List<Player> players;
    Board board;
    List<WinningStratergy> WinningStratergies;
    int currentPlayerIndex;
    GameState gameState;

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<WinningStratergy> getWinningStratergies() {
        return WinningStratergies;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    private Game(Builder builder){
        this.gameState=GameState.IN_PROGRESS;
        validateInputs(builder);
        this.players = builder.players;
        this.WinningStratergies= builder.WinningStratergies;
        this.board= new Board(builder.dimension);
        this.currentPlayerIndex = 0;
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
            this.WinningStratergies=List.of(new RowWinningStratergy(), new DiagonalWinningStratergy(),new ColumnWinningStratergy());
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
