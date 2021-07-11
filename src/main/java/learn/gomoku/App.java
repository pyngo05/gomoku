package learn.gomoku;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Menu;
import learn.gomoku.players.Player;

public class App {

    public static void main(String[] args) {
        System.out.println("\nWelcome to Gomoku!\n" +
                "~~~~~~~~~~~~~~~~~~~~");
        Menu menu = new Menu();
        Player[] allPlayers = menu.start();
        Player player1 = allPlayers[0];
        Player player2 = allPlayers[1];

        Gomoku gomoku = new Gomoku(player1,player2);
        System.out.println("(Randomizing)\n\n" + gomoku.getCurrent().getName() + " goes first.");

    }
}
