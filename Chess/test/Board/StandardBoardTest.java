/*
 * Author: ThaGazer
 * File: StandardBoardTest.java
 * Date: 12/1/2018
 */

import Models.Board.Standard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardBoardTest {

  private Standard board;

  @BeforeEach
  void setup() {
    board = new Standard();
  }

  @Test
  void test_Standard_board() {
    board.printBoard();
  }

  @Test
  void test_MovePiece() {
    //TODO test movepiece
  }
}