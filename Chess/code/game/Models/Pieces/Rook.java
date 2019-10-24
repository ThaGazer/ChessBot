package game.Models.Pieces;

import game.Models.Board.Tile;
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
  public Set<Tile> moveSet(Tile t) throws PieceException {
    return straightMoves(t);
  }
}
