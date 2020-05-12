package homework_6;

import java.util.ArrayList;
import java.util.Random;

public class TestClass {


    public static void main(String[] Args){
        ArrayList<Banana> order = new ArrayList<Banana>();
        int bananaType;
        boolean yesNo;
        Random rnd = new Random();
        for(int i = 0; i<10; i++){
            bananaType = rnd.nextInt(3);
            if(bananaType == 0){
                order.add(new Cavendish("Cavendish", 0.2));
            }
            else if(bananaType == 1){
                int j = rnd.nextInt(3);
                if(j<1){ yesNo = false;}
                else{ yesNo = true;}
                order.add(new PanamaBanana("Panamian", 0.4, yesNo));
            }
            else{
                order.add(new WildIndianBanana("Mugawubugabve banana", 0.5));
            }



        }
        for(Banana i : order){
            System.out.println(i.toString());
        }
    }
}
