package TicTacToe.models;

import lombok.Setter;

public class Move {

    @Setter
    public Cell cell;
    public Player player;

    Move(Cell cell, Player player){
        this.cell = cell;
        this.player = player;
    }

    public  Cell getCell(){
        return this.cell;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }


}
