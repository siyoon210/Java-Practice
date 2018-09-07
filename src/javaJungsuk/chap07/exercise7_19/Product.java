package javaJungsuk.chap07.exercise7_19;

public abstract class Product {
    private int price;

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Tv extends Product{
    public Tv() {
        super(200);
    }

    @Override
    public String toString() {
        return "TV";
    }
}
class Computer extends Product{
    public Computer() {
        super(100);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product{
    public Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}