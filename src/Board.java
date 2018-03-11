public class Board {

    public static final int VERTICAL_BOARD_LENGTH = 8;
    public static final int HORIZONTAL_BOARD_LENGTH = 8;
    public static final String KING_SIDE_CASTLE_STRING = "O-O";
    public static final String QUEEN_SIDE_CASTLE_STRING = "O-O-O";

    private Piece[][] boardArray;
    protected Piece.PieceColorOptions nextMoveColor;

    public Board() {
        this.boardArray = new Piece[VERTICAL_BOARD_LENGTH][HORIZONTAL_BOARD_LENGTH];
        BoardUtility.initializeBoardPieces(boardArray);
        nextMoveColor = Piece.PieceColorOptions.WHITE;
    }

    public Piece[][] getBoardArray() {
        return boardArray;
    }

    public void makeMove(String initialPos, String newPos) throws InvalidBoardPositionException, InvalidMoveException {
        Coordinate initialCoordinate, newCoordinate;

        initialCoordinate = new Coordinate(initialPos);
        newCoordinate = new Coordinate(newPos);

        // Verify that user inputs valid chess notation
        if (initialCoordinate.getChessStringPos() == null || newCoordinate.getChessStringPos() == null) {
            throw new InvalidBoardPositionException();
        }

        if (!MoveUtility.isValidEndpoints(boardArray, initialCoordinate, newCoordinate, nextMoveColor)) {
            throw new InvalidMoveException();
        }

        if (!MoveUtility.isValidPath(boardArray, initialCoordinate, newCoordinate, nextMoveColor)) {
            throw new InvalidMoveException();
        }

        // Make the move if it does not result in the current player's King being checked
        if (CheckUtility.isMovePossibleWithoutCheck(boardArray, initialCoordinate, newCoordinate, nextMoveColor)) {
            Piece movingPiece = MoveUtility.getPieceFromCoordinate(boardArray, initialCoordinate);
            boardArray[newCoordinate.getPosY()][newCoordinate.getPosX()] = movingPiece;
            boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()] = null;
            movingPiece.setPieceCoordinate(newCoordinate);
            movingPiece.setHasMoved(true);

        } else {
            throw new InvalidMoveException();
        }

        // Output a message if the player has won or if the next player is in check
        nextMoveColor = oppositeColor(nextMoveColor);
        if (CheckUtility.isInCheck(boardArray, nextMoveColor)) {
            if (CheckUtility.isInCheckMate(boardArray, nextMoveColor)) {
                System.out.println("Congratulations! " + oppositeColor(nextMoveColor) + " Wins!");
            }
            else {
                System.out.println(nextMoveColor  + " is in check!");
            }
        }
        else if (CheckUtility.isInStaleMate(boardArray, nextMoveColor)) {
            System.out.println("It's a draw!");
        }
    }

    // Version of makeMove to handle castling
    public void makeMove(String castleString) throws InvalidMoveException {
        Piece kingPiece, rookPiece, betweenPiece;
        Coordinate kingCoordinate, rookCoordinate, betweenCoordinate, oppCoordinate;
        int xIncrement, spacesToRook;

        // Verify valid castle String O-O or O-O-O
        if (!castleString.equals(KING_SIDE_CASTLE_STRING) && !castleString.equals(QUEEN_SIDE_CASTLE_STRING)) {
            throw new InvalidMoveException();
        }

        kingCoordinate = CheckUtility.getKingCoordinate(boardArray, nextMoveColor);
        kingPiece = MoveUtility.getPieceFromCoordinate(boardArray, kingCoordinate);

        // King cannot be in check or have moved already
        if (CheckUtility.isInCheck(boardArray, nextMoveColor) || kingPiece.getHasMoved()) {
            throw new InvalidMoveException();
        }

        if (castleString == KING_SIDE_CASTLE_STRING) {
            xIncrement = 1;
            spacesToRook = 3;
        }
        else {
            xIncrement = -1;
            spacesToRook = 4;
        }

        rookCoordinate = new Coordinate(kingCoordinate.getPosX() + spacesToRook * xIncrement,
                kingCoordinate.getPosY());
        rookPiece = MoveUtility.getPieceFromCoordinate(boardArray, rookCoordinate);
        // Rook must not have moved already
        if (!(rookPiece instanceof Rook) || rookPiece.getPieceColor() != nextMoveColor || rookPiece.getHasMoved()) {
            throw new InvalidMoveException();
        }

        betweenCoordinate = new Coordinate(kingCoordinate);
        for (int i = 0; i < 2; i++) {
            betweenCoordinate.addVals(xIncrement, 0);
            betweenPiece = MoveUtility.getPieceFromCoordinate(boardArray, betweenCoordinate);
            // The two spaces to the left or right of the King must be empty
            if (betweenPiece != null) {
                throw new InvalidMoveException();
            }
            for (int j = 0; j < VERTICAL_BOARD_LENGTH; j++) {
                for (int k = 0; k < HORIZONTAL_BOARD_LENGTH; k++) {
                    oppCoordinate = new Coordinate(k, j);
                    // an opposing piece cannot be attacking the two empty spaces
                    if (MoveUtility.isValidEndpoints(boardArray, oppCoordinate, betweenCoordinate, oppositeColor(nextMoveColor))) {
                        if (MoveUtility.isValidPath(boardArray, oppCoordinate, betweenCoordinate, oppositeColor(nextMoveColor))) {
                            throw new InvalidMoveException();
                        }
                    }
                }
            }
        }

        // Move the King and Rook for castling
        boardArray[betweenCoordinate.getPosY()][betweenCoordinate.getPosX()] = kingPiece;
        boardArray[kingCoordinate.getPosY()][kingCoordinate.getPosX()] = null;
        kingPiece.setPieceCoordinate(betweenCoordinate);

        betweenCoordinate.addVals(xIncrement * -1, 0);
        boardArray[betweenCoordinate.getPosY()][betweenCoordinate.getPosX()] = rookPiece;
        boardArray[rookCoordinate.getPosY()][rookCoordinate.getPosX()] = null;
        rookPiece.setPieceCoordinate(betweenCoordinate);


        kingPiece.setHasMoved(true);
        rookPiece.setHasMoved(true);

        nextMoveColor = oppositeColor(nextMoveColor);
    }

    protected static Piece.PieceColorOptions oppositeColor(Piece.PieceColorOptions currentColor) {
        if (currentColor == Piece.PieceColorOptions.WHITE) {
            return Piece.PieceColorOptions.BLACK;
        }
        else {
            return Piece.PieceColorOptions.WHITE;
        }
    }

}
