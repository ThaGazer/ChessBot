package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

  private static final char representation = 'K';

  public King() {
    this(true, 0);
  }

  public King(boolean color, int identifier) {
    this(color, representation, identifier);
  }

  private King(boolean color, char shortHand, int identifier) {
    super(color, shortHand, identifier);
  }

  @Override
  public Set<Tile> moveSet(Tile t) {
    Set<Tile> moves = new HashSet<>();

    moves.add(new Tile((t.getRow() + 1), t.getCol()));
    moves.add(new Tile((t.getRow() + 1), (t.getCol() + 1)));
    moves.add(new Tile(t.getRow(), (t.getCol() + 1)));
    moves.add(new Tile((t.getRow() - 1), (t.getCol() + 1)));
    moves.add(new Tile((t.getRow() - 1), t.getCol()));
    moves.add(new Tile((t.getRow() - 1), (t.getCol() - 1)));
    moves.add(new Tile(t.getRow(), (t.getCol() - 1)));
    moves.add(new Tile((t.getRow() + 1), (t.getCol() - 1)));

    return moves;
  }
}
