public class Knight extends Piece {

    public static final char WHITE_KNIGHT_SYMBOL = '\u2658';
    public static final char BLACK_KNIGHT_SYMBOL = '\u265E';

    public Knight() {

    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_KNIGHT_SYMBOL;
        else if (pieceColor == PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_KNIGHT_SYMBOL;
    }
}
