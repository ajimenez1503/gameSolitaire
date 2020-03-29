package card;

import java.util.Arrays;

/**
 * Card
 */
public class Card {

    public static String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades"};

    public static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private String suit;
    private String rank;

    public Card(String suit, String rank) throws Exception {
        this.suit = suit;
        this.rank = rank;
        if (!validate()) {
            throw new Exception("Invalid card");
        }
    }

    private boolean validate() {
        if (!Arrays.asList(SUITS).contains(suit)) {

            System.out.println("suit '" + suit + "' not valid");
            return false;
        }
        if (!Arrays.asList(RANKS).contains(rank)) {
            System.out.println("rank '" + rank + "' not valid");
            return false;
        }
        return true;
    }

    public String toString() {
        String str = "(" + this.suit + ", " + this.rank + ")";
        str = str + new String(new char[17 - str.length()]).replace("\0", " ");
        return str;
    }

    public boolean similar_rank(Card card) {
        return this.rank == card.rank;
    }

}