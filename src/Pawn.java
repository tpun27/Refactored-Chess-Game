public class Pawn extends Piece {

    public static final char WHITE_PAWN_SYMBOL = '\u2659';
    public static final char BLACK_PAWN_SYMBOL = '\u265F';

    public Pawn() {

    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_PAWN_SYMBOL;
        else if (pieceColor == PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_PAWN_SYMBOL;
    }
}
