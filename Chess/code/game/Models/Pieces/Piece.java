package game.Models.Pieces;

import game.ChessException;
import game.Models.Board.Tile;

import java.util.HashSet;
import java.util.Set;

//TODO input checks
public abstract class Piece {

  private static final int MAXNUMMOVES = 8;

  private boolean WB;          /*true: white false: black*/
  private boolean firstMove = true;
  private char shorthand;

  /**
   * Default constructor
   */
  public Piece() {
    this(true, '-');
  }

  /**
   * Parameter Constructor
   *
   * @param color of the piece (true=white : false=black)
   * @param shorthand visual representation of the piece
   */
  public Piece(boolean color, char shorthand) {
    setColor(color);
    setShorthand(shorthand);
  }

  public boolean is(Pieces pieceEnumeration) {
    return equals(Pieces.getByEnum(pieceEnumeration, getColor()));
  }

  /**
   * Tells if this is the pieces first move
   *
   * @return first move
   */
  public boolean isFirst() {
    return firstMove;
  }

  /**
   * Sets the color of the piece
   *
   * @param color true = white false = black
   */
  private void setColor(boolean color) {
    WB = color;
  }

  /**
   * Sets the first move to be false
   */
  public void setFirst() {
    firstMove = false;
  }

  /**
   * Sets the short hand of the piece
   *
   * @param str the short hand of the piece
   */
  private void setShorthand(char str) {
    //TODO add some input checks here
    shorthand = str;
  }

  /**
   * Returns the color of the piece
   *
   * @return true = white false = black
   */
  public boolean getColor() {
    return WB;
  }

  private char colorRep() {
    return getColor() ? '+' : '-';
  }

  /**
   * Returns the shorthand of the piece
   * +p+ for White
   * -p- for Black
   *
   * @return the piece representation
   */
  public char getShorthand() {
    return shorthand;
  }

  /**
   * A set of all possible move locations for this piece
   *
   * @return Set of possible move locations
   */
  //TODO comment moveSets for each piece
  public abstract Set<Tile> moveSet(Tile t) throws ChessException;

  Set<Tile> straightMoves(Tile t) throws ChessException {
    Set<Tile> moves = new HashSet<>();

    for (int i = 1; i < MAXNUMMOVES; i++) {
      if (i != t.getRow()) {
        moves.add(new Tile(i, t.getCol()));
      }

      if (i != t.getCol()) {
        moves.add(new Tile(t.getRow(), i));
      }
    }

    return moves;
  }


  Set<Tile> diagonalMoves(Tile t) throws ChessException {
    Set<Tile> moves = new HashSet<>();

    for (int i = 1; i <= MAXNUMMOVES - t.getRow() && i <= MAXNUMMOVES - t.getCol(); i++) {
      moves.add(new Tile((t.getRow() + i), (t.getCol() + i)));
    }
    for (int i = 0; i <= MAXNUMMOVES - t.getRow() && i <= t.getCol(); i++) {
      moves.add(new Tile((t.getRow() + i), (t.getCol() - i)));
    }
    for (int i = 0; i <= t.getRow() && i <= MAXNUMMOVES - t.getCol(); i++) {
      moves.add(new Tile((t.getRow() - i), (t.getCol() + i)));
    }
    for (int i = 0; i <= t.getRow() && i <= t.getCol(); i++) {
      moves.add(new Tile((t.getRow() - i), (t.getCol() - i)));
    }

    return moves;
  }

  @Override
  public int hashCode() {
    int prime = 31;
    return prime + Boolean.hashCode(WB);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Piece p = (Piece) obj;
    return getShorthand() == p.getShorthand() &&
        getColor() == p.getColor();
  }

  @Override
  public String toString() {
    return String.valueOf(colorRep()) +
        shorthand +
        colorRep();
  }
}
