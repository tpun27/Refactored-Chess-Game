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

        if (isInCheck(boardArray, playerColor)) {
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

    // Finds all opposing pieces and see's if they have a clear path to the King
    protected static boolean isInCheck(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {
        Coordinate kingCoordinate, oppCoordinate;
        kingCoordinate = getKingCoordinate(boardArray, playerColor);

        for (int i = 0; i < Board.VERTICAL_BOARD_LENGTH; i++) {
            for (int j = 0; j < Board.HORIZONTAL_BOARD_LENGTH; j++) {
                oppCoordinate = new Coordinate(j, i);

                if (MoveUtility.isValidEndpoints(boardArray, oppCoordinate, kingCoordinate, Board.oppositeColor(playerColor))) {
                    if (MoveUtility.isValidPath(boardArray, oppCoordinate, kingCoordinate, Board.oppositeColor(playerColor))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected static Coordinate getKingCoordinate(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {
        Piece kingPiece;
        Coordinate kingCoordinate;

        kingCoordinate = null;
        outerLoop:
        for (int i = 0; i < Board.VERTICAL_BOARD_LENGTH; i++) {
            for (int j = 0; j < Board.HORIZONTAL_BOARD_LENGTH; j++) {
                kingCoordinate = new Coordinate(j, i);
                kingPiece = MoveUtility.getPieceFromCoordinate(boardArray, kingCoordinate);
                if ((kingPiece instanceof King) && kingPiece.getPieceColor() == playerColor) {
                    break outerLoop;
                }
            }
        }
        return kingCoordinate;
    }
}
