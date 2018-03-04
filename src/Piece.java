public abstract class Piece {

    public enum PieceColorOptions {
        WHITE, BLACK
    }

    protected PieceColorOptions pieceColor;
    protected char pieceSymbol;

    public Piece() {

    }

    /* Getters and Setters */
    public PieceColorOptions getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColorOptions pieceColor) {
        this.pieceColor = pieceColor;
    }

    public char getPieceSymbol() {
        return pieceSymbol;
    }

    public abstract void setPieceSymbol();

}
