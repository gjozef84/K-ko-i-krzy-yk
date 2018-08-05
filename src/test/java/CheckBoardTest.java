import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Grzesiek on 2018-08-05
 */
public class CheckBoardTest {


    Board board = new Board();

    @Test
    public void shouldCheckReturnNULLforEmptyBoard() {
        assertEquals(null, CheckBoard.check(board));
    }

    @Test
    public void shouldReturnXsignForWinnerXInRow() {
        board.signField(0, 0, Sign.X);
        board.signField(0, 1, Sign.X);
        board.signField(0, 2, Sign.X);
        assertEquals(Sign.X, CheckBoard.check(board));
    }

    @Test
    public void shouldReturnOsignForWinnerO() {
        board.signField(2, 0, Sign.O);
        board.signField(2, 1, Sign.O);
        board.signField(2, 2, Sign.O);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board.getField(i, j)+" ");
            }
            System.out.print("\n");
        }

        assertEquals(Sign.O, CheckBoard.check(board));
    }

    @Test
    public void shouldReturnTrueWhenHasWinnerOInColumn(){
        board.signField(0, 0, Sign.O);
        board.signField(0, 1, Sign.O);
        board.signField(0, 2, Sign.O);

        Assertions.assertThat(CheckBoard.check(board)).isEqualTo(Sign.O);
    }

    @Test
    public void shouldReturnTrueWhenHasWinnerOInAcross(){
        board.signField(0, 0, Sign.O);
        board.signField(1, 1, Sign.O);
        board.signField(2, 2, Sign.O);

        Assertions.assertThat(CheckBoard.check(board)).isEqualTo(Sign.O);
    }
}