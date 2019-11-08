package game.app.serialization;

import java.util.ArrayList;
import java.util.List;

public class PNGList {

  private static final String errNullStream = "null stream";

  private List<PNG> png;

  public PNGList() {
    png = new ArrayList<>();
  }

  public PNGList(String pngIn) throws ChessSerializationException {
    this();

    for(String s : pngIn.split(" ")) {
      setMove(s);
    }
  }

  public PNGList(PNGList list) {
    this();

    png.addAll(list.getPng());
  }

  public void parse(ChessIn in) throws ChessSerializationException {

  }

  public void encode(ChessOut out) throws ChessSerializationException {
    if(out == null) {
      throw new ChessSerializationException(errNullStream);
    }
    for(PNG p : getPng()) {
      p.encode(out);
    }
  }

  private void setMove(String move) throws ChessSerializationException {
    setMove(new PNG(move));
  }

  private void setMove(PNG p) {
    png.add(p);
  }

  public List<PNG> getPng() {
    return List.copyOf(png);
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for(int i = 0; i < png.size(); i++) {
      str.append(i).append(". ").append(png.get(i));
    }
    return str.toString();
  }
}
