package UI;

import Models.Board.ChessBoardException;
import Models.Board.Tile;
import Models.Pieces.Piece;
import Models.Pieces.Pieces;

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
  public static MoveInput parse(String in, boolean color) throws ChessBoardException {
    if(in.isEmpty()) {
      throw new ChessBoardException(errMoveUnrecognized + in);
    }

    String[] inSplit = in.toLowerCase().split("x");

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
            throw new ChessBoardException(errMoveUnrecognized + in);
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
            throw new ChessBoardException(errMoveUnrecognized + in);
        }
      default:
        throw new ChessBoardException(errMoveUnrecognized + in);
    }
  }
}
