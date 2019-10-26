package game.app;

import game.ChessException;

public class ChessAppException extends ChessException {

  public ChessAppException(String msg) {
    super(msg);
  }

  public ChessAppException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
