package game.UI;

import game.Models.Board.Base;
import game.Models.Board.BoardException;
import game.Models.Board.Tile;
import game.Models.Pieces.Piece;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static game.Models.Board.Base.BOARDLENGTH;

public class Visuals {

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
  private static final String msgNextCommand = ":> ";
  private static final String msgPrevMove = " played: ";
  private static final String msgWhite = "White";
  private static final String msgBlack = "Black";
  private static final String gameBoard_edge =
      "  -------------------------------------------------";

  public Visuals(){

  }

  public static void printTitleScreen() throws InterruptedException {
    System.out.println("HI Y'ALL!\nWelcome to Chess");
    TimeUnit.SECONDS.sleep(5);
  }

  public static boolean printHelpMenu(Scanner scn) {
    do {
      System.out.println(msgMenu);
      System.out.print(msgNextCommand);
    } while(!scn.nextLine().equals("q"));
    return true;
  }

  public static void printPreviousMove(Tile preMove, boolean currTurn) {
    if(preMove != null) {
      System.out.println(getTurnMsg(preMove.getPiece().getColor()) + msgPrevMove + preMove);
    }
    System.out.print(getTurnMsg(currTurn) + msgNextCommand);
  }

  public static void printBoard(Base board) throws UIException {
    System.out.println(gameBoard_edge);
    for (int i = BOARDLENGTH*BOARDLENGTH - 8; i >= 0; i -= 8) {
      System.out.print((i / BOARDLENGTH) + 1 + " ");
      for (int j = 0; j < 8; j++) {
        Piece piece;
        try {
          if((piece = board.getTile(i + j).getPiece()) == null) {
            System.out.print("| " + " -  ");
          } else {
            System.out.print("| " + piece.toString() + " ");
          }
        } catch(BoardException e) {
          throw new UIException(e.getMessage(), e);
        }
      }
      System.out.println("|");
    }
    System.out.println(gameBoard_edge);

    for (int i = 1; i <= BOARDLENGTH; i++) {
      System.out.print("     " + Tile.getColumn(i));
    }
    System.out.println();
  }

  private static String getTurnMsg(boolean color) {
    return color ? msgWhite : msgBlack;
  }
}
