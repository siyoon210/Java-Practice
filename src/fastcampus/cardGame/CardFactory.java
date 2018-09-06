package fastcampus.cardGame;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public CardFactory() {
    }

    public static List<Card> createDeck(){
        String[] types = new String[]{"스페이드","다이아","하트","클로버"};
        List<Card> deck = new ArrayList<Card>();
        for(String t : types){
            for(int i = 1; i<=13; i++){
                Card c = new Card(i, t);
                deck.add(c);
            }
        }
        return deck;
    }
}
