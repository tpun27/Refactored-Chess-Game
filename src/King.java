public class King extends Piece {

    public static final char WHITE_KING_SYMBOL = '\u2654';
    public static final char BLACK_KING_SYMBOL = '\u265A';

    public King(Piece.PieceColorOptions pieceColor, String pieceStringPos) {
        super(pieceColor, pieceStringPos);
        setPieceSymbol();
    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == Piece.PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_KING_SYMBOL;
        else if (pieceColor == Piece.PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_KING_SYMBOL;
    }

}
