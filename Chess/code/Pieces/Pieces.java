/*
 * Author: ThaGazer
 * File:Pieces/null.java
 * Date: 12/1/2018
 */
package Pieces;

import Board.ChessBoardException;

public enum Pieces {
  PAWN(1), KNIGHT(2), BISHOP(3), ROOK(4), QUEEN(5), KING(6);

  private static final String errPieceRep = "unrecognized piece rep";

  int numRep;

  Pieces(int x) {
    numRep = x;
  }

  public static Piece getByEnum(Pieces x, boolean color) {
    switch (x) {
      case PAWN:
        return new Pawn(color);
      case KNIGHT:
        return new Knight(color);
      case BISHOP:
        return new Bishop(color);
      case ROOK:
        return new Rook(color);
      case QUEEN:
        return new Queen(color);
      case KING:
        return new King(color);
      default:
        throw new IllegalArgumentException(errPieceRep);
    }
  }

  public static Piece getByChar(String x, boolean color) {
    Pieces piece;
    if (x.length() == 2) {
      piece = PAWN;
    } else {
      switch (x.toLowerCase().charAt(0)) {
        case 'r':
          piece = ROOK;
          break;
        case 'n':
          piece = KNIGHT;
          break;
        case 'b':
          piece = BISHOP;
          break;
        case 'q':
          piece = QUEEN;
          break;
        case 'k':
          piece = KING;
          break;
        default:
          throw new IllegalArgumentException(errPieceRep);
      }
    }

    return getByEnum(piece, color);
  }

  public static Pieces[] piecePlacementOrder() {
    return new Pieces[]{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
  }
}
