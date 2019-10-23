package Models.Board;

import Models.Pieces.Piece;

public class Tile {

  private static final String errBoardBounds = "out of board bounds: ";

  private int row, col;
  private Piece pieceHolder;

  public Tile(int r, int c) throws BoardException {
    this(r,c, null);
  }

  public Tile(String tile) throws BoardException {
    this(Character.getNumericValue(tile.charAt(1)), COLUMNS.getByAlpha(tile.charAt(0)).getNumberRep());
  }

  public Tile(int r, int c, Piece piece) throws BoardException {
    setRow(r);
    setCol(c);
    setPiece(piece);
  }

  public Tile(Tile t) throws BoardException {
    this(t.getRow(), t.getCol(), t.getPiece());
  }

  public static COLUMNS getColumn(char x) throws IllegalArgumentException {
    return COLUMNS.getByAlpha(x);
  }

  public static COLUMNS getColumn(int x) throws IllegalArgumentException {
    return COLUMNS.getByNum(x);
  }

  public void setRow(int r) throws BoardException {
    if (r >= 1 && r <= 8) {
      row = r;
    } else {
      throw new BoardException(errBoardBounds + r);
    }
  }

  public void setCol(int c) throws BoardException {
    if (c >= 1 && c <= 8) {
      col = c;
    } else {
      throw new BoardException(errBoardBounds + c);
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

  public void clearPiece() {
    pieceHolder = null;
  }

  public boolean holdsPiece() {
    return getPiece() != null;
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
    return COLUMNS.getByNum(getCol()).toString() + getRow();
  }

  public enum COLUMNS {
    A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7);

    private int numberRep;

    COLUMNS(int num) {
      numberRep = num;
    }

    private static COLUMNS getByNum(int i) {
      switch (i) {
        case 1:
          return A;
        case 2:
          return B;
        case 3:
          return C;
        case 4:
          return D;
        case 5:
          return E;
        case 6:
          return F;
        case 7:
          return G;
        case 8:
          return H;
        default:
          throw new IllegalArgumentException(errBoardBounds);
      }
    }

    private static COLUMNS getByAlpha(char x) {
      switch (x) {
        case 'a':
          return A;
        case 'b':
          return B;
        case 'c':
          return C;
        case 'd':
          return D;
        case 'e':
          return E;
        case 'f':
          return F;
        case 'g':
          return G;
        case 'h':
          return H;
        default:
          throw new IllegalArgumentException(errBoardBounds);
      }
    }

    public int getNumberRep() {
      return numberRep+1;
    }

    public String toString() {
      switch(this) {
        case A:
          return "a";
        case B:
          return "b";
        case C:
          return "c";
        case D:
          return "d";
        case E:
          return "e";
        case F:
          return "f";
        case G:
          return "g";
        case H:
          return "h";
        default:
          return "";
      }
    }
  }
}
