package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

  private static final char representation = 'P';

  public Pawn() {
    this(true, 0);
  }

  public Pawn(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private Pawn(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    Set<Tile> moves = new HashSet<>();

    if (getColor()) {
      if (isFirst()) {
        moves.add(new Tile(t.getRow() + 2, t.getCol()));
      }

      //upper bounds check
      if (t.getRow() < 8) {
        //in front
        moves.add(new Tile(t.getRow() + 1, t.getCol()));

        //right diagonal
        if (t.getCol() < 8) {
          moves.add(new Tile(t.getRow() + 1, t.getCol() + 1));
        }

        //left diagonal
        if (t.getCol() > 1) {
          moves.add(new Tile(t.getRow() + 1, t.getCol() - 1));
        }
      }
    } else {
      if (isFirst()) {
        moves.add(new Tile(t.getRow() - 2, t.getCol()));
      }

      //lower bound check
      if (t.getRow() > 1) {
        //in front
        moves.add(new Tile(t.getRow() - 1, t.getCol()));

        //right diagonal
        if (t.getCol() < 8) {
          moves.add(new Tile(t.getRow() - 1, t.getCol() + 1));
        }

        //left diagonal
        if (t.getCol() > 1) {
          moves.add(new Tile(t.getRow() - 1, t.getCol() - 1));
        }
      }
    }

    return moves;
  }
}
