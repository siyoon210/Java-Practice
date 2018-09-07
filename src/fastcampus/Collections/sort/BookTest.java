package fastcampus.Collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class BookTest {
    public static void main(String[] args){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("자바배우기", 5000, 2001));
        bookList.add(new Book("홍길동전", 3000, 1995));
        bookList.add(new Book("별주부전", 2000, 2018));
        bookList.add(new Book("수학의 정석", 13000, 2015));

        for(Book b : bookList){
            System.out.println(b.getName() + " " + b.getPrice() + "원 " + b.getReleaseYear()+"년 ");
        }

        System.out.println("");
        Collections.sort(bookList);
        System.out.println("--기본정렬(가격으로)--");
        for(Book b : bookList){
            System.out.println(b.getName() + " " + b.getPrice() + "원 " + b.getReleaseYear()+"년 ");
        }

        System.out.println("");
        Collections.sort(bookList, new BookComparator());
        System.out.println("--이름으로 정렬--");
        for(Book b : bookList){
            System.out.println(b.getName() + " " + b.getPrice() + "원 " + b.getReleaseYear()+"년 ");
        }
    }
}
