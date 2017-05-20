import com.gwifi.base.interprocess_communication.IPC;

import java.util.Random;

public class DicePlayTest {
    public static enum Status {
        CONTINUE, WON, LOST;
    }

    public static Random random = new Random();

    private int win;
    private int lose;

    public DicePlayTest() {
        win = 0;
        lose = 0;
    }

    public void Play() {
        int myPoint = 0;
        Status gameStatus = Status.CONTINUE;
        int sumOfDice = rollDice();
        //No.1
        //开始写代码，补充完整代码，实现根据掷出的骰子数和判断输赢
        int i = -1;
        int fv = 0;
        while (gameStatus == Status.CONTINUE){

            i++;
            switch (sumOfDice ){
                case 7:
                    if(0==i){
                        gameStatus = Status.WON ;
                        break;
                    }else{
                        gameStatus = Status.LOST ;
                        break;
                    }
                case 11:
                    if(0==i){
                        gameStatus = Status.WON ;
                        break;
                    }else{
                        if(fv==sumOfDice){
                            gameStatus = Status.WON ;
                            break;
                        }
                        sumOfDice = rollDice();
                    }

                case 2:
                case 3:
                case 12:
                    if(0==i){
                        gameStatus = Status.LOST ;
                        break;
                    }else{
                        if(fv==sumOfDice){
                            gameStatus = Status.WON ;
                            break;
                        }
                        sumOfDice = rollDice();
                    }
                default:
                    if(0==i){
                        fv = sumOfDice;
                        gameStatus = Status.CONTINUE ;
                        sumOfDice = rollDice();
                    }else{
                        if(fv==sumOfDice){
                            gameStatus = Status.WON;
                            break;
                        }
                        sumOfDice = rollDice();
                    }

            }
        }//end of while










        //end_code
    }

    public int rollDice() {
        int roll1 = 1 + random.nextInt(6);
        int roll2 = 1 + random.nextInt(6);
        int sum = roll1 + roll2;
        System.out.printf("玩家掷的点数  %d + %d = %d\n", roll1, roll2, sum);
        return sum;
    }

    public static void main(String[] args) {
        DicePlayTest diceGame = new DicePlayTest();
        diceGame.Play();
    }
}

/*
 用java代码实现：
 玩家掷两个骰子，点数为1~6，
 如果第一次点数和为7或11，则玩家胜；
 如果点数和为2、3或12，则玩家输；
 如果和为其他点数，则记录第一次的点数和，然后继续掷骰子，直至点数和等于第一次掷出的点数和，则玩家胜；
 如果在这之前掷出了点数和为7，则玩家输。
  */