import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private List<List<Integer>> result = new ArrayList<>();
    private Map<Integer, List<Integer>> possibleMoves = Map.of(
            0, Arrays.asList(2, 5, 7, 8),
            1, Arrays.asList(2, 3, 4, 5, 7, 9),
            2, Arrays.asList(1, 3, 4, 5, 6, 8, 0),
            3, Arrays.asList(1, 2, 5, 6, 7, 9),
            4, Arrays.asList(1, 2, 5, 6, 7, 8),
            5, Arrays.asList(0, 1, 2, 3, 4, 6, 7, 8, 9),
            6, Arrays.asList(2, 3, 4, 5, 8, 9),
            7, Arrays.asList(0, 1, 3, 4, 5, 8, 9),
            8, Arrays.asList(0, 2, 4, 5, 6, 7, 9),
            9, Arrays.asList(0, 1, 3, 5, 6, 7, 8));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter init number:");
        int initNum = Integer.parseInt(br.readLine());
        System.out.println("enter password length:");
        int movesCount = Integer.parseInt(br.readLine());

        List<Integer> moves = new ArrayList<>();
        moves.add(initNum);
        Main main = new Main();
        main.backtrack(moves, movesCount - 1, initNum);
        main.printResult();
    }


    public void backtrack(List<Integer> moves, int remainedMoves, int curPosition) {
        if(remainedMoves == 0) {
            result.add(List.copyOf(moves));
            return;
        }
        for (Integer nextMove : possibleMoves.get(curPosition)) {
            if(!moves.contains(nextMove)) {
                moves.add(nextMove);
                backtrack(moves, remainedMoves - 1, nextMove);
                moves.remove(nextMove);
            }
        }
    }

    private void printResult() {
        System.out.println(getResult().size() + "\n" + getResult());
    }

    private List<List<Integer>> getResult() {
        return result;
    }
}
