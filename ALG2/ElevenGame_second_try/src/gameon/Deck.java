package gameon;

import elevengame.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author david
 */
public class Deck {

    private List<Card> deckCards = new ArrayList();
    private String[] symbol = DataStore.loadSymbols();
    private String[] value = DataStore.loadValues();
    private int[] points = DataStore.loadNPoints();

    public Deck() {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < value.length; j++) {
                Card c = new Card(symbol[i], value[j], points[j]);
                deckCards.add(c);
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deckCards);
    }

    public boolean isEmpty() {
        if (deckCards.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Deck{" + "deckCards=" + deckCards + ", symbol=" + symbol + ", value=" + value + ", points=" + points + '}';
    }

    public Card getDeckCard(int index) {
        return deckCards.get(index);
    }
    
    public void removeCard(){
        deckCards.remove(0);
    }

    public String getDeck() {
        StringBuilder sb = new StringBuilder();
        //int sum = 0;
        for (Card d : deckCards) {
            //sum+=1;
            sb.append(d.toString() + "\n");
        }
        //sb.append(sum);
        return sb.toString();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.getDeck());

    }
}
