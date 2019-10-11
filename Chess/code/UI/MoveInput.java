package UI;

import Models.Board.ChessBoardException;
import Models.Board.Tile;
import Models.Pieces.Piece;
import Models.Pieces.Pieces;

public class MoveInput {

  private static final String errMoveUnrecognized = "move input unrecognized ";

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

  public static MoveInput parse(String in, boolean color) throws ChessBoardException {
    switch(in.length()) {
      case 2:
        return new MoveInput(Pieces.getByEnum(Pieces.PAWN, color), new Tile(in));
      case 3:
        return new MoveInput(Pieces.getByChar(in.charAt(0), color), new Tile(in.substring(1)));
      case 4:
        return new MoveInput(Pieces.getByChar(in.charAt(0), color), new Tile(in.substring(2)));
      default:
        throw new ChessBoardException(errMoveUnrecognized + in);
    }
  }
}
