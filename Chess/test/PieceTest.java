/*
 * Author: Justin Ritter
 * File: PieceTest.java
 * Date: 9/29/2018
 */

import Pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

  @Test
  void test_equals() {
    assertAll(() -> {
      assertNotEquals(new Pawn(), new Pawn());
      assertNotEquals(new Rook(), new Rook());
      assertNotEquals(new Knight(), new Knight());
      assertNotEquals(new Bishop(), new Bishop());
    });

    assertAll(() -> {
      assertEquals(new Piece(), new Piece());
      assertEquals(new Queen(), new Queen());
      assertEquals(new King(), new King());
      Rook r = new Rook();
      assertEquals(r, new Rook(r));
    });
  }

  //TODO test moveset somehow
  //TODO test constructors for each Piece class
}