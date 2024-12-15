package TicTacToe.Strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

     HashMap<Integer,HashMap<Character,Integer>> rowMap= new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Character sym = move.getPlayer().getSymbol().getSym();
        int row = move.getCell().getR();

        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<>());
        }

        HashMap<Character , Integer> countRow = rowMap.get(row);
        if(!countRow.containsKey(sym)){
            countRow.put(sym,0);
        }

        countRow.put(sym,countRow.get(sym)+1);

        if(countRow.get(sym) == board.getSize()){
            return true;
        }
        return false;

    }

    @Override
    public void handleUndo(Move move) {
        int r = move.getCell().getR();
        Character sym = move.getPlayer().getSymbol().getSym();
        HashMap<Character,Integer> countMap= rowMap.get(r);
        if(countMap.get(sym) == 0)
            System.out.println("Nothing to undo");
        else
            countMap.put(sym,countMap.get(sym)-1);

    }

}
