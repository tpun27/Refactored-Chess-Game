public class PlayChess {
    public static void main(String args[]) {
        Board board = new Board();
        Piece[][] boardArray = board.getBoardArray();
        BoardUtility.printBoard(boardArray);

//        System.out.format("Moving piece from %s to %s:\n", "e2", "e4");
//        board.makeMove("e2", "e4");
//        BoardUtility.printBoard(boardArray);
//
//        System.out.format("Moving piece from %s to %s:\n", "e7", "e5");
//        board.makeMove("e7", "e5");
//        BoardUtility.printBoard(boardArray);
//
//        System.out.format("Moving piece from %s to %s:\n", "g1", "f3");
//        board.makeMove("g1", "f3");
//        BoardUtility.printBoard(boardArray);
//
//        System.out.format("Moving piece from %s to %s:\n", "b8", "c6");
//        board.makeMove("b8", "c6");
//        BoardUtility.printBoard(boardArray);

        System.out.println("Checking if moving \"e2\" to \"e4\" is a valid move based on start and end positions:");
        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e2"), new Coordinate("e4"), Piece.PieceColorOptions.WHITE));

        System.out.println("Checking if moving \"e2\" to \"d2\" is a valid move based on start and end positions:");
        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e2"), new Coordinate("d2"), Piece.PieceColorOptions.WHITE));

        System.out.println("Checking if moving \"e3\" to \"e4\" is a valid move based on start and end positions:");
        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e3"), new Coordinate("e4"), Piece.PieceColorOptions.WHITE));
    }
}
