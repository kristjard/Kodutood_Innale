package homework_5;



public class FoodItemsRestocked extends FoodItems {
    private String longExpirationDate;

    public FoodItemsRestocked(int productId, String name, int stockQuantity, double price, String longExpirationDate) {
        super(productId, name, stockQuantity, price);
        this.longExpirationDate = longExpirationDate;
    }

    public String getLongExpirationDate() {
        return longExpirationDate;
    }

    public void setLongExpirationDate(String longExpirationDate) {
        this.longExpirationDate = longExpirationDate;
    }
    @Override
    public double calculateInventoryValue(){
        return super.calculateInventoryValue() *1.05;
    }

    @Override
    public String toString() {
        return "FoodItemsRestocked{" +
                "longExpirationDate='" + longExpirationDate + '\'' +
                '}' + super.toString();
    }
}
