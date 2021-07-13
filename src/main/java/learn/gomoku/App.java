package learn.gomoku;

import learn.gomoku.game.*;
import learn.gomoku.players.Player;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class App {

    public static void main(String[] args) {

        startingMenu();
        Scanner console = new Scanner(in);
        int menuSelection = console.nextInt();
        if (menuSelection == 1) {
            Menu menu = new Menu();

            Player[] allPlayers = menu.start();
            Player player1 = allPlayers[0];
            Player player2 = allPlayers[1];

            Gomoku gomoku = new Gomoku(player1,player2);
            System.out.println("(Randomizing)\n\n" + gomoku.getCurrent().getName() + " goes first.");
            System.out.println(gomoku.getCurrent().getName() + "'s Turn");

            Gameplay game = new Gameplay();

            do {
                Stone stone = gomoku.getCurrent().generateMove(gomoku.getStones());
                Result result = gomoku.place(stone);
                if (!result.isSuccess()) {
                    System.out.println(result.getMessage());
                } else {
                    game.printGameBoard(gomoku.getStones());
                }

            }
            while (!gomoku.isOver());

            Player winner = gomoku.getWinner();
            if (winner == null) {
                System.out.println("Game ends in a draw!");
            } else {
                System.out.println(winner.getName() + " Wins!");
            }
        } else {
            System.out.println("\nThanks for playing. Goodbye!");
            System.exit(0);
        }

    }

    public static void startingMenu() {
        System.out.print("\nWelcome to Gomoku\n" +
                "=================\n\nMenu\n\n1. Game Set Up\n2. Quit Game\nSelect [1-2]: ");
    }

}
