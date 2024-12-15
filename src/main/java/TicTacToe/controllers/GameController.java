package TicTacToe.controllers;

import TicTacToe.Strategy.WinningStrategy;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;

import java.util.List;

public class GameController {

     public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
            return Game.getBuilder()
                    .setDimensions(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();


     }

     public GameState getGameState(Game game){
         return game.getGameState();
     }

     public void makeMove(Game game){
         game.makeMove();
     }

     public void display(Game game){
         game.display();
     }

     public void undo(Game game){
         game.undo();
     }

     public GameState checkState(Game game){
         return game.getGameState();
     }


     public Player getWinner(Game game){
         return game.getWinner();
     }

}
