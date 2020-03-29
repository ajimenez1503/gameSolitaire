package deck;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;

import card.Card;

/**
 * Deck
 */
public class Deck {

    private ArrayList<Card> cards;
    private int lastPosition;

    public Deck() {
        cards = new ArrayList<Card>();
        lastPosition = 0;
    }

    public void start() {
        lastPosition = 0;
        cards.clear();
        for (int i = 0; i < Card.SUITS.length; i++) {
            for (int j = 0; j < Card.RANKS.length; j++) {
                try {
                    cards.add(new Card(Card.SUITS[i], Card.RANKS[j]));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }
    }

    public void shuffle() {
        // System.out.println("shuffle cards");
        for (int i = 0; i < cards.size(); i++) {
            int r = i + (int) (Math.random() * (cards.size() - i));
            Collections.swap(cards, r, i);
        }
    }

    public void list_cards() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i).toString());
        }
    }

    public Card next_card() {
        if (lastPosition < cards.size()) {
            return cards.get(lastPosition++);
        } else {
            return null;
        }
    }

    public boolean more_cards() {
        System.out.println(cards.size() - lastPosition + " cards left.");
        if (lastPosition < cards.size()) {
            return true;
        } else {
            return false;
        }
    }

}