package game;

import deck.Deck;
import board.Board;
import card.Card;

/**
 * Game
 */
public class Game {

    private Deck deck;
    private Board board;

    public Game() {
        deck = new Deck();
        board = new Board();
    }

    public void start() {
        // System.out.println("Start the game");
        deck.start();
        deck.shuffle();
        deck.list_cards();

        board.start();
        next_card();
        display_board();
    }

    public boolean next_card() {
        Card card = deck.next_card();
        if (card != null) {
            board.add_card(card);
            return true;
        } else {
            System.out.println("There is not more cards");
            return false;
        }
    }

    public void display_board() {
        board.display();
    }

    public void discard() {
        board.discard_repeated();
    }

    /* Is it possible to play other round */
    public boolean can_play() {
        if (deck.more_cards() || board.can_discard()) {
            return true;
        } else {
            System.out.println("Game over");
            return false;
        }
    }

}