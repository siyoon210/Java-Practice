package practice.collections.list.sort;

public class Book implements Comparable<Book> {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book o) {
//        return price-o.price;
        return o.price-price;
    }
}
