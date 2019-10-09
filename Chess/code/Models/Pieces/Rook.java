package Models.Pieces;

import Models.Board.ChessBoardException;
import Models.Board.Tile;

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
  public Set<Tile> moveSet(Tile t) throws ChessBoardException {
    return straightMoves(t);
  }
}
