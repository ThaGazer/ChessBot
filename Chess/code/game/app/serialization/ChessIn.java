package game.app.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ChessIn {

  private InputStream in;
  private char deliminator;

  public ChessIn(InputStream inputSource) {
    this(inputSource, ' ');
  }

  public ChessIn(InputStream inputStream, char delim) {
    setInputStream(inputStream);
    setDeliminator(delim);
  }

  private void setInputStream(InputStream inputSource) {
    in = Objects.requireNonNull(inputSource);
  }

  private void setDeliminator(int delim) {
    if(delim < 0 || delim > 255) {
      throw new IllegalArgumentException();
    }
    deliminator = (char)delim;
  }

  private boolean isDeliminator(int bitIn) {
    return bitIn == deliminator;
  }

  public boolean isNull() {
    return in == null;
  }

  public int read() throws ChessSerializationException {
    try {
      int bit;
      if((bit = in.read()) == -1) {
        throw new EOFException();
      } else {
        return bit;
      }
    } catch(IOException e) {
      throw new ChessSerializationException(e.getMessage(), e);
    }
  }

  public String nextToken() throws ChessSerializationException {
    int bit;
    StringBuilder ret = new StringBuilder();

    while(!isDeliminator((bit = read()))) {
      ret.append(bit);
    }
    return ret.toString();
  }
}
