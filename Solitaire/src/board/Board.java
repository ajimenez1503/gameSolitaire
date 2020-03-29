package board;

import java.util.ArrayList; // import the ArrayList class
import card.Card;

/**
 * Board
 */
public class Board {

    private ArrayList<Card> cards;

    public Board() {
        cards = new ArrayList<Card>();
    }

    public void start() {
        cards.clear();
    }

    public void add_card(Card card) {
        // System.out.println("Added: " + card.toString());
        cards.add(card);
    }

    public void display() {
        System.out.println("||||||||||||||||| ||||||||||||||||| ||||||||||||||||| ||||||||||||||||| |||||||||||||||||");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).toString() + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out
                .println("\n||||||||||||||||| ||||||||||||||||| ||||||||||||||||| ||||||||||||||||| |||||||||||||||||");
    }

    private void remove(int position1, int position2) {
        System.out.println("Remove: " + position1 + " : " + cards.get(position1) + "  " + position2 + " : "
                + cards.get(position2));
        // Make sure to remove first the higher position
        if (position1 < position2) {
            cards.remove(position2);
            cards.remove(position1);
        } else {
            cards.remove(position1);
            cards.remove(position2);
        }

    }

    public void discard_repeated() {
        boolean repeated = false;
        do {
            repeated = false;
            for (int i = 0; i < cards.size(); i++) {

                // Check cards in the row
                if (i + 1 < cards.size() && (i + 1) % 5 != 0 && cards.get(i).similar_rank(cards.get(i + 1))) {
                    remove(i, i + 1);
                    repeated = true;
                    break;
                }
                // Check cards in the colum
                if (i + 5 < cards.size() && cards.get(i).similar_rank(cards.get(i + 5))) {
                    remove(i, i + 5);
                    repeated = true;
                    break;
                }
                // Check cards in the diagonal right
                if (i + 6 < cards.size() && cards.get(i).similar_rank(cards.get(i + 6))) {
                    remove(i, i + 6);
                    repeated = true;
                    break;
                }
                // Check cards in the diagonal left
                if (i + 4 < cards.size() && cards.get(i).similar_rank(cards.get(i + 4))) {
                    remove(i, i + 4);
                    repeated = true;
                    break;
                }
            }
            display();
        } while (repeated);

    }

    public boolean can_discard() {
        for (int i = 0; i < cards.size(); i++) {

            // Check cards in the row
            if (i + 1 < cards.size() && (i + 1) % 5 != 0 && cards.get(i).similar_rank(cards.get(i + 1))) {
                return true;
            }
            // Check cards in the colum
            if (i + 5 < cards.size() && cards.get(i).similar_rank(cards.get(i + 5))) {
                return true;
            }
            // Check cards in the diagonal right
            if (i + 6 < cards.size() && cards.get(i).similar_rank(cards.get(i + 6))) {
                return true;
            }
            // Check cards in the diagonal left
            if (i + 4 < cards.size() && cards.get(i).similar_rank(cards.get(i + 4))) {
                return true;
            }
        }
        return false;
    }
}