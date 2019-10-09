package Models.Board;

import java.util.ArrayList;
import java.util.List;

public abstract class Base {

  protected static final int BOARDLENGTH = 8;
  protected static final int BOARDSIZE = BOARDLENGTH * BOARDLENGTH;

  protected static final boolean WHITE = true;
  protected static final boolean BLACK = false;

  protected List<Tile> board;

  public Base() {
    board = new ArrayList<>(BOARDSIZE);
    fill_A_Board();
    fill_In_Pieces();
  }


  private void fill_A_Board() {
    int row = 0;
    int col = 0;
    for (int i = 0; i < BOARDSIZE; i++) {
      if (i % BOARDLENGTH == 0) {
        row++;
        col = 1;
      }
      board.add(new Tile(row, col));
      col++;
    }
  }

  abstract void fill_In_Pieces();

  public abstract List<Tile> getBoard();
}
