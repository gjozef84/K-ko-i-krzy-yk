import java.util.Arrays;
import java.util.List;

/**
 * Created by Grzesiek on 2018-08-05
 */
public class CheckBoard {

    private static int FIRST_FIELD = 0;
    private static int SECOND_FIELD = 1;
    private static int THIRD_FIELD = 2;

    private static List<List<List<Integer>>> winningCombinations = Arrays.asList(
            Arrays.asList( Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, 2)),
            Arrays.asList( Arrays.asList(1, 0), Arrays.asList(1, 1), Arrays.asList(1, 2)),
            Arrays.asList( Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2)),
            Arrays.asList( Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 0)),
            Arrays.asList( Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1)),
            Arrays.asList( Arrays.asList(0, 2), Arrays.asList(1, 2), Arrays.asList(2, 2)),
            Arrays.asList( Arrays.asList(0, 0), Arrays.asList(1, 1), Arrays.asList(2, 2)),
            Arrays.asList( Arrays.asList(2, 0), Arrays.asList(1, 1), Arrays.asList(0, 2))

    );

    public static Sign check(Board board) {
        for (List<List<Integer>> winningCombination : winningCombinations) {
            List<Integer> firstField = winningCombination.get(FIRST_FIELD);
            if  (board.getField(firstField) == null) {
                continue;
            }
            if (isEqual(board.getField(winningCombination.get(FIRST_FIELD)),
                    board.getField(winningCombination.get(SECOND_FIELD)),
                    board.getField(winningCombination.get(THIRD_FIELD)))) {
                return board.getField(firstField);
            }
        }
        return Sign.NONE;
    }

    private static boolean isEqual(Sign s1, Sign s2, Sign s3) {
        return s1 == s2 && s2 == s3;
    }
}
