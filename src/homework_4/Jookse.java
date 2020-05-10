package homework_4;

public class Jookse {

    public static void main(String[] Args){




        /*Selle osa niimoodi tegemine tundub mulle eriti jabur...
        Kas on mingi meetod kuidas saaksin seda for loobi ja csv failiga teha?
        Ma ei tahtnud loengus küsida, sest teised ilmselt niiigi segaduses...*/
        Aine obj_prg = new Aine("RT-016","Objektorienteeritud Programmeerimine", 5);
        Aine kas_pro = new Aine("RT-019","Kasutajaliidese Prototüüpimine", 2);
        Aine aut_tes = new Aine("RT-020","Automaattestimine", 4);
        Aine lin_alg = new Aine("RT-006","Lineaaralgebra", 5);
        Aine sis_meh = new Aine("RT-024","Sissejuhatus Mehhatroonikasse", 5);
        System.out.println(sis_meh);
        /*Samuti tundub veider see õppekavakood lisada siin... kuna ma saan tagastuses lihtsalt stringi peaksin
        hakkama ArrayListi listidega tagastama, et kuidagi ilusti seda kokku panna. Asendasin lihtsalt lausega.
        Loodan, et see ok.*/
        Aine[] ained = {obj_prg, kas_pro, aut_tes, lin_alg, sis_meh};
        Oppekava opk = new Oppekava("Õppekavad koos koodidega", ained);
        System.out.println();
        System.out.println(opk);
    }
}
