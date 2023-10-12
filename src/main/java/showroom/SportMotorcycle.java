package showroom;

public class SportMotorcycle extends Motorcycle {
    private int cubicleCentimeter;

    public SportMotorcycle(String id, String brand, String model, int year, int price, int cubicleCentimeter) {
        super(id, brand, model, year, price);
        this.cubicleCentimeter = cubicleCentimeter;
    }

    public final int getCubicleCentimeter() {
        return cubicleCentimeter;
    }

    public final void setCubicleCentimeter(int cubicleCentimeter) {
        this.cubicleCentimeter = cubicleCentimeter;
    }

    @Override
    public void displayShowroom() {
        System.out.println("Sport Motorcycle");
        System.out.println("ID: " + getId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Price: " + getPrice());
        System.out.println("Cubicle Centimeter (CC): " + getCubicleCentimeter());
        System.out.println();
    }
}
