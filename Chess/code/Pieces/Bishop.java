package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

  private static final char representation = 'B';

  public Bishop() {
    this(true);
  }

  public Bishop(boolean color) {
    this(color, representation);
  }

  private Bishop(boolean color, char shortHand) {
    super(color, shortHand);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    return diagonalMoves(t);
  }
}
