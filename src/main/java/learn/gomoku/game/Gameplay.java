package learn.gomoku.game;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
//import learn.gomoku.game.Menu2;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;
import learn.gomoku.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {

    public void printGameBoard(List<Stone> previousMoves){
        // start with empty board
        String[][] gameBoard = {
            {"   ", " 01"," 02"," 03"," 04"," 05"," 06"," 07"," 08", " 09"," 10"," 11"," 12"," 13"," 14"," 15",},
            {"01 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"02 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"03 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"04 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"05 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"06 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"07 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"08 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"09 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"10 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"11 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"12 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"13 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"14 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
            {"15 ", "  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _","  _",},
        };

        // populate board with previous moves
        for (int i = 0; i < previousMoves.size(); i++) {
            Stone move = previousMoves.get(i);
            gameBoard[move.getRow()+1][move.getColumn()+1] = move.isBlack() ? "  B" : "  W";
        }

        // print board
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard[row].length; column++) {
                System.out.print(gameBoard[row][column]);
            }
            System.out.println();
        }
    }

//    public Stone takeTurn(boolean isBlacksTurn) {
//        System.out.println("Enter a row: ");
//        Scanner console = new Scanner(System.in);
//        int rowSelection = console.nextInt();
//        System.out.println("Enter a column: ");
//        //Scanner console2 = new Scanner(System.in);
//        int columnSelection = console.nextInt();
//        Stone stone = new Stone(rowSelection, columnSelection, isBlacksTurn);
//        return stone;
//
//
//    }

//
////    public static int getWidth() {
////        return WIDTH;
////    }
//
////    public static String getWallCharacter() {
////        return WALL_CHARACTER;
////    }
//
////    public static String getEmptyCharacter() {
////        return EMPTY_CHARACTER;
////    }
//
//
//
//    private final Scanner console = new Scanner(System.in);
//    private Player player;
////    private Player player2;
////    private Treasure treasure;
//
//    private boolean isOver;
//
//    public static int getRow() {
//    }
//
//    public boolean isOver() {
//        return isOver;
//    }
//
//
//    public Gameplay(Player player, int move) {
//        this.player = player;
//
//    }
//
//    public String move(char move) {
//
//        switch (move) {
//            case 'W':
//                hero.moveUp();
//                break;
//            case 'A':
//                hero.moveLeft();
//                break;
//            case 'S':
//                hero.moveDown();
//                break;
//            case 'D':
//                hero.moveRight();
//                break;
//        }
//
//        if (hero.getX() < 0 || hero.getX() >= WIDTH
//                || hero.getY() < 0 || hero.getY() >= WIDTH) {
//            //System.out.println(hero.getName() + " touched lava! You lose.");
//            isOver = true;
//            return hero.getName() + " touched lava! You lose.";
//        } else if (hero.getX() == treasure.getX() && hero.getY() == treasure.getY()) {
//            //System.out.println(hero.getName() + " found the treasure! You win.");
//            isOver = true;
//            return hero.getName() + " found the treasure! You win.";
//        }
//        return hero.getName() + " has safely moved, what will you do next?";
//    }
//
//
//    public ArrayList<Stone> getStones() {
//        ArrayList<Stone> stones = new ArrayList<>();
//        stones.add((Stone) player);
//        stones.add(treasure);
//        return stones;
//    }
//}
}