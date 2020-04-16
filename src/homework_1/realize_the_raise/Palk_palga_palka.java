package homework_1.realize_the_raise;
import java.util.Scanner;

public class Palk_palga_palka {
    static double[] salaries ={100, 1000, 999, 875, 1652, 200, 2000, 123, 8, 998, 1001, 1002, 563, 124, 3526357, 9292, 22, 243};
    static int limit_pay= get_input();

    public static int get_input(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("These are the current values for salaries: ");
        for(int i = 0; i<salaries.length; i++){
            System.out.print(salaries[i] + ", ");
        }
        System.out.println("");
        System.out.println("Please enter a value for the upper limit of raise qualified salaries.");

        int limit_pay = myObj.nextInt();

        return limit_pay;
    }
    public static void realize_the_raise(double limit_pay){
        System.out.println("New salaries are as follows: ");
        for(int i=0; i< salaries.length ; i++){
            if(salaries[i] < limit_pay){
                salaries[i] = salaries[i] * 1.05;
            }
            System.out.print(salaries[i] + ", ");
        }


    }
    public static void main(String[]args){
        realize_the_raise(limit_pay);
    }
}
