package game.UI;

import game.ChessException;

public class UIException extends ChessException {
  public UIException(String msg) {
    super(msg);
  }

  public UIException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
