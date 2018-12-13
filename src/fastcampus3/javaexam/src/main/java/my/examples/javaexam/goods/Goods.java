package fastcampus3.javaexam.src.main.java.my.examples.javaexam.goods;

public class Goods implements Comparable<Goods> {
    private int id;
    private String name;
    private int price;


    public Goods() {
    }

    public Goods(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //id, name, price 같으면 같다고 판단하자
    @Override
    public boolean equals(Object o) {
        //참조가 같으면 트루
        if (this == o) return true;
        //o가 널이면 펄스, 널이아니고 같은 클래스(정보)가 아니라면 펄스
        //getClass()는 현재 클래스정보를 리턴한다.
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (price != goods.price) return false;
        return name != null ? name.equals(goods.name) : goods.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Goods o) {
        return price - o.price;
    }

}