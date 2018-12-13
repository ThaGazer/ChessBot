package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {


    public King() {
        setShorthand("K");
    }

    public King(boolean whiteBlack) {
        this();
        setColor(whiteBlack);
    }

    public King(King k) {
        super(k);
    }

    @Override
    public Set<Tile> moveSet(Tile t) {
        Set<Tile> moves = new HashSet<>();

        moves.add(new Tile((t.getRow()+1), t.getCol()));
        moves.add(new Tile((t.getRow()+1), (t.getCol()+1)));
        moves.add(new Tile(t.getRow(), (t.getCol()+1)));
        moves.add(new Tile((t.getRow()-1), (t.getCol()+1)));
        moves.add(new Tile((t.getRow()-1), t.getCol()));
        moves.add(new Tile((t.getRow()-1), (t.getCol()-1)));
        moves.add(new Tile(t.getRow(), (t.getCol()-1)));
        moves.add(new Tile((t.getRow()+1), (t.getCol()-1)));

        return moves;
    }
}
