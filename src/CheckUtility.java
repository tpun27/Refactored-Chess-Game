public final class CheckUtility {

    // Move validation logic: Perform the move. Check if it is valid. Undo the move.
    protected static boolean isMovePossibleWithoutCheck(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate,
                                                 Piece.PieceColorOptions playerColor) {
        Piece movingPiece, capturedPiece = null;
        boolean isPossible;
        int incrementY;

        movingPiece = MoveUtility.getPieceFromCoordinate(boardArray, initialCoordinate);
        capturedPiece = MoveUtility.getPieceFromCoordinate(boardArray, newCoordinate);

        boardArray[newCoordinate.getPosY()][newCoordinate.getPosX()] = movingPiece;
        boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()] = null;

        if (isInCheck(playerColor)) {
            isPossible = false;
        }
        else {
            isPossible = true;
        }

        // Undo Board changes
        boardArray[newCoordinate.getPosY()][newCoordinate.getPosX()] = capturedPiece;
        boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()] = movingPiece;

        return isPossible;
    }

    protected static boolean isInCheck(Piece.PieceColorOptions playerColor) {
        return false;
    }
}
