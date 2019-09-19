package Board;

import Pieces.Piece;

public class Tile {

  private static final String errBoardBounds = "out of board bounds: ";

  private int row, col;
  private Piece pieceHolder;

  public Tile(int c, int r) {
    this(r,c, null);
  }

  public Tile(int c, int r, Piece piece) {
    setRow(r);
    setCol(c);
    setPiece(piece);
  }

  public Tile(Tile t) {
    this(t.getRow(), t.getCol());
  }

  public void setRow(int r) {
    if (r >= 1 && r <= 8) {
      row = r;
    } else {
      throw new IllegalArgumentException(errBoardBounds + r);
    }
  }

  public void setCol(int c) {
    if (c >= 1 && c <= 8) {
      col = c;
    } else {
      throw new IllegalArgumentException(errBoardBounds + c);
    }
  }

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
    a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8);

    private int numberRep;

    Columns(int num) {
      numberRep = num;
    }

    public static Columns getByNum(int i) {
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

    public static Columns getByAlpha(char x) {
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
