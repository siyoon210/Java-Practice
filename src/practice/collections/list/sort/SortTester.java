package practice.collections.list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortTester {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("자바의정석", 9000));
        bookList.add(new Book("홍길동전", 6000));
        bookList.add(new Book("김소월 시집", 8000));

        Collections.sort(bookList);
        for (Book book : bookList) {
            System.out.println(book.getName()+":"+book.getPrice());
        }

        Collections.sort(bookList,new BookNameComparator());
        for (Book book : bookList) {
            System.out.println(book.getName()+":"+book.getPrice());
        }

    }
}

class BookNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
