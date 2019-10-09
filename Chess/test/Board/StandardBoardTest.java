/*
 * Author: ThaGazer
 * File: Board.StandardBoardTest.java
 * Date: 12/1/2018
 */
package Board;

import Models.Board.*;
import Models.Pieces.Pawn;
import Models.Pieces.Piece;
import Models.Pieces.Pieces;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardBoardTest extends BaseBoardTest {

  StandardBoardTest() throws ChessBoardException {
    super();
  }

  @Override
  void createBoard() throws ChessBoardException {
    board = new Standard();
  }

  @Test
  void testPieceFill() {
    Pieces[] expectedPiecesOrder = Pieces.piecePlacementOrder();
    List<Tile> boardArr = board.getBoard();
    for(int i = 0 ; i < Base.BOARDLENGTH; i++) {
      Piece wp = boardArr.get(i).getPiece();
      Piece bp = boardArr.get(i + (Base.BOARDLENGTH*7)).getPiece();

      Piece wPawn = boardArr.get(i + Base.BOARDLENGTH).getPiece();
      Piece bPawn = boardArr.get(i + (Base.BOARDLENGTH*6)).getPiece();

      int finalI = i;
      assertAll(() -> {
        assertEquals(wp, Pieces.getByEnum(expectedPiecesOrder[finalI], Base.WHITE));
        assertEquals(bp, Pieces.getByEnum(expectedPiecesOrder[finalI], Base.BLACK));
        assertEquals(wPawn, new Pawn(Base.WHITE));
        assertEquals(bPawn, new Pawn(Base.BLACK));
      });
    }
  }
}