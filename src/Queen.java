public class Queen extends Piece {

    public static final char WHITE_QUEEN_SYMBOL = '\u2655';
    public static final char BLACK_QUEEN_SYMBOL = '\u265B';

    public Queen() {

    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == Piece.PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_QUEEN_SYMBOL;
        else if (pieceColor == Piece.PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_QUEEN_SYMBOL;
    }

}
