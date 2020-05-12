package homework_6;

public class PanamaBanana extends Banana {
    private boolean hasPanamaCert;

    public PanamaBanana(String type, double basePrice, boolean hasPanamaCert) {
        super(type, basePrice);
        this.hasPanamaCert = hasPanamaCert;
    }

    @Override
    public String toString() {
        return "PanamaBanana{" +
                "hasPanamaCert=" + hasPanamaCert +
                "} " + super.toString();
    }
}
