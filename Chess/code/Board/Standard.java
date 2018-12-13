package Board;

import Pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Standard {

  public static final int BOARDROWSIZE = 8;
  public static final int BOARDSIZE = BOARDROWSIZE * BOARDROWSIZE;

  private static final boolean WHITE = true;
  private static final boolean BLACK = false;

  private static final String errTileFormat = "improper tile formatting: ";
  private static final String errMissingPiece = "could not find piece referenced: ";

  private static final String gameBoard_edge =
          "  -------------------------------------------------";

  private List<Tile> board;
  private Map<Piece, Tile> wpm;
  private Map<Piece, Tile> bpm;

  public Standard() {
    board = new ArrayList<>(BOARDSIZE * BOARDSIZE);
    wpm = new HashMap<>();
    bpm = new HashMap<>();
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
    if(map.containsValue(val)) {
      for(Piece p : map.keySet()) {
        if(map.get(p).equals(val)) {
          return p;
        }
      }
    }
    return null;
  }

  private void fill_A_Board() {
    int row = 0;
    int col = 0;
    for(int i = 0; i < BOARDSIZE; i++) {
      if(i % BOARDROWSIZE == 0) {
        row++;
        col = 1;
      }
      board.add(new Tile(row, col));
      col++;
    }
    fill_In_White();
    fill_In_Black();
  }

  private void fill_In_White() {
    wpm.put(new Rook(WHITE), board.get(0));
    wpm.put(new Knight(WHITE), board.get(1));
    wpm.put(new Bishop(WHITE), board.get(2));
    wpm.put(new Queen(WHITE), board.get(3));
    wpm.put(new King(WHITE), board.get(4));
    wpm.put(new Bishop(WHITE), board.get(5));
    wpm.put(new Knight(WHITE), board.get(6));
    wpm.put(new Rook(WHITE), board.get(7));

    for(int i = 0; i < BOARDROWSIZE; i++) {
      wpm.put(new Pawn(WHITE), board.get(i + BOARDROWSIZE));
    }
  }

  private void fill_In_Black() {
    bpm.put(new Rook(BLACK), board.get(BOARDROWSIZE * 7));
    bpm.put(new Knight(BLACK), board.get(1 + (BOARDROWSIZE * 7)));
    bpm.put(new Bishop(BLACK), board.get(2 + (BOARDROWSIZE * 7)));
    bpm.put(new Queen(BLACK), board.get(3 + (BOARDROWSIZE * 7)));
    bpm.put(new King(BLACK), board.get(4 + (BOARDROWSIZE * 7)));
    bpm.put(new Bishop(BLACK), board.get(5 + (BOARDROWSIZE * 7)));
    bpm.put(new Knight(BLACK), board.get(6 + (BOARDROWSIZE * 7)));
    bpm.put(new Rook(BLACK), board.get(7 + (BOARDROWSIZE * 7)));

    for(int i = 0; i < BOARDROWSIZE; i++) {
      bpm.put(new Pawn(BLACK), board.get(i + (BOARDROWSIZE * 6)));
    }
  }

  public void printBoard() {
    System.out.println(gameBoard_edge);
    for(int i = BOARDSIZE - 8; i >= 0; i -= 8) {
      System.out.print((i / BOARDROWSIZE) + 1 + " ");
      for(int j = 0; j < 8; j++) {
        Tile cur = board.get(i + j);
        Piece toShow;

        if((toShow = getKfV(wpm, cur)) == null) {
          if((toShow = getKfV(bpm, cur)) == null) {
            toShow = new Piece();
          }
        }
        System.out.print("| " + toShow + " ");
      }
      System.out.println("|");
    }
    System.out.println(gameBoard_edge);

    for(int i = 1; i <= BOARDROWSIZE; i++) {
      System.out.print("     " + Tile.Columns.getByNum(i));
    }
    System.out.println();
  }

  public List<Tile> getBoard() {
    return new ArrayList<>(board);
  }

  public Tile getTile(String tile) {
    if(tile.length() != 2) {
      throw new IllegalArgumentException(errTileFormat + tile);
    }
    return new Tile(board.get(board.indexOf(
            new Tile(Integer.valueOf(tile.substring(1)), Tile.Columns.getByAlpha(tile.charAt(0)).getNumberRep()))));
  }

  public boolean movePiece(Piece toMove, Tile newTile, boolean turn)
          throws ChessBoardException {
    Map<Piece, Tile> ref;
    if(turn) {
      ref = wpm;
    } else {
      ref = bpm;
    }

    for(Piece p : ref.keySet()) {
      if(p.getClass() == toMove.getClass()) {
        Tile t = ref.get(p);
        if(p.moveSet(t).contains(newTile) && combatCases(p, t, newTile, turn)) {
          p.flipFirst();
          return ref.replace(p, t, newTile);
        }
      }
    }
    throw new ChessBoardException(errMissingPiece + toMove);
  }

  //TODO add combat cases for rest of the pieces
  private boolean combatCases(Piece p, Tile cur, Tile next, boolean turn) {
    Map<Piece, Tile> ref;
    if(turn) {
      ref = bpm;
    } else {
      ref = wpm;
    }

    if(p.getClass() == Pawn.class) {
      if(next.getRow() == cur.getRow() + 1 || next.getRow() == cur.getRow() - 1) {
        boolean ret = ref.containsValue(next);
        if(next.getCol() == cur.getCol() + 1 || next.getCol() == cur.getCol() - 1) {
          return ret;
        } else {
          return !ret;
        }
      }
      return true;
    } else if(p.getClass() == Rook.class) {
      return true;
    } else if(p.getClass() == Knight.class) {
      return true;
    } else if(p.getClass() == Bishop.class) {
      return true;
    } else if(p.getClass() == Queen.class) {
      return true;
    } else return p.getClass() == King.class;
  }
}
