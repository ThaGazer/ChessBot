/*
 * Author: ThaGazer
 * File:Pieces/null.java
 * Date: 12/1/2018
 */
package Pieces;

public enum Pieces {
  PAWN(1), KNIGHT(2), BISHOP(3), ROOK(4), QUEEN(5), KING(6);

  public static final String errPieceRep = "unrecognized piece rep";

  int numRep;

  Pieces(int x) {
    numRep = x;
  }

  public static Piece getByNumRep(int x) {
    switch(x) {
      case 1:
        return new Pawn();
      case 2:
        return new Knight();
      case 3:
        return new Bishop();
      case 4:
        return new Rook();
      case 5:
        return new Queen();
      case 6:
        return new Knight();
      default:
        throw new IllegalArgumentException(errPieceRep);
    }
  }
}
