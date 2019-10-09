package Models.Board;

import Models.Pieces.Piece;

public class Tile {

  private static final String errBoardBounds = "out of board bounds: ";

  private int row, col;
  private Piece pieceHolder;

  public Tile(int c, int r) throws ChessBoardException {
    this(r,c, null);
  }

  public Tile(String tile) throws ChessBoardException {
    this(tile.charAt(0), tile.charAt(1));
  }

  public Tile(int c, int r, Piece piece) throws ChessBoardException {
    setRow(r);
    setCol(c);
    setPiece(piece);
  }

  public Tile(Tile t) throws ChessBoardException {
    this(t.getRow(), t.getCol(), t.getPiece());
  }

  public static Columns getColumn(char x) throws IllegalArgumentException {
    return Columns.getByAlpha(x);
  }

  public static Columns getColumn(int x) throws IllegalArgumentException {
    return Columns.getByNum(x);
  }

  public void setRow(int r) throws ChessBoardException {
    if (r >= 1 && r <= 8) {
      row = r;
    } else {
      throw new ChessBoardException(errBoardBounds + r);
    }
  }

  public void setCol(int c) throws ChessBoardException {
    if (c >= 1 && c <= 8) {
      col = c;
    } else {
      throw new ChessBoardException(errBoardBounds + c);
    }
  }

  //TODO maybe some kind of input checks?
  public void setPiece(Piece piece) {
    pieceHolder = piece;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public Piece getPiece() {
    return pieceHolder;
  }

  @Override
  public int hashCode() {
    int prime = 31;
    int sum = 1;
    sum += prime * sum + Integer.hashCode(getRow());
    sum += prime * sum + Integer.hashCode(getCol());
    return sum;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Tile t = (Tile) obj;
    return getRow() == t.getRow() && getCol() == t.getCol();
  }

  @Override
  public String toString() {
    return Columns.getByNum(getCol()).toString() + getRow();
  }

  public enum Columns {
    a(0), b(1), c(2), d(3), e(4), f(5), g(6), h(7);

    private int numberRep;

    Columns(int num) {
      numberRep = num;
    }

    private static Columns getByNum(int i) {
      switch (i) {
        case 1:
          return a;
        case 2:
          return b;
        case 3:
          return c;
        case 4:
          return d;
        case 5:
          return e;
        case 6:
          return f;
        case 7:
          return g;
        case 8:
          return h;
        default:
          throw new IllegalArgumentException(errBoardBounds);
      }
    }

    private static Columns getByAlpha(char x) {
      switch (x) {
        case 'a':
          return a;
        case 'b':
          return b;
        case 'c':
          return c;
        case 'd':
          return d;
        case 'e':
          return e;
        case 'f':
          return f;
        case 'g':
          return g;
        case 'h':
          return h;
        default:
          throw new IllegalArgumentException(errBoardBounds);
      }
    }

    public int getNumberRep() {
      return numberRep;
    }
  }
}
