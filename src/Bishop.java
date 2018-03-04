public class Bishop extends Piece {

    public static final char WHITE_BISHOP_SYMBOL = '\u2657';
    public static final char BLACK_BISHOP_SYMBOL = '\u265D';

    public Bishop(Piece.PieceColorOptions pieceColor, String pieceStringPos) {
        super(pieceColor, pieceStringPos);
        setPieceSymbol();
    }

    /* Implement abstract method setPieceSymbol() */
    public void setPieceSymbol() {
        if (this.pieceColor == Piece.PieceColorOptions.WHITE)
            this.pieceSymbol = WHITE_BISHOP_SYMBOL;
        else if (pieceColor == Piece.PieceColorOptions.BLACK)
            this.pieceSymbol = BLACK_BISHOP_SYMBOL;
    }

}
