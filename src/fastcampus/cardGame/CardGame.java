package fastcampus.cardGame;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public static void main(String[] args){
        List<Card> deck = CardFactory.createDeck();
//        for(Card c : deck){
//            System.out.println(c.getNumber()+" " +c.getType());
//        }

        Dealer d = new Dealer("김딜러");

        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("김선수"));
        playerList.add(new Player("이선수"));
        playerList.add(new Player("박선수"));

        //딜러가 카드를 섞는다
        d.setPlayerList(playerList);
        d.setCardList(deck);
        d.shuffle();

        //플레이어가 카드를 5장씩 받는다
        for (int i = 0; i < 5; i++){
             for(Player p : playerList){
                p.setCard(d.getNextCard());
            }
        }

        for(Player p : playerList){
            System.out.print(p.getName() +":");
            for(int i=0; i<5; i++) {
                System.out.print(p.getCardList().get(i).getNumber() + " " + p.getCardList().get(i).getType() + "/");
            }
            System.out.println(" ");
        }

        //딜러가 플레이어 들의 카드 숫자의 합계를 받는다
    }
}
