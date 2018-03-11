public abstract class Piece {

    public enum PieceColorOptions {
        WHITE, BLACK
    }

    protected PieceColorOptions pieceColor;
    protected char pieceSymbol;
    protected Coordinate pieceCoordinate;
    protected boolean hasMoved;

    public Piece(PieceColorOptions pieceColor, String pieceStringPos) {
        setPieceColor(pieceColor);
        setPieceCoordinate(pieceStringPos);
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

    public Coordinate getPieceCoordinate() {
        return pieceCoordinate;
    }

    public void setPieceCoordinate(String pieceStringPos) {
        pieceCoordinate = new Coordinate(pieceStringPos);
    }

    public void setPieceCoordinate(Coordinate pieceCoordinate) {
        this.pieceCoordinate = pieceCoordinate;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

}
