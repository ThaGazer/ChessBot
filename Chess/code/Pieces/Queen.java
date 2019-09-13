package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

  private static final char representation = 'Q';

  public Queen() {
    this(true, 0);
  }

  public Queen(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private Queen(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
     Set<Tile> moves = new HashSet<>();

     moves.addAll(straightMoves(t));
     moves.addAll(diagonalMoves(t));

     return moves;
  }
}
