package Models.Pieces;

import Models.Board.ChessBoardException;
import Models.Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

  private static final char representation = 'N';

  /**
   * Default constructor
   */
  public Knight() {
    this(true);
  }

  public Knight(boolean color) {
    this(color, representation);
  }

  private Knight(boolean color, char shortHand) {
    super(color, shortHand);
  }

  @Override
  public Set<Tile> moveSet(Tile t) throws ChessBoardException {
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
