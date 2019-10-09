package Models.Board;

import Models.Pieces.*;
import java.util.ArrayList;
import java.util.List;

public class Standard extends Base {

  private static final String errTileFormat = "TILE FORMATTING: ";
  private static final String errUnknownTile = "unrecognized tile reference";
  private static final String errMissingPiece = "could not find piece referenced: ";

  private static final String gameBoard_edge =
      "  -------------------------------------------------";

  public Standard() {
    super();
  }

  protected void fill_In_Pieces() {
    for(int i = 0; i < BOARDLENGTH; i++) {
      board.get(((BOARDLENGTH * 7)) + i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], BLACK));
      board.get((BOARDLENGTH * 6) + i) .setPiece(new Pawn(BLACK));

      board.get(BOARDLENGTH + i).setPiece(new Pawn(WHITE));
      board.get(i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], WHITE));
    }
  }

  public void printBoard() {
    System.out.println(gameBoard_edge);
    for (int i = BOARDSIZE - 8; i >= 0; i -= 8) {
      System.out.print((i / BOARDLENGTH) + 1 + " ");
      for (int j = 0; j < 8; j++) {
        Piece piece;
        if((piece = board.get(i+j).getPiece()) == null) {
          System.out.print("| " + " -  ");
        } else {
          System.out.print("| " + piece.toString() + " ");
        }
      }
      System.out.println("|");
    }
    System.out.println(gameBoard_edge);

    for (int i = 1; i <= BOARDLENGTH; i++) {
      System.out.print("     " + Tile.getColumn(i));
    }
    System.out.println();
  }

  public List<Tile> getBoard() {
    return new ArrayList<>(board);
  }

  public Tile getTile(String tile) throws ChessBoardException {
    if(tile.length() != 2) {
      throw new ChessBoardException(errTileFormat + errUnknownTile);
    }

    return board.get(Tile.getColumn(tile.charAt(0)).getNumberRep() + ((Character.getNumericValue(tile.charAt(1))-1) * BOARDLENGTH));
  }

  //TODO wip
  public boolean movePiece(Piece pieceToMove, Tile futureTile, boolean turn)
      throws ChessBoardException {
    return true;
  }

  //TODO add combat cases for rest of the pieces
  private boolean combatCases(Piece p, Tile cur, Tile next, boolean turn) {
    return true;
  }
}
