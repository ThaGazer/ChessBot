package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

  private static final char representation = 'B';

  public Bishop() {
    this(true, 0);
  }

  public Bishop(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private Bishop(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    return diagonalMoves(t);
  }
}
