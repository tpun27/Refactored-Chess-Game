public class Board {

    public static final int VERTICAL_BOARD_LENGTH = 8;
    public static final int HORIZONTAL_BOARD_LENGTH = 8;

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

        Piece movingPiece = boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()];
        boardArray[newCoordinate.getPosY()][newCoordinate.getPosX()] = movingPiece;
        boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()] = null;

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
