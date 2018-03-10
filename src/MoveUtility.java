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

    protected static boolean isValidPath(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate,
                                  Piece.PieceColorOptions playerColor) {
        Piece piece;
        piece = getPieceFromCoordinate(boardArray, initialCoordinate);

        if (piece instanceof Pawn) {
            if (isValidPawnMove(boardArray, initialCoordinate, newCoordinate, playerColor)) {
                return true;
            }
        }

        if (piece instanceof Knight) {
            if (isValidKnightMove(initialCoordinate, newCoordinate)) {
                return true;
            }
        }

        if (piece instanceof Bishop) {
            if (isValidDiagonalPath(boardArray, initialCoordinate, newCoordinate)) {
                return true;
            }
        }

        if (piece instanceof Rook) {
            if (isValidStraightPath(boardArray, initialCoordinate, newCoordinate)) {
                return true;
            }
        }

        if (piece instanceof Queen) {
            if (isValidDiagonalPath(boardArray, initialCoordinate, newCoordinate)) {
                return true;
            }
            if (isValidStraightPath(boardArray, initialCoordinate, newCoordinate)) {
                return true;
            }
        }

        if (piece instanceof King) {
            if (isValidKingMove(initialCoordinate, newCoordinate)) {
                return true;
            }
        }

        return false;
    }

    protected static boolean isValidPawnMove(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate,
                                      Piece.PieceColorOptions playerColor) {

        int diffX, diffY, forwardMultiplier;
        Piece pawnPiece, pieceToCapture;
        Coordinate betweenCoordinate, enPassantCapturedPawnCoordinate;

        diffX = subtractXCoordinates(initialCoordinate, newCoordinate);
        diffY = subtractYCoordinates(initialCoordinate, newCoordinate);

        // posY increases for White Pawns and decreases for Black Pawns
        pawnPiece = getPieceFromCoordinate(boardArray, initialCoordinate);
        if (pawnPiece.getPieceColor() == Piece.PieceColorOptions.WHITE) {
            forwardMultiplier = 1;
        }
        else {
            forwardMultiplier = -1;
        }

        // 2-space forward moves and diagonal moves have this property
        if (Math.abs(diffX) + Math.abs(diffY) == 2) {

            // Straight move
            if (diffY == 2*forwardMultiplier && !pawnPiece.getHasMoved()) {
                // Check if the space in front of the Pawn is occupied by another piece
                betweenCoordinate = new Coordinate(initialCoordinate);
                betweenCoordinate.addVals(0, forwardMultiplier);
                if (getPieceFromCoordinate(boardArray, betweenCoordinate) == null) {
                    // Check if next space in front is occupied by another piece
                    betweenCoordinate.addVals(0, forwardMultiplier);
                    if (getPieceFromCoordinate(boardArray, betweenCoordinate) == null) {
                        return true;
                    }
                }
            }

            // Diagonal move
            // If a Pawn has a total displacement of 2 and moved forward one space,
            // it must have also moved left or right one space
            if (diffY == forwardMultiplier) {
                pieceToCapture = getPieceFromCoordinate(boardArray, newCoordinate);
                if (pieceToCapture != null && pieceToCapture.getPieceColor() != playerColor) {
                    return true;
                }
            }

        }

        // 1-space forward move and promotion
        if (diffX == 0 && diffY == forwardMultiplier) {
            // Check if the space in front of the Pawn is occupied by another piece
            betweenCoordinate = new Coordinate(initialCoordinate);
            betweenCoordinate.addVals(0, forwardMultiplier);
            if (getPieceFromCoordinate(boardArray, betweenCoordinate) == null) {
                return true;
            }
        }

        return false;
    }

    protected static boolean isValidKnightMove(Coordinate initialCoordinate, Coordinate newCoordinate) {
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

    protected static boolean isValidKingMove(Coordinate initialCoordinate, Coordinate newCoordinate) {
        int absDiffX, absDiffY;

        absDiffX = Math.abs(subtractXCoordinates(initialCoordinate, newCoordinate));
        absDiffY = Math.abs(subtractYCoordinates(initialCoordinate, newCoordinate));

        // Besides castling, the King can move at most one space both horizontally and vertically
        if (absDiffX <= 1 && absDiffY <= 1) {
            return true;
        }

        return false;
    }

    protected static boolean isValidDiagonalPath(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate) {
        int diffX, diffY;

        diffX = subtractXCoordinates(initialCoordinate, newCoordinate);
        diffY = subtractYCoordinates(initialCoordinate, newCoordinate);

        // Verify that path is diagonal
        if (Math.abs(diffX) != Math.abs(diffY)) {
            return false;
        }

        if (isPathUnobstructed(boardArray, initialCoordinate, newCoordinate)) {
            return true;
        }
        return false;
    }

    protected static boolean isValidStraightPath(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate) {
        int diffX, diffY, spacesToVerify, xIncrement, yIncrement;
        Coordinate betweenCoordinate;
        Piece betweenPiece;

        diffX = subtractXCoordinates(initialCoordinate, newCoordinate);
        diffY = subtractYCoordinates(initialCoordinate, newCoordinate);

        // Verify that path is vertical or horizontal
        if (diffX != 0 && diffY != 0) {
            return false;
        }

        if (isPathUnobstructed(boardArray, initialCoordinate, newCoordinate)) {
            return true;
        }
        return false;
    }

    protected static boolean isPathUnobstructed(Piece[][] boardArray, Coordinate initialCoordinate, Coordinate newCoordinate) {
        int diffX, diffY, spacesToVerify, xIncrement, yIncrement;
        Coordinate betweenCoordinate;
        Piece betweenPiece;

        diffX = subtractXCoordinates(initialCoordinate, newCoordinate);
        diffY = subtractYCoordinates(initialCoordinate, newCoordinate);
        xIncrement = calculateIncrement(diffX);
        yIncrement = calculateIncrement(diffY);
        spacesToVerify = Math.max(Math.abs(diffX), Math.abs(diffY)) - 1;

        betweenCoordinate = new Coordinate(initialCoordinate);
        for (int i = 0; i < spacesToVerify; i++) {
            betweenCoordinate.addVals(xIncrement, yIncrement);
            betweenPiece = boardArray[betweenCoordinate.getPosY()][betweenCoordinate.getPosX()];
            if (betweenPiece != null) {
                return false;
            }
        }
        return true;

    }

    protected static Piece getPieceFromCoordinate(Piece[][] boardArray, Coordinate pieceCoordinate) {
        return boardArray[pieceCoordinate.getPosY()][pieceCoordinate.getPosX()];
    }

    protected static int subtractXCoordinates(Coordinate initialCoordinate, Coordinate newCoordinate) {
        return newCoordinate.getPosX() - initialCoordinate.getPosX();
    }

    protected static int subtractYCoordinates(Coordinate initialCoordinate, Coordinate newCoordinate) {
        return newCoordinate.getPosY() - initialCoordinate.getPosY();
    }

    protected static int calculateIncrement(int posDiff) {
        if (posDiff > 0) {
            return 1;
        }
        else if (posDiff < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

}