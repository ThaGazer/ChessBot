package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

  private static final char representation = 'R';

  public Rook() {
    this(true);
  }

  public Rook(boolean color) {
    this(color, representation);
  }

  private Rook(boolean color, char shortHand) {
    super(color, shortHand);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    return straightMoves(t);
  }
}
