package fastcampus.Collections.sort;

public class Book implements Comparable<Book> {
    String name;
    int price;
    int releaseYear;

    public Book(String name, int price, int releaseYear) {
        this.name = name;
        this.price = price;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int compareTo(Book o) {
        return price - o.getPrice();
    }
}
