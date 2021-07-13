package learn.gomoku;

import learn.gomoku.game.*;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;

import java.util.Arrays;
import java.util.List;
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
                //get current player's move
                Stone stone = gomoku.getCurrent().generateMove(gomoku.getStones());
                if (stone == null) {
                    // must be a human player, so ask them for row and column
                    stone = generateMove(gomoku.getStones());
                }

                // place stone
                Result result = gomoku.place(stone);

                // check stone placement success/failure
                if (result.isSuccess()) {
                    game.printGameBoard(gomoku.getStones());
                } else {
                    System.out.println(result.getMessage());
                }
            } while (!gomoku.isOver());

            Player winner = gomoku.getWinner();
            // if game ends in a draw
            if (winner == null) {
                System.out.println("Game ends in a draw!");
            } else {
                // prints winner
                System.out.println(winner.getName() + " wins!");
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

    public static Stone generateMove(List<Stone> previousMoves) {
        boolean isBlack = true;
        if (previousMoves != null && !previousMoves.isEmpty()) {
            Stone lastMove = previousMoves.get(previousMoves.size() - 1);
            isBlack = !lastMove.isBlack();
        }

        System.out.print("Enter a row: ");
        Scanner console = new Scanner(System.in);
        int rowSelection = console.nextInt();
        System.out.print("Enter a column: ");
        int columnSelection = console.nextInt();
        Stone stone = new Stone(rowSelection-1, columnSelection-1, isBlack);
        return stone;
    }

}
