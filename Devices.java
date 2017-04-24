/**
 * Created by asus on 22.03.2017.
 */

public class Devices {

    double price;
    String model;

    public Devices(double price, String model) {
        this.price = price;
        this.model = model;
    }

    protected void check() {
        System.out.println("it works");
    }

}
