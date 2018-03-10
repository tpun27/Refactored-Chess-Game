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

//        System.out.println("Checking if moving \"e2\" to \"e4\" is a valid move based on start and end positions:");
//        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e2"), new Coordinate("e4"), Piece.PieceColorOptions.WHITE));
//
//        System.out.println("Checking if moving \"e2\" to \"d2\" is a valid move based on start and end positions:");
//        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e2"), new Coordinate("d2"), Piece.PieceColorOptions.WHITE));
//
//        System.out.println("Checking if moving \"e3\" to \"e4\" is a valid move based on start and end positions:");
//        System.out.println(MoveUtility.isValidEndpoints(boardArray, new Coordinate("e3"), new Coordinate("e4"), Piece.PieceColorOptions.WHITE));

        System.out.println("-Testing isValidPath()");
        System.out.println("-Note that generally isValidEndpoints() should be called prior to isValidPath()");
        System.out.println("-isValidEndpoints() will check that the start Coordinate contains a piece of the correct color");
        System.out.println("and that the end Coordinate will contain no piece or a piece of the opposite color");
        System.out.println("-isValidPath() will check that the moving piece can move to the end Coordinate\n");

        System.out.println("Checking if a Knight can move from g1 to f3");
        System.out.println(MoveUtility.isValidPath(boardArray, new Coordinate("g1"), new Coordinate("f3"), Piece.PieceColorOptions.WHITE));
        System.out.println("Checking if a Knight can move from g1 to f2");
        System.out.println(MoveUtility.isValidPath(boardArray, new Coordinate("g1"), new Coordinate("f2"), Piece.PieceColorOptions.WHITE));

        System.out.println("Checking if a Bishop can move from f1 to d3");
        board.makeMove("e2", "e4"); // This will prevent isPathUnobstructed() from returning false
        System.out.println(MoveUtility.isValidPath(boardArray, new Coordinate("f1"), new Coordinate("d3"), Piece.PieceColorOptions.WHITE));

        System.out.println("Checking if a Rook can move from a1 to a3");
        board.makeMove("a2", "a4"); // This will prevent isPathUnobstructed() from returning false
        System.out.println(MoveUtility.isValidPath(boardArray, new Coordinate("a1"), new Coordinate("a3"), Piece.PieceColorOptions.WHITE));
    }
}
