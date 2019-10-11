package Models.Board;

import Models.Pieces.*;

public class Standard extends Base {

  private static final String errMissingPiece = "could not find piece referenced: ";

  public Standard() throws ChessBoardException {
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

  //TODO wip
  public boolean movePiece(Piece pieceToMove, Tile futureTile, char pieceNonce, boolean turn)
      throws ChessBoardException {
    return true;
  }

  //TODO add combat cases for rest of the pieces
  private boolean combatCases(Piece p, Tile cur, Tile next, boolean turn) {
    return true;
  }
}
