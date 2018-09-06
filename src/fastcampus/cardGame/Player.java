package fastcampus.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardList = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
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
}
