package game.app.serialization;

import game.ChessException;

public class ChessSerializationException extends ChessException {

  public ChessSerializationException(String msg) {
    super(msg);
  }

  public ChessSerializationException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
