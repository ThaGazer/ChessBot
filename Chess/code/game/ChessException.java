package game;

public class ChessException extends Exception {

  public ChessException(String msg) {
    this(msg, null);
  }

  public ChessException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
