package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

  private static int pawnNonce = 0;

  public Pawn() {
    nonce = ++pawnNonce;
    setShorthand("p");
  }

  public Pawn(boolean whiteBlack) {
    this();
    setColor(whiteBlack);
  }

  public Pawn(Pawn p) {
    super(p);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    Set<Tile> moves = new HashSet<>();

    if(WB) {
      if(isFirst()) {
        moves.add(new Tile(t.getRow() + 2, t.getCol()));
      }

      //upper bounds check
      if(t.getRow() < 8) {
        //in front
        moves.add(new Tile(t.getRow() + 1, t.getCol()));

        //right diagonal
        if(t.getCol() < 8) {
          moves.add(new Tile(t.getRow() + 1, t.getCol() + 1));
        }

        //left diagonal
        if(t.getCol() > 1) {
          moves.add(new Tile(t.getRow() + 1, t.getCol() - 1));
        }
      }
    } else {
      if(isFirst()) {
        moves.add(new Tile(t.getRow() - 2, t.getCol()));
      }

      //lower bound check
      if(t.getRow() > 1) {
        //in front
        moves.add(new Tile(t.getRow() - 1, t.getCol()));

        //right diagonal
        if(t.getCol() < 8) {
          moves.add(new Tile(t.getRow() - 1, t.getCol() + 1));
        }

        //left diagonal
        if(t.getCol() > 1) {
          moves.add(new Tile(t.getRow() - 1, t.getCol() - 1));
        }
      }
    }

    return moves;
  }
}
