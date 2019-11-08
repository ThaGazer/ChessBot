package game.app.serialization;

import game.Models.Board.Tile;
import game.Models.Pieces.Piece;

import java.util.Objects;

public class PNG {

  public static final String deliminator_space = " ";

  private String move;

  public PNG(Piece p, Tile t) throws ChessSerializationException {
    this(p.getShorthand() + t.toString());
  }

  public PNG(String m) throws ChessSerializationException {
    setMove(m);
  }

  public void encode(ChessOut out) throws ChessSerializationException {
    out.write(move + deliminator_space);
  }

  private void setMove(String m) throws ChessSerializationException {
    try {
      move = Objects.requireNonNull(m);
    } catch(NullPointerException e) {
      throw new ChessSerializationException(e.getMessage(), e);
    }
  }

  public String getMove() {
    return move;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }

    if(obj == null || getClass() == obj.getClass()) {
      return false;
    }

    PNG p = (PNG) obj;
    return getMove().equals(p.getMove());
  }

  @Override
  public int hashCode() {
    return move.hashCode();
  }

  @Override
  public String toString() {
    return getMove();
  }
}
