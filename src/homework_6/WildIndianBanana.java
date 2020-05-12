package homework_6;
import java.util.Random;

public class WildIndianBanana extends Banana {
    private final Random rnd = new Random();
    private int curvature;

    public WildIndianBanana(String type, double basePrice) {
        super(type, basePrice);
        this.curvature = rnd.nextInt(46);
    }

    @Override
    public int bestBefore() {
        return super.bestBefore()/2;
    }

    public String isEdible(){
        if(curvature < 15){
            return "This banana is too straight, monkey no eat.";
        }
        if(curvature > 30){
            return "This banana is too curvy, monkey no eat.";
        }
        return "Monkey hapy, monkey eat!";
    }

    @Override
    public String toString() {
        return "WildIndianBanana{" +
                "curvature=" + curvature +
                "} " + super.toString() + " " + isEdible();
    }
}
