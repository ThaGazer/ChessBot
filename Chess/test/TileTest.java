import game.ChessException;
import game.Models.Board.BoardException;
import game.Models.Board.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

  private Tile t;
  private int testVar;

  @BeforeEach
  void setup() throws ChessException {
    t = new Tile(1, 1);
  }

  @Test
  void testSetters_valid() {
    assertAll(() -> {
      for (int i = 0; i < 64; i++) {
        //test row
        testVar = new Random().nextInt(7) + 1;
        t.setRow(testVar);
        assertEquals(testVar, t.getRow());

        //test column
        testVar = new Random().nextInt(7) + 1;
        t.setCol(testVar);
        assertEquals(testVar, t.getCol());

      }
    });
  }

  @Test
  void testColumns_valid() {
    assertAll(() -> {
      for (int i = 0; i < Tile.COLUMNS.values().length; i++) {
        int finalI = i;
        assertAll(() -> {
          assertEquals(Tile.getColumn(finalI + 1), Tile.COLUMNS.values()[finalI]);
          assertEquals(Tile.COLUMNS.values()[finalI].getNumberRep(), finalI + 1);
        });
      }

      for (char column = 'a'; column < ('a' + Tile.COLUMNS.values().length); column++) {
        assertEquals(Tile.getColumn(column), Tile.COLUMNS.values()[column - 'a']);
      }
    });
  }

  @Test
  void testSetters_invalid() throws InterruptedException {

    Thread lower = new Thread(() -> {
      for (int i = Integer.MIN_VALUE / 512; i < 0; i++) {
        int finalI = i;
        assertAll(() -> {
          assertThrows(BoardException.class, () -> t.setRow(finalI));
          assertThrows(BoardException.class, () -> t.setCol(finalI));
        });
      }
    });

    Thread upper = new Thread(() -> {
      for (int i = 0; i < (Integer.MAX_VALUE / 512); i++) {
        int finalI = i;
        //legal range
        if (finalI < 1 || finalI > 8) {
          assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> t.setRow(finalI));
            assertThrows(IllegalArgumentException.class, () -> t.setCol(finalI));
          });
        }
      }
    });

    lower.start();
    upper.start();

    lower.join();
    upper.join();
  }

  @Test
  void testColumns_invalid() {
    for (int i = 0; i < Character.MAX_VALUE; i++) {
      int finalI = i;
      assertAll(() -> {
        //this is the legal range
        if (finalI < 1 || finalI > 8) {
          assertThrows(IllegalArgumentException.class, () -> System.out.println(Tile.getColumn(finalI)));
        }

        //this is the legal range
        if (finalI < 97 || finalI > 105) {
          assertThrows(IllegalArgumentException.class, () -> System.out.println(Tile.getColumn((char) finalI)));
        }
      });
    }
  }

  @Test
  void testToString() {
    System.out.println(t.toString());
    assertEquals("a1", t.toString());
  }
}
