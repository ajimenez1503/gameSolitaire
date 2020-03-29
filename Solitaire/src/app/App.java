package app;

import player.*;
/**
 * App
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Solitaire game");
        Player new_player = new Player();
        new_player.start();
    }
}