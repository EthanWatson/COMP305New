public class UsedCar implements Comparable<UsedCar> {
    Integer id;
    String make;
    String model;
    Integer price;
    Integer year;
    static Integer nextId = 1000;

    public UsedCar(String make, String model, Integer price, Integer year) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
        this.id = nextId;
    }

    @Override
    public String toString() {
        return "UsedCar [id= " + id + ", make= " + make + ", model= " + ", price= " + price + ", year= " + year + "]";
    }

    @Override
    public int compareTo(UsedCar otherCar) {
        int priceValue = 2;

        if (this.price > otherCar.price)
            priceValue = 1;
        if (this.price < otherCar.price)
            priceValue = -1;
        if (this.price == otherCar.price)
            priceValue = 0;

        return priceValue;
    }
}