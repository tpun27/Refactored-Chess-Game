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
            if (isValidKnightMove(initialCoordinate, newCoordinate)) {
                return true;
            }
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

    protected boolean isValidKnightMove(Coordinate initialCoordinate, Coordinate newCoordinate) {
        int absDiffX, absDiffY;

        absDiffX = Math.abs(subtractXCoordinates(initialCoordinate, newCoordinate));
        absDiffY = Math.abs(subtractYCoordinates(initialCoordinate, newCoordinate));

        // All valid Knight moves move 1 space either horizontally or vertically
        // and 2 spaces in the other direction
        if (absDiffX + absDiffY == 3) {
            if ((absDiffX == 1 || absDiffY == 1) && (absDiffX == 2 || absDiffY == 2)) {
                return true;
            }
        }
        return false;
    }

    protected static Piece getPieceFromCoordinate(Piece[][] boardArray, Coordinate pieceCoordinate) {
        return boardArray[pieceCoordinate.getPosY()][pieceCoordinate.getPosX()];
    }

    protected int subtractXCoordinates(Coordinate initialCoordinate, Coordinate newCoordinate) {
        return newCoordinate.getPosX() - initialCoordinate.getPosX();
    }

    protected int subtractYCoordinates(Coordinate initialCoordinate, Coordinate newCoordinate) {
        return newCoordinate.getPosY() - initialCoordinate.getPosY();
    }

}