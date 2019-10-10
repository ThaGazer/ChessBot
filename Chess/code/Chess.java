/*
 * Author: ThaGazer
 * File:asd
 * Date: 12/1/2018
 */

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

import Models.Board.Base;
import Models.Board.ChessBoardException;
import Models.Board.Standard;
import Models.Board.Tile;
import UI.UserInput;
import UI.Visuals;

//TODO comment everything

public class Chess implements Closeable {


  private static final String msgQuit = "quiting...";

  private static final String errWarning = "WARNING: ";
  private static final String errSever = "SEVER: ";
  private static final String errUnexpectedErr = "something really bad happened";

  private Base board;
  private Scanner scn;
  private Tile preMove;
  private boolean PlayerTurn = true; /*true=white false=black*/

  public static void main(String[] args) {
    try(Chess m = new Chess(new Standard())) {
      m.play();
    } catch(ChessBoardException | IOException e) {
      e.printStackTrace();
    }
  }

  private Chess(Base newBoard) {
    scn = new Scanner(System.in);
    board = newBoard;
  }

  private void play() {
    try {
      board = new Standard();
      boolean playOn;

      do {
        //TODO print board

        //operates off of user input
        try {
          playOn = userOp(scn);
        } catch(ChessBoardException | IllegalArgumentException cbe) {
          playOn = true;
          System.err.println(errWarning + cbe.getMessage());
        } catch(Exception e) {
          playOn = false;
          System.err.println(errSever + errUnexpectedErr + e.getMessage());
        }
      } while(playOn);
    } catch(Exception e) {
      System.err.println(errSever + e.getMessage());
    }
  }

  private boolean userOp(UserInput.COMMANDS command) {
    switch(command) {
      case HELP:
      case NEXT:
      case QUIT:
      case MOVE:
    }
    return true;
  }

  private boolean userOp(Scanner scn) throws ChessBoardException {

    String line = scn.nextLine().toLowerCase();

    switch(line) {
      case "help":
      case "h":
        Visuals.printHelpMenu(scn);
      case "quit":
      case "q":
        System.out.println(msgQuit);
        return false;
      case "next":
      case "n":
        return newGame();
      default:
        movePiece(line);
        return true;
    }
  }

  //TODO detect collision
  //TODO piece capture
  private void movePiece(String line) throws ChessBoardException {
    if(line.split(" ").length > 1) {
      throw new IllegalArgumentException();
    }

    setTurn();
  }

  private boolean newGame() throws ChessBoardException {
    board = new Standard();
    return true;
  }

  private boolean getTurn() {
    return PlayerTurn;
  }

  private void setTurn() {
    PlayerTurn = !getTurn();
  }

  @Override
  public void close() throws IOException {
    scn.close();
  }
}
