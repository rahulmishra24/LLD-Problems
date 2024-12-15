package TicTacToe.Strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class ColumnWinningStrategy implements  WinningStrategy{

    HashMap<Integer,HashMap<Character,Integer>> colMap= new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Character sym = move.getPlayer().getSymbol().getSym();
        int col = move.getCell().getC();

        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }

        HashMap<Character, Integer> countCol = colMap.get(col);
        if (!countCol.containsKey(sym)) {
            countCol.put(sym, 0);
        }

        countCol.put(sym, countCol.get(sym) + 1);

        if (countCol.get(sym) == board.getSize()) {
            return true;
        }
        return false;

    }

    @Override
    public void handleUndo(Move move) {
        int c = move.getCell().getC();
        Character sym = move.getPlayer().getSymbol().getSym();
        HashMap<Character,Integer> countMap= colMap.get(c);
        if(countMap.get(sym) == 0)
            System.out.println("Nothing to undo");
        else
            countMap.put(sym,countMap.get(sym)-1);

    }
}
