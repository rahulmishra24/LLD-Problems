package TicTacToe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@AllArgsConstructor
public class Cell {

    public int r;
    public int c;
    public CellState cellState;
    public Symbol sym;

    public Cell(int r, int c){
       this.r = r;
       this.c = c;
       this.cellState = CellState.EMPTY;
       this.sym = null;
    }

    public void display(){
        if(sym!=null){
            System.out.print("|"+sym.getSym()+"|");
        }
        else {
            System.out.print("|"+"-"+"|");
        }
    }


}
