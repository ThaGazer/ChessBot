package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

  private static final char representation = 'N';

  /**
   * Default constructor
   */
  public Knight() {
    this(true, 0);
  }

  public Knight(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private Knight(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    Set<Tile> moves = new HashSet<>();
    moves.add(new Tile((t.getRow() + 2), (t.getCol() + 1)));
    moves.add(new Tile((t.getRow() + 2), (t.getCol() - 1)));
    moves.add(new Tile((t.getRow() + 1), (t.getCol() + 2)));
    moves.add(new Tile((t.getRow() - 1), (t.getCol() + 2)));
    moves.add(new Tile((t.getRow() - 2), (t.getCol() + 1)));
    moves.add(new Tile((t.getRow() - 2), (t.getCol() - 1)));
    moves.add(new Tile((t.getRow() + 1), (t.getCol() - 2)));
    moves.add(new Tile((t.getRow() - 1), (t.getCol() - 2)));
    return moves;
  }
}
