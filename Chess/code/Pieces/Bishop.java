package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    private static int bishopNonce = 0;

    public Bishop() {
        nonce = ++bishopNonce;
        setShorthand("B");
    }

    public Bishop(boolean whiteBlack) {
        this();
        setColor(whiteBlack);
    }

    public Bishop(Bishop b) {
        super(b);
    }

    @Override
    public Set<Tile> moveSet(Tile t) {
        Set<Tile> moves = new HashSet<>();
        for(int i = 1; i <= MAXNUMMOVES-t.getRow() && i <= MAXNUMMOVES-t.getCol(); i++) {
            moves.add(new Tile((t.getRow()+i), (t.getCol()+i)));
        }
        for(int i = 0; i <= MAXNUMMOVES-t.getRow() && i <= t.getCol(); i++) {
            moves.add(new Tile((t.getRow()+i), (t.getCol()-i)));
        }
        for(int i = 0; i <= t.getRow() && i <= MAXNUMMOVES-t.getCol(); i++) {
            moves.add(new Tile((t.getRow()-i), (t.getCol()+i)));
        }
        for(int i = 0; i <= t.getRow() && i <= t.getCol(); i++) {
            moves.add(new Tile((t.getRow()-i), (t.getCol()-i)));
        }
        return moves;
    }
}
