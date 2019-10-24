package game.Models.Pieces;

import game.ChessException;

public class PieceException extends ChessException {
  public PieceException(String msg) {
    super(msg);
  }

  public PieceException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
