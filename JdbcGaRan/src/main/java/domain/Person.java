package domain;

public class Person {
    private int id;
    private String name;
    private double price;

    public Person(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter và Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Giá: " + price + " VNĐ";
    }
}