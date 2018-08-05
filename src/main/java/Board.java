import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Grzesiek on 2018-08-05
 */
@ToString
@Getter
@Setter
public class Board {

    private Sign[][] board;

    public Board(Sign[][] board) {
        this.board = new Sign[3][3];
    }

    public Sign[][] createNewBoard() {
        return getBoard();
    }

    public Sign[][] getBoard() {
        return board;
    }

    public boolean signField(int x, int y, Sign sign) {
        if (this.board[x][y]==null) {
            this.board[x][y] = sign;
            return true;
        } else return false;
    }


}
