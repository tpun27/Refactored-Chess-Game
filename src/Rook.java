public class Rook extends Piece {

    public static final char WHITE_ROOK_SYMBOL = '\u2656';
    public static final char BLACK_ROOK_SYMBOL = '\u265C';

    public Rook() {

    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == Piece.PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_ROOK_SYMBOL;
        else if (pieceColor == Piece.PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_ROOK_SYMBOL;
    }
}
