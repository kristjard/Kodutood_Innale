package homework_5;

public class FoodItems {
    private int productId;
    private String name;
    private int stockQuantity;
    private double price;
    private Vendor vendor;

    public FoodItems(int productId, String name, int stockQuantity, double price) {
        this.productId = productId;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }
    public FoodItems(Vendor vendor){

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public double calculateInventoryValue(){
        return stockQuantity * price;
    }
    @Override
    public String toString() {
        return "FoodItems{" +
                "product id=" + productId +
                ", name='" + name + '\'' +
                ", stock quantity=" + stockQuantity +
                ", price=" + price + ", inventory value=" + calculateInventoryValue() + " The vendor is " + vendor +
                '}';
    }
}
