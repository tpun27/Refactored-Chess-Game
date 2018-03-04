public class PlayChess {
    public static void main(String args[]) {
        Board board = new Board();
        Piece[][] boardArray = board.getBoardArray();
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "e2", "e4");
        board.makeMove("e2", "e4");
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "e7", "e5");
        board.makeMove("e7", "e5");
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "g1", "f3");
        board.makeMove("g1", "f3");
        BoardUtility.printBoard(boardArray);

        System.out.format("Moving piece from %s to %s:\n", "b8", "c6");
        board.makeMove("b8", "c6");
        BoardUtility.printBoard(boardArray);
    }
}
