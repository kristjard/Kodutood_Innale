package homework_1.circle_in_a_square;

import java.util.Scanner;


public class C_in_S {

    static double rad = get_input();

    public static double get_input(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter a value for the radius of the circle.");

        double rad = myObj.nextDouble();

        return rad;
    }
    public static void square_area(double rad){
        double area = Math.pow((rad * 2),2);
        System.out.println("The area of the square that holds it all is " + area + "." );
    }
    public static void square_circumference(double rad){
        double circumf = rad * 8;
        System.out.println("The circumference of said square is " + circumf + "." );
    }
    public static void circle_circumference(double rad){
        double circumf = 2*rad*Math.PI;
        System.out.println("The circumference of that same circle is " + circumf + "." );
    }
    public static void circle_area(double rad){
        double area = Math.pow(rad,2) * Math.PI;
        System.out.println("The area of the circle therein is " + area + "." );
    }
    public static void main(String[]args){

        square_area(rad);
        square_circumference(rad);
        circle_area(rad);
        circle_circumference(rad);
    }
}
