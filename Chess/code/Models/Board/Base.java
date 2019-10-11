package Models.Board;

import Models.Pieces.Piece;
import java.util.ArrayList;
import java.util.List;

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

  Base() throws ChessBoardException {
    board = new ArrayList<>(BOARDSIZE);
    fill_A_Board();
    fill_In_Pieces();
  }

  private void fill_A_Board() throws ChessBoardException {
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

  abstract boolean movePiece(Piece pieceToMove, Tile futureTile, boolean turn)
      throws ChessBoardException;

  public List<Tile> getBoard() {
    return List.copyOf(board);
  }

  public Tile getTile(String tile) throws ChessBoardException {
    if(tile == null) {
      throw new IllegalArgumentException(errTileFormat + errNull);
    }
    if(tile.length() != 2) {
      throw new ChessBoardException(errTileFormat + errUnknownTile + tile);
    }

    return board.get(Tile.getColumn(tile.charAt(0)).getNumberRep() +
        ((Character.getNumericValue(tile.charAt(1))-1) * BOARDLENGTH));
  }
  
  public Tile getTile(int tile) throws ChessBoardException {
    if(tile < 0 || tile > BOARDSIZE) {
      throw new ChessBoardException(errTileFormat + errTileOOB + tile);
    }
    return board.get(tile);
  }

  //TODO maybe equals/hashcode
}
