package my.examples.javaexam;

//Item을 한개 가질 수 있는 상자.
//Box가 태어날때(?) 부터 Item을 가지고 태어나는 것은 아니다.
//Item을 한개 저장하고, Item을 꺼내고 싶다.
public class Box {
    private Item item; //null을 가진다. (참조하는 것이 없다.)

    public void add(Item item) {
        this.item = item;
    }

    public Item get() {
        return item;
    }
}
