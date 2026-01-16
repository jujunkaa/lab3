import java.util.*;
class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }

    @Override public String toString() { return brand + " " + model + " " + year + " "; }
}

public class n2 {
    public static void main(String[] args) {
        Map<String, Car> table = new HashMap<>();

        Car car1 = new Car("Toyota", "Camry", 2025);
        Car car2 = new Car("BMW", "X5", 2021);
        Car car3 = new Car("Porsche", "911", 2024);

        table.put("E999KX", car1);
        table.put("C999CC", car2);
        table.put("M121JS", car3);

        System.out.println(table.get("M121JS"));
        table.remove("E999KX");
        System.out.println(table.get("E999KX"));
    }

}
