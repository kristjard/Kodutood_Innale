package homework_4;

import java.util.Arrays;

public class Oppekava {

    private String oppekavakood;
    private Aine[] ained;

    public Oppekava(String oppekavakood, Aine[] ained) {
        this.oppekavakood = oppekavakood;
        this.ained = ained;
    }
    Oppekava(){

    }

    public String getOppekavakood() {
        return oppekavakood;
    }

    public void setOppekavakood(String oppekavakood) {
        this.oppekavakood = oppekavakood;
    }

    public Aine[] getAined() {
        return ained;
    }

    public void setAined(Aine[] ained) {
        this.ained = ained;
    }

    @Override
    public String toString() {
        return oppekavakood + Arrays.toString(ained);
    }
}
