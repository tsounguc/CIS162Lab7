
/**
 * Write a description of class DiceGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class DiceGame
{
    private GVdie d1;
    private GVdie d2;
    private GVdie d3;  

    private int credits;
    private int guess;
    private int currentValue;
    private String message;
    private int v1;
    private int v2;
    private int v3;
    public DiceGame(){
        d1 =new GVdie();
        d2 =new GVdie();
        d3 =new GVdie();

        int credits = 100;
        System.out.println("Welcome to my Game");
        d1.setBlank();
        d2.setBlank();
        d3.setBlank();

    }

    public String getMessage(){
        return message;

    }

    public int getCredits(){
        return credits; 

    }

    public GVdie getDie (int num){

        switch (num){
            case 1:
            return d1;
            case 2:
            return d2;
            case 3:
            return d3;
            default:
            return null;
        }

    }

    public void setGuess(int g){
        guess= g;

    }

    public void restart(){
        credits =100;
        System.out.println("Welcome to my Game");
        d1.setBlank();
    }

    private void rollDice(){

        d1.roll();
        d2.roll();
        d3.roll();

        v1= d1.getValue();
        v2= d2.getValue();
        v3= d3.getValue();

    }

    private boolean wasNumerRolled(){
        if(guess == v1) return true;
        else if (guess == v2) return true;
        else if (guess == v3) return true;
        else return false;
    }

    private boolean isDoubles(){

        
        if(guess ==v1 && guess ==v2) return true;
        else if(guess == v1 && guess ==v3) return true;
        else if(guess == v2 && guess ==v3) return true;
        else return false;

    }

    private boolean isTriplet(){

        if(guess ==v1 && guess == v2 && guess ==v3) return true;
        else return false;

    }

    public void playGame(){
        rollDice();
      
        if(isTriplet()){

            credits +=50;
            message = "Three of a Kind!";

        }
        else if(isDoubles()){
            credits+=20;
            message = "A pair!";

        }
        else if(wasNumerRolled()){

            credits+=10;
            message = "only one match";

        }
        else {
            credits-=10;
            message = "No match - you lose!";
        }
    }

}