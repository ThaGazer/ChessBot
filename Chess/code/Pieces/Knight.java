package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    private static int knightNonce = 0;

    public Knight() {
        nonce = ++knightNonce;
        setShorthand("N");
    }

    public Knight(boolean whiteBlack) {
        this();
        setColor(whiteBlack);
    }

    public Knight(Knight n) {
        super(n);
    }

    @Override
    public Set<Tile> moveSet(Tile t) {
        Set<Tile> moves = new HashSet<>();
        moves.add(new Tile((t.getRow()+2), (t.getCol()+1)));
        moves.add(new Tile((t.getRow()+2), (t.getCol()-1)));
        moves.add(new Tile((t.getRow()+1), (t.getCol()+2)));
        moves.add(new Tile((t.getRow()-1), (t.getCol()+2)));
        moves.add(new Tile((t.getRow()-2), (t.getCol()+1)));
        moves.add(new Tile((t.getRow()-2), (t.getCol()-1)));
        moves.add(new Tile((t.getRow()+1), (t.getCol()-2)));
        moves.add(new Tile((t.getRow()-1), (t.getCol()-2)));
        return moves;
    }
}
