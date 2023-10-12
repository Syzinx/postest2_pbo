package showroom;

abstract public class Motorcycle {
    private final String id;
    private String brand;
    private String model;
    private int year;
    private int price;

    public Motorcycle(String id, String brand, String model, int year, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public final String getId() {
        return id;
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final int getYear() {
        return year;
    }

    public final int getPrice() {
        return price;
    }

    public final void setBrand(String brand) {
        this.brand = brand;
    }

    public final void setModel(String model) {
        this.model = model;
    }

    public final void setYear(int year) {
        this.year = year;
    }

    public final void setPrice(int price) {
        this.price = price;
    }

    abstract public void displayShowroom();

}
