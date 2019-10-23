/*
 * Author: ThaGazer
 * File:Board/null.java
 * Date: 12/2/2018
 */
package Models.Board;

public class BoardException extends Exception {

  public BoardException() {
  }

  public BoardException(String msg) {
    super(msg);
  }

  public BoardException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
