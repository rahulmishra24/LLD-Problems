package TicTacToe.Strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
    public void handleUndo(Move move);

}
