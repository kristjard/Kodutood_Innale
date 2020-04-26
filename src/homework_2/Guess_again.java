package homework_2;

//Oops, I didn't look at the code you wrote in the lecture, I think I was late or something so didn't know about it.
//I hope this suffices. cheeryo.

import java.util.Scanner;
import java.util.Random;


public class Guess_again {


    public static String get_input(){
        Scanner myObj = new Scanner(System.in);


        String input = myObj.nextLine();
        
        return input;
    }

    public static int outcome_determiner(int input, int magicNumber){
        int outcome;
        if(input == magicNumber){
            outcome = 0;
        }
        else if(input < magicNumber){
            outcome = -1;
        }
        else{
            outcome = 1;
        }
        return outcome;
    }


    public static void main(String[]args){

        Random objGenerator = new Random();
        int magicNumber = objGenerator.nextInt(1000000);

        System.out.println("Would you like to win a million euros?\n" +
                "If so, guess the magic number (a number between 0 and 100000).\n" +
                "Insert 1€ and enter your number or 'q' to quit:");
        long startTime = System.currentTimeMillis();
        int noOfLoops = 0;
        int prevGuess = 0;
        int guessCounter = 0;
        int hintCounter = 0;
        int wasteOfMoneyCounter = 0;
        while(true){
            guessCounter++;
            String initial_input = get_input();
            if(initial_input.equals("")){
                continue;
            }
            if(initial_input.equalsIgnoreCase("q")){
                long endTime = System.currentTimeMillis();
                long timeItTook = (endTime - startTime)/60000;
                System.out.println("Thank you for playing, you guessed a total of " + guessCounter +" times and \n" +
                        "used " + hintCounter + " hints. In total you wasted " + wasteOfMoneyCounter + "€ and a whopping\n" +
                        " " + timeItTook + " minutes of your life!");
                break;
            }
            if(initial_input.equalsIgnoreCase("y") && noOfLoops != 0){
                if(outcome_determiner(prevGuess, magicNumber) < 0){
                    hintCounter++;
                    wasteOfMoneyCounter += 2;
                    System.out.println("You need to think bigger!\n" +
                            "Guess again:");

                }
                else{
                    System.out.println("You overshot just a bit, mate!\n" +
                            "Guess again: ");
                }
                continue;

            }
            if(initial_input.equalsIgnoreCase("y")){
                System.out.println("You havent guessed yet, so have a try. Or quit while you're a head.");
                continue;
            }
            else{
                int input = Integer.parseInt(initial_input);
                if(outcome_determiner(input, magicNumber) != 0){
                    noOfLoops++;
                    wasteOfMoneyCounter++;
                    prevGuess = input;

                    System.out.println("Guess again. Same rules apply. 1€ for a new guess 2€ for pressing 'y', which gives\n" +
                            " you a hint. Or be a looser and quit with 'q'.");
                }
                else{
                    System.out.println("I don't believe it, you actually won!\n" +
                            "To get your prize, contact Inna Švartsman at inna.svartsman@eek.ee with your contact details.");
                    break;
                }
            }
        }
    }
}
