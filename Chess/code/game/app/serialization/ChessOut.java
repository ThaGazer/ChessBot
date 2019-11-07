package game.app.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class ChessOut {

  private OutputStream out;

  public ChessOut(OutputStream outSource) {
    setOutputSource(outSource);
  }

  private void setOutputSource(OutputStream outSource) {
    out = Objects.requireNonNull(outSource);
  }


  public void writeLine(String line) throws ChessSerializationException {
    writeLine(line, StandardCharsets.US_ASCII);
  }

  public void writeLine(String line, Charset encoding) throws ChessSerializationException {
    write(line.getBytes(encoding));
  }

  public void write(byte[] bytes, int offset, int length) throws ChessSerializationException {
    write(Arrays.copyOfRange(bytes, offset, length));
  }

  public void write(byte[] bytes) throws ChessSerializationException {
    for(byte b : bytes) {
      write(b);
    }
  }

  public void write(byte b) throws ChessSerializationException {
    try {
      out.write(b);
    } catch(IOException e) {
      throw new ChessSerializationException(e.getMessage(), e);
    }
  }
}
