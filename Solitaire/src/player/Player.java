package player;

import game.*;

/**
 * Player
 */
public class Player {

    private Game game;

    public Player() {
        game = new Game();
    }

    public void start() {
        // System.out.println("Start the player");
        game.start();

        play();
    }

    public void play() {
        while (game.can_play()) {
            choose_action();
        }
    }

    private void choose_action() {
        System.out.println("Select action:");
        System.out.println("- Next card (enter)");
        System.out.println("- Re-start (s)");
        System.out.println("- Discard similar card (d)");
        System.out.println("- Exit (e)");

        String command = System.console().readLine();
        // System.out.println("Command chosen: '" + command + "'");
        switch (command) {
            case "s":
                start();
                break;
            case "d":
                game.discard();
                break;
            case "e":
                System.exit(0);
                break;
            case "":
                game.next_card();
                break;
            default:
                choose_action();
                break;
        }

        game.display_board();
    }

}