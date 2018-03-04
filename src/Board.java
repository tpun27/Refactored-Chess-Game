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
}
