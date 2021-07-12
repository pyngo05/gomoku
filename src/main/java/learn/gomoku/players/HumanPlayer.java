package learn.gomoku.players;

import learn.gomoku.game.Stone;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

//    @Override
//    public Stone generateMove(List<Stone> previousMoves) {
//        return null;
//    }

    //TODO how should this be implemented?
    @Override
    public Stone generateMove(List<Stone> previousMoves) {
        boolean isBlack = true;
        if (previousMoves != null && !previousMoves.isEmpty()) {
            Stone lastMove = previousMoves.get(previousMoves.size() - 1);
            isBlack = !lastMove.isBlack();
        }

        System.out.print("Enter a row: ");
        Scanner console = new Scanner(System.in);
        int rowSelection = console.nextInt();
        System.out.print("Enter a column: ");
        //Scanner console2 = new Scanner(System.in);
        int columnSelection = console.nextInt();
        Stone stone = new Stone(rowSelection-1, columnSelection-1, isBlack);
        return stone;
    }
}
