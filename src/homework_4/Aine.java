package homework_4;


public class Aine {
    public Aine(String aine_kood, String nimetus, int ainepunktide_arv) {
        this.nimetus = nimetus;
        this.ainepunktide_arv = ainepunktide_arv;
        this.aine_kood = aine_kood;
    }
    public Aine(){
    }
    private String aine_kood;
    private String nimetus;
    private int ainepunktide_arv;


    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    public int getAinepunktide_arv() {
        return ainepunktide_arv;
    }

    public void setAinepunktide_arv(int ainepunktide_arv) {
        this.ainepunktide_arv = ainepunktide_arv;
    }

    public String getAine_kood() {
        return aine_kood;
    }

    public void setAine_kood(String aine_kood) {
        this.aine_kood = aine_kood;
    }

    public int eeldatavAjaKulu(){

        int oppimise_aeg;
        oppimise_aeg = ainepunktide_arv * 8;
        return oppimise_aeg;
    }

    @Override
    public String toString() {
        return  "{" + aine_kood + ", " + nimetus + ", " + ainepunktide_arv + ", " + eeldatavAjaKulu() + "}";

    }
}



