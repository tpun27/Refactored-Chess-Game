public class PlayChess {
    public static void main(String args[]) {
        Board board = new Board();
        Piece[][] boardArray = board.getBoardArray();
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "e2", "e4");
        move(board, "e2", "e4");
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "e7", "e5");
        move(board, "e7", "e5");
        BoardUtility.printBoard(boardArray);

        System.out.format("Attemping illegal move: Moving piece from %s to %s:\n", "g1", "g2");
        move(board, "g1", "g2");

        System.out.format("Attemping illegal move: Invalid position strings %s to %s:\n", "G1", "F3");
        move(board, "G1", "F3");

    }

    public static void move(Board board, String initialPos, String newPos) {
        try {
            board.makeMove(initialPos, newPos);
        } catch (InvalidBoardPositionException e) {
            e.printErrorMsg();
        } catch (InvalidMoveException e) {
            e.printErrorMsg();
        }
    }
}
