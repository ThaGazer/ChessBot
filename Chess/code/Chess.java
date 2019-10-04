/*
 * Author: ThaGazer
 * File:asd
 * Date: 12/1/2018
 */

import Board.ChessBoardException;
import Board.Standard;
import Board.Tile;
import Pieces.Pawn;

import java.util.Scanner;

//TODO comment everything

public class Chess {

  private static final String msgMenu = "Available Commands" +
      "\n-help\n-next\n-quit\n-movePiece\n" +
      "\nDescription:\n" +
      "help: prints this help menu\n" +
      "quit: will stop execution of the program\n" +
      "movePiece: To move a piece follow the following style [piece][nonce][tile] \n" +
      "           *there is no need to type in 'movePiece' to move a piece\n" +
      "  where:\n" +
      "    [piece]: pawn='' Rook='R' Knight='N' Bishop='B' Queen='Q' King='K'\n" +
      "    [nonce]: if two piece can reach the same tile the nonce is '1'\n" +
      "             for lowest rank and '2' for highest rank\n" +
      "    [tile]: column='a-h' row='1-8'\n" +
      "press 'q' to return to current game";
  private static final String msgWhite = "White ";
  private static final String msgBlack = "Black ";
  private static final String msgPrevMove = "played: ";
  private static final String msgNextCommand = ":> ";
  private static final String msgQuit = "quiting...";

  private static final String errWarning = "WARNING: ";
  private static final String errSever = "SEVER: ";
  private static final String errUnReachableTile = "unreachable tile";
  private static final String errTilteFormat = "improper input format";
  private static final String errUnexpectedErr = "something really bad happened";

  private static Standard board;

  private Tile preMove;
  private boolean PlayerTurn = true; /*true=white false=black*/

  public static void main(String[] args) {
    Chess m = new Chess();
    board = new Standard();
    boolean playOn;
    Scanner scn = new Scanner(System.in);

    do {
      board.printBoard();

      //operates off of user input
      try {
        playOn = m.userOp(scn);
      } catch (ChessBoardException cbe) {
        playOn = true;
        System.err.println(errWarning + errUnReachableTile);
      } catch (IllegalArgumentException iae) {
        playOn = true;
        System.err.println(errWarning + errTilteFormat);
      } catch (Exception e) {
        playOn = false;
        System.err.println(errWarning + errUnexpectedErr);
      }

    } while (playOn);
  }

  private boolean printMenu(Scanner scn) {
    do {
      System.out.println(msgMenu);
      System.out.print(msgNextCommand);
    } while (!scn.nextLine().equals("q"));
    return true;
  }

  private boolean userOp(Scanner scn) throws ChessBoardException {
    if (preMove != null) {
      System.out.println(getTurnMsg(!getTurn()) + msgPrevMove + preMove);
    }
    System.out.print(getTurnMsg(getTurn()) + msgNextCommand);
    String line = scn.nextLine().toLowerCase();

    switch (line) {
      case "help":
      case "h":
        return printMenu(scn);
      case "quit":
      case "q":
        System.out.println(msgQuit);
        return false;
      case "next":
      case "n":
        return newGame();
      default:
        return movePiece(line);
    }
  }

  //TODO detect collision
  //TODO piece capture
  private boolean movePiece(String line) throws ChessBoardException {
    if (line.split(" ").length > 1) {
      throw new IllegalArgumentException();
    }

    boolean ret;
    Tile pieceToMove = board.getTile(line);

    switch (line.length()) {
      case 2:
        ret = board.movePiece(line);
        preMove = pieceToMove;
        break;
      case 3:
        ret = true;
        break;
      case 4:
        ret = true;
        break;
      default:
        throw new ChessBoardException();
    }

    setTurn();

    return ret;
  }

  private boolean newGame() {
    board = new Standard();
    return true;
  }

  private boolean getTurn() {
    return PlayerTurn;
  }

  private String getTurnMsg(boolean turn) {
    return turn ? msgWhite : msgBlack;
  }

  private void setTurn() {
    PlayerTurn = !getTurn();
  }
}
