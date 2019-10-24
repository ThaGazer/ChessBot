package game.Models.Board;

import game.ChessException;

public class BoardException extends ChessException {
  public BoardException(String msg) {
    super(msg);
  }

  public BoardException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
