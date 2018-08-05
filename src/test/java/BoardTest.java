import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Grzesiek on 2018-08-05
 */
public class BoardTest {

    Sign[][] boardTest = new Sign[3][3];

    Board board = new Board();

    @Test
    public void shouldCreateNewBoard(){
        assertArrayEquals(boardTest, board.createNewBoard());
    }

    @Test
    public void shouldCreateEmptyBoard(){
        assertEquals(null, board.getBoard()[0][0]);
    }

    @Test
    public void shouldSignEmptyField(){
        assertEquals(true, board.signField(0,0, Sign.X));
    }

    @Test
    public void shouldSignEmptyFieldReturnFalse(){
        board.signField(0,0, Sign.X);
        assertEquals(false, board.signField(0,0, Sign.X));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldSignFieldWhenGettingValueForWrongIndexes(){
        //board.signField(0,4, Sign.X);
        board.signField(3,3, Sign.X);
    }

    @Test
    public void shouldGetField(){
        board.signField(0,0, Sign.X);
        assertEquals(Sign.X, board.getField(0,0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldGetFieldWhenGettingValueForWrongIndexes(){
        board.getField(3,0);
    }



}