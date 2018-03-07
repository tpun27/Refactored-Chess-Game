public class MoveUtility {

    // Validates moves based solely on piece color
    protected static boolean isValidEndpoints(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate,
                                       Piece.PieceColorOptions playerColor) {
        Piece startPiece, endPiece;

        startPiece = getPieceFromCoordinate(boardArray, initialCoordinate);
        if (startPiece == null || startPiece.getPieceColor() != playerColor) {
            return false;
        }

        endPiece = getPieceFromCoordinate(boardArray, newCoordinate);
        if (endPiece != null && endPiece.getPieceColor() == playerColor) {
            return false;
        }
        return true;
    }

    protected boolean isValidPath(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate,
                                  Piece.PieceColorOptions playerColor) {
        Piece piece;
        piece = getPieceFromCoordinate(boardArray, initialCoordinate);

        if (piece instanceof Pawn) {

        }

        if (piece instanceof Knight) {

        }

        if (piece instanceof Bishop) {

        }

        if (piece instanceof Rook) {

        }

        if (piece instanceof Queen) {

        }

        if (piece instanceof King) {

        }

        return false;
    }

    protected static Piece getPieceFromCoordinate(Piece[][] boardArray, Coordinate pieceCoordinate) {
        return boardArray[pieceCoordinate.getPosY()][pieceCoordinate.getPosX()];
    }

}
