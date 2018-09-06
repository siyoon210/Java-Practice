package fastcampus.cardGame;

import java.util.Collections;
import java.util.List;

public class Dealer {
    private String name;
    private List<Card> cardList;
    private List<Player> playerList;
    private int index;

    public Dealer(String name) {
        this.name = name;
        this.index = 0;
    }

    //선수에게 카드를 다음 한장 준다.
    public Card getNextCard() {
        return cardList.get(index++);
    }

    public void setCardList(List<Card> deck) {
        this.cardList = deck;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    //덱의 카드를 섞는다
    public void shuffle(){
        Collections.shuffle(cardList);
    }


    //결과를 말한다
}
