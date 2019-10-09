/*
 * Author: ThaGazer
 * File:Board/null.java
 * Date: 12/2/2018
 */
package Models.Board;

public class ChessBoardException extends Exception {

  public ChessBoardException() {
  }

  public ChessBoardException(String msg) {
    super(msg);
  }

  public ChessBoardException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
