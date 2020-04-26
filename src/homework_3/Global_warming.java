package homework_3;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//if you want this to work, you must manually change the path in the read_file method. Sry.

public class Global_warming {
    public static String get_input(){
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        return input;
    }
    public static List<String[]> read_file(String name_of_file) throws IOException {
        String row = "";
        List<String[]> list_of_stuff = new ArrayList<>();
        File csvFile = new File("/home/kristjan/IdeaProjects/Homework_java/src/homework_3/" + name_of_file);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader("/home/kristjan/IdeaProjects/Homework_java/src/homework_3/" + name_of_file));
            String [] data;
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                list_of_stuff.add(data);
            }
            csvReader.close();
        }
        else{
            System.out.println("something went wrong, make sure you added .csv to the suffix.");
        }
        return list_of_stuff;
    }
    public static String[] data_sorter(List<String[]> list_of_stuff, int index) {

        String[] city_data = new String[0];
        switch (index){
            case 0:
                city_data = list_of_stuff.get(0);
               break;
            case 1:
                city_data = list_of_stuff.get(1);
                break;
            case 2:
                city_data = list_of_stuff.get(2);
        }
        return city_data;
    }
    public static String name_returner(String[] city_data){
        String city_name = city_data[0];
        return city_name;
    }
    public static int[] temps(String[] city_data) {
        int[] temps = new int[city_data.length - 1];
        for (int i = 1; i < city_data.length; i++) {
            temps[i - 1] = Integer.parseInt(city_data[i]);
        }
        return temps;
    }
    public static double avg_tmp(int[] temps){
        double avg_tmp;
        int sum = 0;
        int divider = temps.length;

        for(int i = 0; i<divider; i++){
            sum += temps[i];
        }
        avg_tmp = sum / (double)divider;
        return avg_tmp;
    }
    public static int min_temp(int[] temps){
        Arrays.sort(temps);
        int min_tmp = temps[0];
        return min_tmp;
    }
    public static int max_temp(int[] temps){
        Arrays.sort(temps);
        int max_tmp = temps[temps.length-1];
        return max_tmp;
    }
    public static double avg_tmp(int[] temps, int min_tmp, int max_tmp) {
        double avg_tmp;
        int sum = -min_tmp - max_tmp;
        int divider = temps.length - 2;

        for (int i = 0; i < temps.length; i++) {
            sum += temps[i];
        }
        avg_tmp = sum / (double)divider;
        return avg_tmp;
    }

    public static void main(String[]args) throws IOException {
        System.out.println("Please enter the name of the file you would like to use.");
        String name_of_file = get_input();
        List<String[]> list_of_stuff = read_file(name_of_file);

        System.out.println("The file contains the temperature data of the following cities: " +
                name_returner(data_sorter(list_of_stuff, 0)) + ", " +
                name_returner(data_sorter(list_of_stuff, 1)) + " and " +
                name_returner(data_sorter(list_of_stuff, 2)) + ". With the following indexes 0, 1 and 2. \n" +
                "Please specify for which city you would like to receive information about by typing in the index nr.");
        while(true) {
            System.out.println();
            System.out.println("Please make an index selection. If you wish to exit, press the 'q' key.");
            String s_index = get_input();
            if(s_index.equalsIgnoreCase("q")){
                break;
            }
            else {
                int index = Integer.parseInt(s_index);
                String[] city_data = data_sorter(list_of_stuff,index);
                String city_name = name_returner(city_data);
                int[] temps = temps(city_data);
                double avg_tmp = avg_tmp(temps);
                int min_tmp = min_temp(temps);
                int max_tmp = max_temp(temps);
                double avg_tmp_wo_extrema = avg_tmp(temps, min_tmp, max_tmp);
                String answer = String.format("At %s International Airport the average temperature is %.1f degrees. \n" +
                        "The coldest temperature is %s degrees, the hottest temperature is %s degrees \nand " +
                        "the average temperature disregarding the two extremes is %.1f degrees.", city_name, avg_tmp, min_tmp, max_tmp, avg_tmp_wo_extrema);
                System.out.println(answer);
                System.out.println("----------------------------------------------------------------------------------------");




            }


        }


    }
}
//temperatures.csv