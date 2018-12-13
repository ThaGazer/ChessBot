package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;


public class Piece {

  private static final String errPiece = "unexpected piece";

  protected static final int MAXNUMMOVES = 8;

  protected int nonce;
  protected boolean firstMove;
  protected boolean WB;          /*true: white false: black*/
  protected String shorthand;

  /**
   * Default constructor
   */
  public Piece() {
    nonce = 0;
    setColor(true);
    setFirst(true);
    setShorthand("-");
  }

  public Piece(Piece p) {
    nonce = p.nonce;
    setColor(p.getColor());
    setShorthand(p.getShorthand());
    setFirst(isFirst());
  }

  /**
   * Gets a Piece based off its char representation
   *
   * @param piece the char representation
   * @return the Piece of that representation
   */
  public static Piece getByChar(char piece) {
    switch(piece) {
      case 'p':
        return new Pawn();
      case 'R':
        return new Rook();
      case 'N':
        return new Knight();
      case 'B':
        return new Bishop();
      case 'Q':
        return new Queen();
      case 'K':
        return new King();
      default:
        throw new IllegalArgumentException(errPiece);
    }
  }

  /**
   * Sets the color of the piece
   *
   * @param whiteBlack true = white false = black
   */
  public void setColor(boolean whiteBlack) {
    WB = whiteBlack;
  }

  /**
   * Sets the first move to be false
   */
  public void setFirst(boolean firstMove) {
    this.firstMove = firstMove;
  }

  /**
   * Sets the short hand of the piece
   *
   * @param str the short hand of the piece
   */
  public void setShorthand(String str) {
    shorthand = str;
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
   * Returns the color of the piece
   *
   * @return true = white false = black
   */
  public boolean getColor() {
    return WB;
  }

  /**
   * Returns the shorthand of the piece
   * +p+ for White
   * -p- for Black
   *
   * @return the piece representation
   */
  public String getShorthand() {
    char colorRep = (WB ? '+' : '-');
    return colorRep + shorthand + colorRep;
  }

  /**
   * Will flip the first move flag
   */
  public void flipFirst() {
    if(firstMove) {
      firstMove = false;
    }
  }

  /**
   * A set of all possible move locations for this piece
   *
   * @return Set of possible move locations
   */
  //TODO comment moveSets for each piece
  public Set<Tile> moveSet(Tile t) {
    return new HashSet<>();
  }

  @Override
  public int hashCode() {
    int prime = 31;
    int sum = prime + Boolean.hashCode(WB);
    sum += prime * sum + nonce;
    return sum;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Piece p = (Piece) obj;
    return getShorthand().equals(p.getShorthand()) &&
            getColor() == p.getColor() &&
            nonce == p.nonce;
  }

  @Override
  public String toString() {
    return getShorthand();
  }
}
