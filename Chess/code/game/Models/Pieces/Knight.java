package game.Models.Pieces;

import game.Models.Board.BoardException;
import game.Models.Board.Tile;
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
  public Set<Tile> moveSet(Tile t) throws PieceException {
    Set<Tile> moves = new HashSet<>();

    try {
      moves.add(new Tile((t.getRow() + 2), (t.getCol() + 1)));
      moves.add(new Tile((t.getRow() + 2), (t.getCol() - 1)));
      moves.add(new Tile((t.getRow() + 1), (t.getCol() + 2)));
      moves.add(new Tile((t.getRow() - 1), (t.getCol() + 2)));
      moves.add(new Tile((t.getRow() - 2), (t.getCol() + 1)));
      moves.add(new Tile((t.getRow() - 2), (t.getCol() - 1)));
      moves.add(new Tile((t.getRow() + 1), (t.getCol() - 2)));
      moves.add(new Tile((t.getRow() - 1), (t.getCol() - 2)));
    } catch(BoardException e) {
      throw new PieceException(e.getMessage(), e);
    }

    return moves;
  }
}
