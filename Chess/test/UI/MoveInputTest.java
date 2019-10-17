package UI;

import Models.Board.ChessBoardException;
import Models.Board.Tile;
import Models.Pieces.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MoveInputTest {

  @ParameterizedTest
  @MethodSource("userTestInput")
  void testParse(String move, Piece testPiece, char testNonce, Tile testTile, boolean testColor) throws ChessBoardException {
    MoveInput testInput = MoveInput.parse(move, testColor);

    assertAll(() -> {
      assertEquals(testInput.getPiece(), testPiece);
      assertEquals(testInput.getNonce(), testNonce);
      assertEquals(testInput.getTile(), testTile);
      assertEquals(testInput.getPiece().getColor(), testColor);
    });
  }

  static Stream<Arguments> userTestInput() throws ChessBoardException {
    return Stream.of(
        arguments("pa3", new Pawn(true), ' ', new Tile("a3"), true),
        arguments("Bh8", new Bishop(false), ' ', new Tile("h8"), false),
        arguments("Qxe6", new Queen(false), ' ', new Tile("e6"), false),
        arguments("Ndxf3", new Knight(true), 'd', new Tile("f3"), true),
        arguments("Rad6", new Rook(true), 'a', new Tile("d6"), true));
  }
}
