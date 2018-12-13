package Pieces;

import Board.Tile;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

    public Queen() {
        setShorthand("Q");
    }

    public Queen(boolean whiteBlack) {
        this();
        setColor(whiteBlack);
    }

    public Queen(Queen q){
        super(q);
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
