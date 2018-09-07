package fastcampus.cardGame;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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


    //카드 5장의 합을 계산한다.
    public int sumNumber(List<Card> c){
        int sum = 0;
        for(int i=0; i<c.size(); i++) {
            sum += c.get(i).getNumber();
        }

        return sum;
    }

    //승자를 판독한다.

    public void sayWinner(List<Player> playerList){
        Player winner = new Player();
        for(int i=0; i<playerList.size(); i++) {
            if(playerList.get(i).getTotalNum() > winner.getTotalNum()){
                winner =playerList.get(i);
            }

        }

        System.out.println("승자는 " + winner.getName());
    }

}
