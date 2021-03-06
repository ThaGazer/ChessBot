package Board;

import Models.Board.Base;
import Models.Board.ChessBoardException;
import Models.Board.Tile;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseBoardTest {

  Base board;

  BaseBoardTest() throws ChessBoardException {
    createBoard();
  }

  @BeforeAll
  abstract void createBoard() throws ChessBoardException;

  @Test
  void testGetBoard() {
    assertNotSame(board.getBoard(), board.getBoard());
  }

  @Test
  void testBoardFill() throws ChessBoardException {
    List<Tile> boardArr = board.getBoard();

    for(int i = 0, r = 0, c = 0; i < board.getBoard().size(); i++, c++) {
      if(i % Base.BOARDLENGTH == 0) {
        r++;
        c = 1;
      }
      assertEquals(boardArr.get(i), new Tile(r, c));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"a1", "h8"})
  void testGetTile(String tile) throws ChessBoardException {
    assertEquals(board.getTile(tile), new Tile(tile));
  }
}
