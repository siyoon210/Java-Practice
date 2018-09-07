package fastcampus.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardList = new ArrayList<Card>();
    private int totalNum;

    public Player(){
        this.totalNum=0;
    }

    public Player(String name) {
        this.name = name;
        this.totalNum=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCard(Card c) {
        cardList.add(c);
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
