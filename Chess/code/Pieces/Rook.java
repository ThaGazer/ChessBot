package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    private static int rookNonce = 0;

    public Rook() {
        nonce = ++rookNonce;
        setShorthand("R");
    }

    public Rook(boolean whiteBlack) {
        this();
        setColor(whiteBlack);
    }

    public Rook(Rook r) {
        super(r);
    }

    @Override
    public Set<Tile> moveSet(Tile t) {
        Set<Tile> moves = new HashSet<>();
        for(int i = 1; i <= MAXNUMMOVES-t.getRow(); i++) {
            moves.add(new Tile((t.getRow()+i), t.getCol()));
        }
        for(int i = 1; i <= t.getRow(); i++) {
            moves.add(new Tile((t.getRow()+i), t.getCol()));
        }
        for(int i = 1; i <= MAXNUMMOVES-t.getCol(); i++) {
            moves.add(new Tile(t.getRow(), (t.getCol()+i)));
        }
        for(int i = 1; i <= t.getCol(); i++) {
            moves.add(new Tile(t.getRow(), (t.getCol()+i)));
        }
        return moves;
    }
}
