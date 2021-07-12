//package learn.gomoku.game;
//
//import learn.gomoku.game.Gameplay;
//import learn.gomoku.game.Gomoku;
//import learn.gomoku.game.Result;
//import learn.gomoku.game.Stone;
//import learn.gomoku.players.HumanPlayer;
//import learn.gomoku.players.Player;
//import learn.gomoku.players.RandomPlayer;
//
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//import static java.lang.System.in;
//
//public class Menu2 {
//    private final Scanner console = new Scanner(System.in);
//    private Gameplay myGame;
//    private Object Player;
//    Player[] allPlayers = {};
//
//    public void Run() {
//        boolean continueMenu = true;
//        printGreeting();
//        do {
//            printMenu();
//            int selection = getChoice();
//            switch (selection) {
//                case 1:
//                    setUPPlayer1();
//                    int playerSelection = -1;
//                    try {
//                        Scanner console = new Scanner(System.in);
//                        playerSelection = console.nextInt();
//                    } catch (InputMismatchException e) {
//                        errorMessage();
//                        continue;
//                    }
//                    if (playerSelection == 1) {
//                        String playerType = "human";
//                        System.out.print("Player 1, enter your name: ");
//                        Player player1 = getPlayer(playerType);
//                        System.out.println("Player 1 is called " + player1.getName() + "\n");
//
//                        setUPPlayer2();
//                        int playerSelection2 = -1;
//
//                        // prevents the program from crashing when non-integer entered
//                        try {
//                            Scanner console2 = new Scanner(System.in);
//                            playerSelection2 = console2.nextInt();
//                        } catch (InputMismatchException e) {
//                            errorMessage();
////                        continue;
//                        }
//
//                        // Player 2 is random
//                        if (playerSelection2 == 2) {
//                            String playerType2 = "random";
//                            Player player2 = getPlayer(playerType2);
//                            System.out.print("Player 2, enter your name: " + player2.getName()+ "\n");
//                            System.out.println("Player 2 is called " + player2.getName() + "\n");
//                            allPlayers = new Player[]{player1, player2};
//
//                            Stone setUpStone = new Stone(Gameplay.getRow() - 1, Gameplay.getColumn() - 1);
//                            learn.gomoku.players.Player setupHero;
//                            myGame = new Gameplay(setUpPlayer,setUpStone);
//
//                            // Player 2 is also human
//                        } else if (playerSelection2 == 1) {
//                            String playerType3 = "human";
//                            System.out.print("Player 2, enter your name: ");
//                            Player player3 = getPlayer(playerType3);
//                            System.out.println("Player 2 is called " + player3.getName() + "\n");
//                            allPlayers = new Player[]{player1, player3};
//
//                        } else {
//                            System.out.println("Please select option 1 or 2.");
//                        }
//                    } else if (playerSelection == 2) {
//                        String playerType4 = "random";
//                        Player player4 = getPlayer(playerType4);
//                        System.out.print("Player 1, enter your name: " + player4.getName()+ "\n");
//                        System.out.println("Player 1 is called " + player4.getName() + "\n");
//
//                        setUPPlayer2();
//                        int playerSelection3 = -1;
//
//                        // prevents the program from crashing when non-integer entered
//                        try {
//                            Scanner console5 = new Scanner(System.in);
//                            playerSelection3 = console5.nextInt();;
//                        } catch (InputMismatchException e) {
//                            errorMessage();
////                        continue;
//                        }
//
//                        // Player 2 is also random
//                        if (playerSelection3 == 2) {
//                            String playerType5 = "random";
//                            Player player5 = getPlayer(playerType5);
//                            System.out.print("Player 2, enter your name: " + player5.getName()+ "\n");
//                            System.out.println("Player 2 is called " + player5.getName() + "\n");
//                            allPlayers = new Player[]{player4, player5};
//
//                            // Player 2 is human
//                        } else if (playerSelection3 == 1) {
//                            String playerType6 = "human";
//                            System.out.print("Player 2, enter your name: ");
//                            Player player6 = getPlayer(playerType6);
//                            System.out.println("Player 2 is called " + player6.getName() + "\n");
//                            allPlayers = new Player[]{player4, player6};
//
//                        } else {
//                            System.out.println("Please select option 1 or 2.");
//                        }
//                    }
//
//                    break;
//                case 2:
//                    if (myGame != null) {
//                        printGame(myGame);
//                        while(!myGame.isOver()){
//                            char move = getMove();
//                            System.out.println(myGame.move(move));
//                            printGame(myGame);
//                        }
//                    }
//                    break;
//                case 3:
//                    continueMenu = false;
//                    break;
//                default:
//                    break;
//            }
//        } while(continueMenu);
//        printFarewell();
//    }
//
//    private char getMove() {
//        System.out.println("Enter a direction for the hero to move [WASD]");
//        String selection = console.nextLine();
//
//        return selection.toUpperCase().charAt(0);
//    }
//
//    public Player getPlayer(String playerType) {
//        if (playerType == "human") {
//            Scanner console = new Scanner(in);
//            String humanPlay = console.next();
//            HumanPlayer humanPlayer = new HumanPlayer(humanPlay);
//            Player = humanPlayer;
//        } else if (playerType == "random") {
//            RandomPlayer randomPlayer = new RandomPlayer();
//            Player = randomPlayer;
//        }
//        return (learn.gomoku.players.Player) Player;
//    }
//
//    public void setUPPlayer1() {
//        System.out.print("\nPlayer 1 is:\n1. Human\n2. Random Player\nSelect [1-2]: ");
//    }
//
//    public void setUPPlayer2() {
//        System.out.print("Player 2 is:\n1. Human\n2. Random Player\nSelect [1-2]: ");
//    }
//
//    private String getName() {
//        System.out.println("Enter a name for your hero: ");
//        String name = null;
//        do {
//            name = console.nextLine();
//        } while (name == null || name.length() <=0);
//        return name;
//    }
//
//    private void printFarewell() {
//        System.out.println("Thanks for playing!");
//    }
//
//    private int getChoice() {
//        int value;
//        String input = console.nextLine();
//        value = Integer.parseInt(input);
//        return value;
//    }
//
//    private void printMenu() {
//        System.out.print("1. Game Set Up\n2. Play Game\n3. Exit\nSelect [1-3]: ");
//    }
//
//    private void printGreeting() {
//        System.out.println("\nWelcome to Gomoku!\n" +
//                "~~~~~~~~~~~~~~~~~~~~");
//    }
//
//    public void errorMessage() {
//        System.out.print("Invalid option, please enter a valid option.\n");
//    }
//
//    private void printGame(Gameplay myGame) {
//        System.out.println(Gameplay.getWallCharacter().repeat(Gameplay.getWidth() + 2 ));
//        ArrayList<Stone> toDraw = myGame.getStones();
//
//        for (int row = 0; row < Gameplay.getWidth(); row++) {
//            // left wall border
//            System.out.print(Gameplay.getWallCharacter());
//            for (int col = 0; col < Gameplay.getWidth(); col++) {
//                GameToken current = null;
//                for (GameToken t: toDraw) {
//                    if (row == t.getY() && col == t.getX()) {
//                        current = t;
//                    }
//                }
//                if (current != null) {
//                    System.out.print(current.getSymbol());
//                }  else {
//                    System.out.print(Gameplay.getEmptyCharacter());
//                }
//            }
//
//            // right wall border
//            System.out.println(Gameplay.getWallCharacter());
//        }
//
//        System.out.println(Gameplay.getWallCharacter().repeat(Gameplay.getWidth() + 2));
//
//    }
//
//}
