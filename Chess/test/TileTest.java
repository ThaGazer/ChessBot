import Models.Board.ChessBoardException;
import Models.Board.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

  private Tile t;
  private int testVar;

  @BeforeEach
  void setup() throws ChessBoardException {
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
      for (int i = 0; i < Tile.Columns.values().length; i++) {
        assertEquals(Tile.getColumn(i + 1), Tile.Columns.values()[i]);
        assertEquals(Tile.Columns.values()[i].getNumberRep(), i + 1);
      }

      for (char a = 'a'; a < Tile.Columns.values().length + 'a'; a++) {
        assertEquals(Tile.getColumn(a), Tile.Columns.values()[a - 'a']);
      }
    });
  }

  @Test
  void testSetters_invalid() throws InterruptedException {

    Thread lower = new Thread(() -> {
      for (int i = Integer.MIN_VALUE / 512; i < 0; i++) {
        int finalI = i;
        assertAll(() -> {
          assertThrows(IllegalArgumentException.class, () -> t.setRow(finalI));
          assertThrows(IllegalArgumentException.class, () -> t.setCol(finalI));
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
