package homework_6;
import java.util.Random;

abstract class Banana {
    private double weight;
    private int ripenessIndicator;
    private String type;
    private double basePrice;
    private double price;
    private final Random rnd = new Random();

    public Banana(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
        this.weight = rnd.nextDouble() + 0.6;
        this.ripenessIndicator = rnd.nextInt(10) +1;
        this.price = priceCalculator();

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getRipenessIndicator() {
        return ripenessIndicator;
    }

    public void setRipenessIndicator(int ripenessIndicator) {
        this.ripenessIndicator = ripenessIndicator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int bestBefore(){
        return 10 - ripenessIndicator;
    }
    public double priceCalculator(){ //I used 0.12kg because according to google this is the average weight of a banana.
        if(weight <= 0.12){
            price = basePrice * bestBefore();

        }
        else{
            price = basePrice * bestBefore() * 0.95;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "weight=" + weight +
                ", ripenessIndicator=" + ripenessIndicator +
                ", type='" + type + '\'' +
                ", basePrice=" + basePrice +
                ", price=" + price +
                '}';
    }
}
