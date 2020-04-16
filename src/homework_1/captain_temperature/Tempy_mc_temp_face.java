package homework_1.captain_temperature;
import java.util.Scanner;

public class Tempy_mc_temp_face {

    static double tmp = get_input();
    public static double get_input(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter a value for the current temperature.");

        double tmp = myObj.nextDouble();

        return tmp;
    }
    public static String decider(){
        if(tmp < 10){
            return "cold!";
        }
        else if(tmp > 25){
            return "hot!";
        }
        else{
            return "warm!";
        }


    }
    public static void main(String[]args){
        System.out.println("Wow, that's " + decider());
    }
}
