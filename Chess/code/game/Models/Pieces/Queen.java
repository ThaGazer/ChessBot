package game.Models.Pieces;

import game.ChessException;
import game.Models.Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

  private static final char representation = 'Q';

  public Queen() {
    this(true);
  }

  public Queen(boolean color) {
    this(color, representation);
  }

  private Queen(boolean color, char shortHand) {
    super(color, shortHand);
  }

  @Override
  public Set<Tile> moveSet(Tile t) throws ChessException {
     Set<Tile> moves = new HashSet<>();

     moves.addAll(straightMoves(t));
     moves.addAll(diagonalMoves(t));

     return moves;
  }
}