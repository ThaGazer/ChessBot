package Models.Board;

import Models.Pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Base {

  public static final int BOARDLENGTH = 8;
  private static final int BOARDSIZE = BOARDLENGTH * BOARDLENGTH;

  public static final boolean WHITE = true;
  public static final boolean BLACK = false;

  private static final String errNull = "null object";
  private static final String errTileFormat = "TILE FORMATTING: ";
  private static final String errUnknownTile = "unrecognized tile reference: ";
  private static final String errTileOOB = "tile reference out of board bounds: ";

  protected List<Tile> board;

  Base() throws BoardException {
    board = new ArrayList<>(BOARDSIZE);
    fill_A_Board();
    fill_In_Pieces();
  }

  private void fill_A_Board() throws BoardException {
    int row = 0;
    int col = 0;
    for (int i = 0; i < BOARDSIZE; i++) {
      if (i % BOARDLENGTH == 0) {
        row++;
        col = 1;
      }
      board.add(new Tile(row, col));
      col++;
    }
  }

  abstract void fill_In_Pieces();

  public abstract Tile movePiece(Piece pieceToMove, Tile futureTile, char pieceNonce, boolean turn)
      throws BoardException;

  public List<Tile> getBoard() {
    return List.copyOf(board);
  }

  //TODO Tests for the gets
  public Tile getTile(int tile) throws BoardException {
    if(tile < 0 || tile > BOARDSIZE) {
      throw new BoardException(errTileFormat + errTileOOB + tile);
    }

    return board.get(tile);
  }

  public Tile getTile(String tile) throws BoardException {
    if(tile == null) {
      throw new IllegalArgumentException(errTileFormat + errNull);
    }
    if(tile.length() != 2) {
      throw new BoardException(errTileFormat + errUnknownTile + tile);
    }

    return getTile(Tile.getColumn(tile.charAt(0)).getNumberRep()-1 +
        ((Character.getNumericValue(tile.charAt(1))-1) * BOARDLENGTH));
  }

  public Tile getTile(Tile tile) throws BoardException {
    return getTile(Objects.requireNonNull(tile.toString()));
  }

  //TODO maybe equals/hashcode
}
