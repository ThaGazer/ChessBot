package game.app.serialization;

public abstract class ChessMessage {

  public static ChessMessage parse() {
    return new ChessMove();
  }
}
