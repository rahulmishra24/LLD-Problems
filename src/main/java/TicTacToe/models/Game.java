package TicTacToe.models;


import TicTacToe.Strategy.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Game {

    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private List<Move> Moves;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;

    private List<WinningStrategy> winningStrategies;


    public static Builder getBuilder(){
        return new Builder();
    }

    public Game(Builder builder){
        board = new Board(builder.dimensions);
        players = builder.players;
        winningStrategies = builder.winningStrategies;
        winner = null;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;
    }
    public boolean validateMove(Move currentMove){
        int row = currentMove.getCell().getR();
        int col = currentMove.getCell().getC();
        // if the input is outside the boundary
        if(row < 0 || row > board.getSize() - 1 || col < 0 || col > board.getSize() - 1 ){
            return false;
        }

        return board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public boolean checkWinner(Move move){
        for(WinningStrategy strategies: winningStrategies ){
            if(strategies.checkWinner(board,move)){
                return true;
            }
        }
        return false;
    }

    public void makeMove(){
       Player currentPlayer = players.get(nextPlayerIndex);
        Move currentMove = currentPlayer.makeMove();

        int r = currentMove.getCell().getR();
        int c = currentMove.getCell().getC();

        if(!validateMove(currentMove)){
            System.out.println("Invalid Move");
            return;
        }

        Cell currentCell = board.getGrid().get(r).get(c);
        currentCell.setCellState(CellState.FILLED);
        currentCell.setSym(currentPlayer.getSymbol());

        currentMove.setCell(currentCell);
        currentMove.setPlayer(currentPlayer);
        moves.add(currentMove);
        nextPlayerIndex++;
        nextPlayerIndex%=players.size();


        if(checkWinner(currentMove)){
          setWinner(currentPlayer);
          setGameState(GameState.SUCCESS);
        }
        else{
            if(moves.size() == board.getSize() * board.getSize()){
               setWinner(null);
               setGameState(GameState.DRAW);
            }
        }




    }

    public void display(){
       board.display();
    }

    public void undo(){

        if(moves.isEmpty()){
            System.out.println("Nothing to Undo!");
        }
        Move lastMove = moves.get(moves.size() - 1);
        moves.remove(moves.size() - 1);

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setSym(null);

        nextPlayerIndex--;
        // (a - b ) % n = (a - b + n )% n
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();

        for(WinningStrategy strategy : winningStrategies){
            strategy.handleUndo( lastMove);
        }

        setGameState(GameState.IN_PROGRESS);
        setWinner(null);



    }

    public static class Builder {
        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimensions(int dimensions){
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }



        public Game build(){
            return new Game(this);
        }



    }





}
