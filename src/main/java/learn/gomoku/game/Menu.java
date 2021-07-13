package learn.gomoku.game;

import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;

public class Menu {

    private Object Player;

    public Player[] start() {

        // starting menu state
        int playerSelection = -1;

        // empty array to return final 2 players
        Player[] allPlayers = {};
        setUPPlayer1();

            // prevents the program from crashing when non-integer entered
            try {
                Scanner console = new Scanner(System.in);
                playerSelection = console.nextInt();
            } catch (InputMismatchException e) {
                errorMessage();
//                continue;
            }

            // Player 1 is human
            switch (playerSelection) {
                case 1:
                    String playerType = "human";
                    System.out.print("Player 1, enter your name: ");
                    Player player1 = getPlayer(playerType);
                    // to confirm the correct player is returned with name
                    System.out.println("Player 1 is called " + player1.getName() + "\n");

                    setUPPlayer2();
                    // second player selection state
                    int playerSelection2 = -1;

                    // prevents the program from crashing when non-integer entered
                    try {
                        Scanner console2 = new Scanner(System.in);
                        playerSelection2 = console2.nextInt();
                    } catch (InputMismatchException e) {
                        errorMessage();
//                        continue;
                    }

                    // Player 2 is random
                    if (playerSelection2 == 2) {
                        String playerType2 = "random";
                        Player player2 = getPlayer(playerType2);
                        System.out.print("Player 2, enter your name: " + player2.getName()+ "\n");
                        // to confirm the correct player is returned with name
                        System.out.println("Player 2 is called " + player2.getName() + "\n");
                        // add both players to array
                        allPlayers = new Player[]{player1, player2};

                        // Player 2 is also human
                    } else if (playerSelection2 == 1) {
                        String playerType3 = "human";
                        System.out.print("Player 2, enter your name: ");
                        Player player3 = getPlayer(playerType3);
                        // to confirm the correct player is returned with name
                        System.out.println("Player 2 is called " + player3.getName() + "\n");
                        // add both players to array
                        allPlayers = new Player[]{player1, player3};

                    } else {
                        System.out.println("Please select option 1 or 2.");
                    }
                    break;

                // Player 1 is random
                case 2:
                    String playerType4 = "random";
                    Player player4 = getPlayer(playerType4);
                    // to confirm the correct player is returned with name
                    System.out.print("Player 1, enter your name: " + player4.getName()+ "\n");
                    // add both players to array
                    System.out.println("Player 1 is called " + player4.getName() + "\n");

                    setUPPlayer2();
                    // second player selection state
                    int playerSelection3 = -1;

                    // prevents the program from crashing when non-integer entered
                    try {
                        Scanner console5 = new Scanner(System.in);
                        playerSelection3 = console5.nextInt();;
                    } catch (InputMismatchException e) {
                        errorMessage();
                    }

                    // Player 2 is also random
                    if (playerSelection3 == 2) {
                        String playerType5 = "random";
                        Player player5 = getPlayer(playerType5);
                        System.out.print("Player 2, enter your name: " + player5.getName()+ "\n");
                        // to confirm the correct player is returned with name
                        System.out.println("Player 2 is called " + player5.getName() + "\n");
                        // add both players to array
                        allPlayers = new Player[]{player4, player5};

                        // Player 2 is human
                    } else if (playerSelection3 == 1) {
                        String playerType6 = "human";
                        System.out.print("Player 2, enter your name: ");
                        Player player6 = getPlayer(playerType6);
                        // to confirm the correct player is returned with name
                        System.out.println("Player 2 is called " + player6.getName() + "\n");
                        // add both players to array
                        allPlayers = new Player[]{player4, player6};

                    } else {
                        System.out.println("Please select option 1 or 2.");
                    }
                    break;

                // prevents the program from crashing when integer not in the range 1-3 entered
                default:
                    System.out.println("Invalid option, please select a valid option.");
                    break;
            }
        return allPlayers;
        }

    public Player getPlayer(String playerType) {
        if (playerType == "human") {
            Scanner console = new Scanner(in);
            String humanPlay = console.next();
            HumanPlayer humanPlayer = new HumanPlayer(humanPlay);
            Player = humanPlayer;
        } else if (playerType == "random") {
            RandomPlayer randomPlayer = new RandomPlayer();
            Player = randomPlayer;
        }
        return (learn.gomoku.players.Player) Player;
    }



    public void setUPPlayer1() {
        System.out.print("\nPlayer 1 is:\n1. Human\n2. Random Player\nSelect [1-2]: ");
    }

    public void setUPPlayer2() {
        System.out.print("Player 2 is:\n1. Human\n2. Random Player\nSelect [1-2]: ");
    }

    public void errorMessage() {
        System.out.print("Invalid option, please enter a valid option.\n");
    }

}

