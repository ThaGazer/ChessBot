package game.app.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CSIn {

  private InputStream in;

  public CSIn(InputStream inputSource) {
    setInputStream(inputSource);
  }

  private void setInputStream(InputStream inputSource) {
    in = Objects.requireNonNull(inputSource);
  }

  public int read() throws ChessSerializationException {
    try {
      return in.read();
    } catch(IOException e) {
      throw new ChessSerializationException(e.getMessage(), e);
    }
  }
}
