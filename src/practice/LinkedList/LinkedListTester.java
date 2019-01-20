package practice.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

class BookContent {
    int id;
    String name;
    int depth;
    int sequence;
    BookContent superBookContent;

    public BookContent(int id, String name, int depth, int sequence, BookContent superBookContent) {
        this.id = id;
        this.name = name;
        this.depth = depth;
        this.sequence = sequence;
        this.superBookContent = superBookContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public BookContent getSuperBookContent() {
        return superBookContent;
    }

    public void setSuperBookContent(BookContent superBookContent) {
        this.superBookContent = superBookContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookContent that = (BookContent) o;

        if (id != that.id) return false;
        if (depth != that.depth) return false;
        if (sequence != that.sequence) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return superBookContent != null ? superBookContent.equals(that.superBookContent) : that.superBookContent == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + depth;
        result = 31 * result + sequence;
        result = 31 * result + (superBookContent != null ? superBookContent.hashCode() : 0);
        return result;
    }
}

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<BookContent> linkedList = new LinkedList<>();
        BookContent bookContent1 = new BookContent(1, "PART 1 언어능력", 0, 0, null);
        BookContent bookContent2 = new BookContent(2, "PART 2 수리능력", 0, 1, null);
        BookContent bookContent3 = new BookContent(3, "PART 3 추리능력", 0, 2, null);
        BookContent bookContent4 = new BookContent(4, "CHAPTER 01 어휘", 1, 0, bookContent1);
        BookContent bookContent5 = new BookContent(5, "CHAPTER 02 독해", 1, 1, bookContent1);
        BookContent bookContent6 = new BookContent(6, "유형1 유의어", 2, 0, bookContent4);
        BookContent bookContent7 = new BookContent(7, "유형2 다의어", 2, 1, bookContent4);
        BookContent bookContent8 = new BookContent(8, "유형3 단어관계", 2, 2, bookContent4);

        linkedList.add(bookContent1);
        linkedList.add(bookContent2);
        linkedList.add(bookContent3);
        linkedList.add(bookContent4);
        linkedList.add(bookContent5);
        linkedList.add(bookContent6);
        linkedList.add(bookContent7);
        linkedList.add(bookContent8);

        for (int i = 0; i < linkedList.size(); i++) {
            BookContent bookContent = linkedList.get(i);
            BookContent superBookContent = bookContent.getSuperBookContent();
            if (superBookContent != null) {
                BookContent tmpBookContent = bookContent;
                linkedList.remove(bookContent);
                linkedList.add(linkedList.indexOf(superBookContent) + 1 + bookContent.getSequence(), tmpBookContent);
            }
        }

        for (BookContent bookContent : linkedList) {
            System.out.println(bookContent.name);
        }
    }
}
