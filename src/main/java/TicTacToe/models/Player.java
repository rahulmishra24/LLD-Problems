package TicTacToe.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
//@AllArgsConstructor

public class Player {

    public int id;
    public String name;
    public PlayerType playerType;
    public Symbol symbol;
    private Scanner sc = new Scanner(System.in);

    Player(int id,String name, PlayerType playerType, Symbol symbol){
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;

    }



    public Move makeMove(){
      System.out.println("Please enter the row you want to place as symbol");
      int r = sc.nextInt();
      System.out.println("Please enter the column you want to place as symbol");
      int c = sc.nextInt();

      return new Move(new Cell(r,c),this);

    }
}
