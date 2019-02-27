package practice.lombok;

public class BookTester {
    public static void main(String[] args) {
        Book book1 = new Book("홍길동전",5000,"20181101");
        Book book2 = new Book();
        Book book3 = new Book("별주부전");
//        book1.setName("홍길동전");
//        book1.setPrice(5000);
//        book1.setReleaseDate("20181101");
        System.out.println(book1.toString());
        System.out.println(book1.hashCode());

        System.out.println(book1.getName() + ", " + book1.getPrice() + "원, " + book1.getReleaseDate());
    }
}
