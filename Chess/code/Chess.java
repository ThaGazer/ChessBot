/*
 * Author: ThaGazer
 * File:asd
 * Date: 12/1/2018
 */

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import Models.Board.*;
import UI.CommandInput;
import UI.MoveInput;
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
  private boolean playerTurn; /*true=white false=black*/

  public static void main(String[] args) {
    try(Chess m = new Chess()) {
      m.intro();

      m.play();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  private Chess() {
    scn = new Scanner(System.in);
    playerTurn = true;
  }

  private void intro() {
    try {
      Visuals.printTitleScreen();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    try {
      selectBoard();
    } catch(BoardException e) {
      e.printStackTrace();
    }
  }

  private void play() {
    try {
      boolean playOn;
      do {
        Visuals.printBoard(board);

        Visuals.printPreviousMove(preMove, getTurn());
        //operates off of user input
        try {
          playOn = userOp(CommandInput.parse(scn.nextLine()));
        } catch(BoardException | IllegalArgumentException cbe) {
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

  //TODO take user input for board selection
  private void selectBoard() throws BoardException {
    board = new Standard();
  }

  private boolean userOp(CommandInput command) throws BoardException {
    switch(command.getCommand()) {
      case HELP:
        return Visuals.printHelpMenu(scn);
      case NEXT:
        return newGame();
      case MOVE:
        return movePiece(MoveInput.parse(command.getMove(), getTurn()));
      case QUIT:
        System.out.println(msgQuit);
        return false;
      default:
        throw new BoardException(errUnexpectedErr);
    }
  }

  //TODO detect collision
  //TODO piece capture
  private boolean movePiece(MoveInput userMove) throws BoardException {
    preMove = board.movePiece(userMove.getPiece(), userMove.getTile(),
        userMove.getNonce(), getTurn());
    setTurn();
    return true;
  }

  private boolean newGame() throws BoardException {
    board = new Standard();
    return true;
  }

  private boolean getTurn() {
    return playerTurn;
  }

  private void setTurn() {
    playerTurn = !getTurn();
  }

  @Override
  public void close() throws IOException {
    scn.close();
  }
}
