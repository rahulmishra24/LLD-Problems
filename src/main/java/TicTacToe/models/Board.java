package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Board {

    public int size;
    public List<List<Cell>> grid;

    Board(int size){
        this.size = size;
        this.grid = new ArrayList<>();
        for(int i=0;i< size; i++){
            grid.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                grid.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize(){
        return this.size;
    }

    public List<List<Cell>> getGrid(){
        return this.grid;
    }

    public void display(){
        for(List<Cell> r: grid){
            for(Cell c: r){
                c.display();
            }
            System.out.println("");
        }
    }
}
