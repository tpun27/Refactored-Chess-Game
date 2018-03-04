public class Board {

    public static final int VERTICAL_BOARD_LENGTH = 8;
    public static final int HORIZONTAL_BOARD_LENGTH = 8;

    private Piece[][] boardArray;

    public Board() {
        this.boardArray = new Piece[VERTICAL_BOARD_LENGTH][HORIZONTAL_BOARD_LENGTH];
        BoardUtility.initializeBoardPieces(boardArray);
    }

    public Piece[][] getBoardArray() {
        return boardArray;
    }

    public void makeMove(String initialPos, String newPos) {
        Coordinate initialCoordinate, newCoordinate;
        initialCoordinate = new Coordinate(initialPos);
        newCoordinate = new Coordinate(newPos);

        Piece movingPiece = getPieceFromCoordinate(initialCoordinate);
        boardArray[newCoordinate.getPosY()][newCoordinate.getPosX()] = movingPiece;
        boardArray[initialCoordinate.getPosY()][initialCoordinate.getPosX()] = null;
    }

    protected Piece getPieceFromCoordinate(Coordinate pieceCoordinate) {
        return boardArray[pieceCoordinate.getPosY()][pieceCoordinate.getPosX()];
    }

}
