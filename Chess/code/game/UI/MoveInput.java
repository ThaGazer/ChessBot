package game.UI;

import game.Models.Board.BoardException;
import game.Models.Board.Tile;
import game.Models.Pieces.Piece;
import game.Models.Pieces.Pieces;

public class MoveInput {

  private static final String errMoveUnrecognized = "move input unrecognized: ";

  private Piece piece;
  private char nonce;
  private Tile tile;

  private MoveInput(Piece pieceToMove, Tile tileMoveTo) {
    this(pieceToMove, ' ', tileMoveTo);
  }

  private MoveInput(Piece pieceToMove, char pieceNonce, Tile tileMoveTo) {
    setPiece(pieceToMove);
    setNonce(pieceNonce);
    setTile(tileMoveTo);
  }

  public Piece getPiece() {
    return piece;
  }

  public char getNonce() {
    return nonce;
  }

  public Tile getTile() {
    return tile;
  }

  private void setPiece(Piece pieceToMove) {
    piece = pieceToMove;
  }

  private void setNonce(char pieceNonce) {
    nonce = pieceNonce;
  }

  private void setTile(Tile tileMoveTo) {
    tile = tileMoveTo;
  }

  //TODO should be a better way to do this
  public static MoveInput parse(String in, boolean color) throws UIException {
    if(in.isEmpty()) {
      throw new UIException(errMoveUnrecognized + in);
    }

    String[] inSplit = in.toLowerCase().split("x");

    try {
      switch(inSplit.length) {
        case 1:
          switch(inSplit[0].length()) {
            case 3:
              return new MoveInput(Pieces.getByChar(inSplit[0].charAt(0), color),
                  new Tile(inSplit[0].substring(1)));
            case 4:
              return new MoveInput(Pieces.getByChar(inSplit[0].charAt(0), color),
                  inSplit[0].charAt(1), new Tile(inSplit[0].substring(2)));
            default:
              throw new UIException(errMoveUnrecognized + in);
          }
        case 2:
          switch(inSplit[0].length()) {
            case 1:
              return new MoveInput(Pieces.getByChar(inSplit[0].charAt(0), color),
                  new Tile(inSplit[1]));
            case 2:
              return new MoveInput(Pieces.getByChar(inSplit[0].charAt(0), color),
                  inSplit[0].charAt(1), new Tile(inSplit[1]));
            default:
              throw new UIException(errMoveUnrecognized + in);
          }
        default:
          throw new UIException(errMoveUnrecognized + in);
      }
    } catch(BoardException e) {
      throw new UIException(e.getMessage(), e);
    }
  }
}
