package Models.Pieces;

import Models.Board.ChessBoardException;
import Models.Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

  private static final char representation = 'K';

  public King() {
    this(true);
  }

  public King(boolean color) {
    this(color, representation);
  }

  private King(boolean color, char shortHand) {
    super(color, shortHand);
  }

  @Override
  public Set<Tile> moveSet(Tile t) throws ChessBoardException {
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
