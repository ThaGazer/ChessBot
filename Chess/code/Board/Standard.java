package Board;

import Pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Standard {

  public static final int BOARDLENGTH = 8;
  public static final int BOARDSIZE = BOARDLENGTH * BOARDLENGTH;

  private static final boolean WHITE = true;
  private static final boolean BLACK = false;

  private static final String errTileFormat = "improper tile formatting: ";
  private static final String errMissingPiece = "could not find piece referenced: ";

  private static final String gameBoard_edge =
      "  -------------------------------------------------";

  private List<Tile> board;

  public Standard() {
    board = new ArrayList<>(BOARDSIZE * BOARDSIZE);
    fill_A_Board();
  }

  /**
   * A key value mapping for a map
   *
   * @param map the map to search through
   * @param val the value to search for
   * @return the mapping for the specified value
   */
  private Piece getKfV(Map<Piece, Tile> map, Tile val) {
    if (map.containsValue(val)) {
      for (Piece p : map.keySet()) {
        if (map.get(p).equals(val)) {
          return p;
        }
      }
    }
    return null;
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
    fill_In_Pieces();
  }

  private void fill_In_Pieces() {
    for(int i = 0; i < BOARDLENGTH; i++) {
      board.get(((BOARDLENGTH * 7)) + i).setPiece(Pieces.getByEnum(Pieces.pieceOrder()[i], BLACK));
      board.get((BOARDLENGTH * 6) + i) .setPiece(new Pawn(BLACK));

      board.get(BOARDLENGTH + i).setPiece(new Pawn(WHITE));
      board.get(i).setPiece(Pieces.getByEnum(Pieces.pieceOrder()[i], WHITE));
    }
  }

  public void printBoard() {
    System.out.println(gameBoard_edge);
    for (int i = BOARDSIZE - 8; i >= 0; i -= 8) {
      System.out.print((i / BOARDLENGTH) + 1 + " ");
      for (int j = 0; j < 8; j++) {
        Piece piece;
        if((piece = board.get(i+j).getPiece()) == null) {
          System.out.print("| " + " -  ");
        } else {
          System.out.print("| " + piece.toString() + " ");
        }
      }
      System.out.println("|");
    }
    System.out.println(gameBoard_edge);

    for (int i = 1; i <= BOARDLENGTH; i++) {
      System.out.print("     " + Tile.Columns.getByNum(i));
    }
    System.out.println();
  }

  public List<Tile> getBoard() {
    return new ArrayList<>(board);
  }

  public Tile getTile(String tile) {
    return board.get(Tile.Columns.getByAlpha(tile.charAt(0)).getNumberRep() * tile.charAt(1));
  }

  public boolean movePiece()
      throws ChessBoardException {
    return true;
  }

  //TODO add combat cases for rest of the pieces
  private boolean combatCases(Piece p, Tile cur, Tile next, boolean turn) {
    return true;
  }
}
