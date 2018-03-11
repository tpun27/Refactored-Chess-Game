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

    protected static boolean isInCheckMate(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {
        if (isKingMovable(boardArray, playerColor)) {
            return false;
        }

        if (isCheckBlockable(boardArray, playerColor)) {
            return false;
        }

        return true;
    }

    protected static boolean isKingMovable(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {
        Coordinate kingCoordinate, oppCoordinate;
        int kingPosX, kingPosY;

        kingCoordinate = getKingCoordinate(boardArray, playerColor);
        kingPosX = kingCoordinate.getPosX();
        kingPosY = kingCoordinate.getPosY();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                oppCoordinate = new Coordinate(kingPosX + i, kingPosY + j);
                // If the position data in oppCoordinate is not empty, the Coordinate is a valid board space
                if (oppCoordinate.getChessStringPos() != null) {
                    if (MoveUtility.isValidEndpoints(boardArray, kingCoordinate, oppCoordinate, playerColor)) {
                        if (isMovePossibleWithoutCheck(boardArray, kingCoordinate, oppCoordinate, playerColor)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // This function groups both capturing and blocking together even though
    // capturing the opposing piece is not technically considered blocking a check
    protected static boolean isCheckBlockable(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {

        Coordinate[] coordinatesToBlock;
        Coordinate kingCoordinate, oppCoordinate, allyCoordinate;
        int blockCounter, diffX, diffY, spacesToVerify, xIncrement, yIncrement;

        coordinatesToBlock = new Coordinate[Board.VERTICAL_BOARD_LENGTH];
        kingCoordinate = getKingCoordinate(boardArray, playerColor);
        oppCoordinate = null;
        blockCounter = 0;

        outerloop:
        for (int i = 0; i < Board.VERTICAL_BOARD_LENGTH; i++) {
            for (int j = 0; j < Board.HORIZONTAL_BOARD_LENGTH; j++) {
                oppCoordinate = new Coordinate(j, i);
                if (MoveUtility.isValidEndpoints(boardArray, oppCoordinate, kingCoordinate, Board.oppositeColor(playerColor))) {
                    if (MoveUtility.isValidPath(boardArray, oppCoordinate, kingCoordinate, Board.oppositeColor(playerColor))) {
                        coordinatesToBlock[blockCounter] = oppCoordinate;
                        blockCounter++;
                        // If there is more than one piece checking the King
                        // the check is not blockable
                        break outerloop;
                    }
                }
            }
        }

        diffX = MoveUtility.subtractXCoordinates(oppCoordinate, kingCoordinate);
        diffY = MoveUtility.subtractYCoordinates(oppCoordinate, kingCoordinate);
        xIncrement = MoveUtility.calculateIncrement(diffX);
        yIncrement = MoveUtility.calculateIncrement(diffY);
        spacesToVerify = Math.max(Math.abs(diffX), Math.abs(diffY)) - 1;

        // Moving a piece to oppCoordinate capture's the opposing piece
        // only opposing Bishops, Rooks, and Queens can be blocked
        if (MoveUtility.isValidDiagonalPath(boardArray, oppCoordinate, kingCoordinate) || MoveUtility.isValidStraightPath(boardArray, oppCoordinate, kingCoordinate)) {
            for (int i = 0; i < spacesToVerify; i++) {
                Coordinate betweenCoordinate = new Coordinate(oppCoordinate);
                betweenCoordinate.addVals(xIncrement, yIncrement);
                coordinatesToBlock[blockCounter] = betweenCoordinate;
                blockCounter++;
            }
        }

        // Loop through all Coordinates in coordinatesToBlock and see if any can block the check
        for (int i = 0; i < blockCounter; i++) {
            oppCoordinate = coordinatesToBlock[i];
            for (int j = 0; j < Board.VERTICAL_BOARD_LENGTH; j++) {
                for (int k = 0; k < Board.HORIZONTAL_BOARD_LENGTH; k++) {
                    allyCoordinate = new Coordinate(k, j);
                    if (MoveUtility.isValidEndpoints(boardArray, allyCoordinate, oppCoordinate, playerColor)) {
                        if (MoveUtility.isValidPath(boardArray, allyCoordinate, oppCoordinate, playerColor)) {
                            if (isMovePossibleWithoutCheck(boardArray, allyCoordinate, oppCoordinate, playerColor)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    protected boolean isInStaleMate(Piece[][] boardArray, Piece.PieceColorOptions playerColor) {
        Piece allyPiece;
        Coordinate allyCoordinate;

        for (int i = 0; i < Board.VERTICAL_BOARD_LENGTH; i++) {
            for (int j = 0; j < Board.HORIZONTAL_BOARD_LENGTH; j++) {
                allyCoordinate = new Coordinate(j, i);
                allyPiece = MoveUtility.getPieceFromCoordinate(boardArray, allyCoordinate);
                if (allyPiece != null && allyPiece.getPieceColor() == playerColor) {
                    if (isMovable(allyPiece)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected boolean isMovable(Piece piece) {
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
