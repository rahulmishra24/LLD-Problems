package TicTacToe;

import TicTacToe.Strategy.ColumnWinningStrategy;
import TicTacToe.Strategy.RowWinningStrategy;
import TicTacToe.Strategy.WinningStrategy;
import TicTacToe.controllers.GameController;
import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"Rahul", PlayerType.HUMAN_TYPE,new Symbol('X') ));
        players.add(new HumanPlayer(2,"Mona",PlayerType.HUMAN_TYPE,new Symbol('O') ));

        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());

        Game game = gameController.startGame(
                3,
                players,
                winningStrategies
        );

        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.display(game);
            gameController.makeMove(game);
            System.out.println("Do you want to undo Y/N");
            String undoAnswer = scanner.nextLine();
            if(undoAnswer.equals("Y")){
                gameController.undo(game);
                System.out.println("Undo is sucessfull");
//                gameController.display(game);
            }
        }
        if(gameController.checkState(game).equals(GameState.SUCCESS)) {
            System.out.println(gameController.getWinner(game).getName() + " won the game");
        } else if (gameController.checkState(game).equals(GameState.DRAW)) {
            System.out.println("Game results in a draw");
        }





    }
}
