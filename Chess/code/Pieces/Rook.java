package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

  private static final char representation = 'R';

  public Rook() {
    this(true, 0);
  }

  public Rook(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private Rook(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    return straightMoves(t);
  }
}
