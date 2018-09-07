package javaJungsuk.chap07.exercise7_19;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int money;
    private List<Product> cart;

    public Buyer() {
        this.money = 1000;
        this.cart = new ArrayList<Product>();
    }

    //물건을 산다.
    public void buy(Product p){
        if(this.money >= p.getPrice()){
            this.money -= p.getPrice();
            this.cart.add(p);
        }
        else
            System.out.println("잔액이 부족합니다.");;
    }

    public void summary(){
        int totalPrice=0;
        System.out.print("구매목록 : ");
        for(Product p : cart){
            System.out.print(p.toString()+", ");
            totalPrice += p.getPrice();

        }
        System.out.println(" ");
        System.out.println("총 구매액 : "+totalPrice+"원");
        System.out.println("현재 잔액 : " + money);

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
