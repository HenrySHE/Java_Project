/*
2019-9-18 11:48
测试传参数的构造器
*/

class Game {
  Game(int i){
    System.out.println("Game" + i);
  }
}

class BoardGame extends Game {
  BoardGame(int i){
    super(i);
    System.out.println("BoardGame"+ i);
  }
}

public class Chess extends BoardGame {
  Chess(){
    super(11);
    System.out.println("Chess");
  }

  public static void main(String[] args){
    Chess x = new Chess();
  }
}
/*
Game11
BoardGame11
Chess
*/
