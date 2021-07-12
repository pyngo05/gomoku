package learn.gomoku;

import learn.gomoku.game.*;
//import learn.gomoku.game.Menu2;
import learn.gomoku.players.Player;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();

//        Menu2 menu = new Menu2();
//        menu.Run();
        Player[] allPlayers = menu.start();
        Player player1 = allPlayers[0];
        Player player2 = allPlayers[1];

        Gomoku gomoku = new Gomoku(player1,player2);
        System.out.println("(Randomizing)\n\n" + gomoku.getCurrent().getName() + " goes first.");
        System.out.println(gomoku.getCurrent().getName() + "'s Turn");

        Gameplay game = new Gameplay();

        do {
            boolean isBlacksTurn = gomoku.isBlacksTurn();
            Stone stone = gomoku.getCurrent().generateMove(gomoku.getStones());
            Result result = gomoku.place(stone);
            if (!result.isSuccess()) {
                System.out.println(result.getMessage());
            } else {
                game.printGameBoard(gomoku.getStones());
            }

        }
        while (!gomoku.isOver());
        //TODO check for winner

        Player winner = gomoku.getWinner();
        if (winner == null) {
            //draw
            return gomoku.place();
        } else {
            //someone won
        }
    }
}
