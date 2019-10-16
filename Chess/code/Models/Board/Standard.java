package Models.Board;

import Models.Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Standard extends Base {

  private int numWhitePieces;
  private int numBlackPieces;

  public Standard() throws ChessBoardException {
    super();
    numWhitePieces = numBlackPieces = 16;
  }

  protected void fill_In_Pieces() {
    for(int i = 0; i < BOARDLENGTH; i++) {
      board.get(((BOARDLENGTH * 7)) + i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], BLACK));
      board.get((BOARDLENGTH * 6) + i) .setPiece(new Pawn(BLACK));

      board.get(BOARDLENGTH + i).setPiece(new Pawn(WHITE));
      board.get(i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], WHITE));
    }
  }

  public int getNumWhitePieces() {
    return numWhitePieces;
  }

  public int getNumBlackPieces() {
    return numBlackPieces;
  }

  //TODO wip
  public boolean movePiece(Piece pieceToMove, Tile futureTile, char pieceNonce, boolean turn)
      throws ChessBoardException {

    return true;
  }


}
