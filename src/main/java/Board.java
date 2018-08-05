import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Grzesiek on 2018-08-05
 */

@Getter
@Setter
public class Board {

    private Sign[][] board;

    public Board() {
        this.board = new Sign[3][3];
    }

    public Sign[][] createNewBoard() {
        return getBoard();
    }

    public Sign[][] getBoard() {
        return board;
    }

    public boolean isEmpty() {
        for (Sign[] row : board) {
            for (Sign field : row) {
                if (field != null) return false;
            }
        }
        return true;
    }

    public boolean signField(int x, int y, Sign sign) {
        if (x > board.length && y > board.length) throw new IndexOutOfBoundsException();

        if (this.board[x][y] == null) {
            this.board[x][y] = sign;
            return true;
        } else return false;
    }

    public Sign getField(int x, int y) {
        if (x > board.length && y > board.length) throw new IndexOutOfBoundsException();
        else return this.board[x][y];
    }

    public Sign getField(List<Integer> coordinates) {
        if (coordinates.size() > 2) {
            throw new IllegalArgumentException("Should get 2 coordinates");
        }
        return getField(coordinates.get(0), coordinates.get(1));
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + (board == null ? null : Arrays.asList(board)) +
                '}';
    }
}
