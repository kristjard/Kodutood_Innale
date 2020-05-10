package homework_5;

import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductTester {

    public static String get_String_input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int get_int_input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static double get_double_input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static void main(String[] Args){
        Vendor vendor = new Vendor("Food unlimited","15 Riverview Ave. Chesterton, IN 46304","Mike Pence",123456789);
        ArrayList<FoodItems> foodItems = new ArrayList<FoodItems>();
        foodItems.add(new FoodItems(1001,"Baby cow growth juice 10% fat milk",200, 1.59));
        foodItems.add(new FoodItems(1002,"Mr. Porkys special sausage",500, 3.59));
        foodItems.add(new FoodItems(1003,"Ground Covfefe",20, 21.99));
        foodItems.add(new FoodItems(1004,"XXL eco farm eggs",250, 4.29));
        foodItems.add(new FoodItems(1005,"Chocolate chip madness cookies",400, 2.75));
        foodItems.add(new FoodItems(1006,"Pride of east Germany sauerkraut",1, 420.69));



        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Hello user, this program returns a list of available products.");
        System.out.println("Please add more products.");
        System.out.println("----------------------------------------------------------------------------");
        int index = 1006;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, +14);
        Date date = c.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String longDate = dateFormat.format(date);
        while(true){
            System.out.println();
            System.out.println("y to proceed or q to exit.");
            if(get_String_input().equalsIgnoreCase("q")) {
                break;
            }
            else{
                index += 1;
                System.out.println("Please enter the product name.");
                String name = get_String_input();
                System.out.println("Please enter the quantity of the product that we currently have on stock.");
                int stock = get_int_input();
                System.out.println("Please enter the products price, make sure to use '.'");
                double price = get_double_input();

                foodItems.add( new FoodItemsRestocked(index, name, stock, price, longDate));


            }
        }

        for(FoodItems i : foodItems){
            i.setVendor(vendor);
            System.out.println(i.toString());
        }
    }
}
