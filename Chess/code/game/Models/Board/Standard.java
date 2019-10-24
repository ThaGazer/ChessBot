package game.Models.Board;

import game.ChessException;
import game.Models.Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Standard extends Base {

  private static final String errUnrecognizedNonce = "unrecognized nonce";
  private static final String errCouldntFindPiece = "could not find a matching piece: ";

  public Standard() throws ChessException {
    super();
  }

  protected void fill_In_Pieces() {
    for(int i = 0; i < BOARDLENGTH; i++) {
      board.get(((BOARDLENGTH * 7)) + i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], BLACK));
      board.get((BOARDLENGTH * 6) + i) .setPiece(new Pawn(BLACK));

      board.get(BOARDLENGTH + i).setPiece(new Pawn(WHITE));
      board.get(i).setPiece(Pieces.getByEnum(Pieces.piecePlacementOrder()[i], WHITE));
    }
  }

  //TODO wip
  public Tile movePiece(Piece pieceToMove, Tile futureTile, char pieceNonce, boolean turn)
      throws ChessException {
    Tile futureBoardTile = getTile(futureTile);
    Tile foundTile = findPiecesTile(pieceToMove, futureBoardTile, pieceNonce);

    swapPieces(foundTile, futureBoardTile);

    return futureBoardTile;
  }

  private Tile findPiecesTile(Piece pieceToFind, Tile futureTile, char pieceNonce)
      throws ChessException {
    List<Tile> tiles = possiblePieces(pieceToFind, futureTile);

    if(tiles.size() == 1) {
      return tiles.get(0);
    }

    for(Tile t : tiles) {
      if(matchNonce(t, pieceNonce)) {
        return t;
      }
    }
    throw new ChessException(errCouldntFindPiece + pieceToFind + futureTile);
  }

  private List<Tile> possiblePieces(Piece pieceToMove, Tile futureTile)
      throws ChessException {
    List<Tile> ret = new ArrayList<>();
    for(Tile t : getBoard()) {
      Piece tilePiece = t.getPiece();
      if(tilePiece != null) {
        if(pieceToMove.equals(tilePiece) && tilePiece.moveSet(t).contains(futureTile)) {
          ret.add(t);
        }
      }
    }
    return ret;
  }

  private boolean matchNonce(Tile tile, char nonce) throws ChessException {
    if(nonce == ' ') {
      return true;
    }

    if(Character.isAlphabetic(nonce)) {
      return tile.getCol() == Tile.getColumn(nonce).getNumberRep();
    } else if (Character.isDigit(nonce)) {
      return tile.getRow() == nonce;
    } else {
      throw new ChessException(errUnrecognizedNonce);
    }
  }

  //TODO move to Base class
  private void swapPieces(Tile oldTile, Tile newTile) throws ChessException {
    if(chessRules(oldTile, newTile))
    newTile.setPiece(oldTile.getPiece());
    oldTile.clearPiece();
  }

  //TODO wip
  private boolean chessRules(Tile oldTile, Tile newTile) throws ChessException {
    boolean ret;
    if(ret = pieceRuleSet(oldTile, newTile)) {
      switch(Pieces.valueOfChar(oldTile.getPiece().getShorthand())) {
        case PAWN:
          ret = pawnRuleSet(oldTile, newTile);
          break;
        case KING:
          ret = kingRuleSet(oldTile, newTile);
          break;
      }
    }
    return ret;
  }

  private boolean pieceRuleSet(Tile old, Tile newt) throws ChessException {
    if(old.getCol() == newt.getCol()) {
      for(int i = old.getCol(); i < newt.getCol()-1; i++) {
        if(getTile(new Tile(old.getRow(), i)).holdsPiece()) {

        }
      }
    }
    return true;
  }

  private boolean pawnRuleSet(Tile old, Tile newt) {
    return true;
  }

  private boolean kingRuleSet(Tile old, Tile newt) {
    return true;
  }
}
