public final class BoardUtility {

    public static final char DEFAULT_PIECE_SYMBOL = '\u2026';

    public static void initializeBoardPieces(Piece[][] boardArray) {
        // White Pawns
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "a2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "b2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "c2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "d2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "e2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "f2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "g2"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.WHITE, "h2"));

        // Black Pawns
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "a7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "b7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "c7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "d7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "e7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "f7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "g7"));
        addPieceToBoard(boardArray, new Pawn(Piece.PieceColorOptions.BLACK, "h7"));

        // Knights
        addPieceToBoard(boardArray, new Knight(Piece.PieceColorOptions.WHITE, "b1"));
        addPieceToBoard(boardArray, new Knight(Piece.PieceColorOptions.WHITE, "g1"));
        addPieceToBoard(boardArray, new Knight(Piece.PieceColorOptions.BLACK, "b8"));
        addPieceToBoard(boardArray, new Knight(Piece.PieceColorOptions.BLACK, "g8"));

        // Bishops
        addPieceToBoard(boardArray, new Bishop(Piece.PieceColorOptions.WHITE, "c1"));
        addPieceToBoard(boardArray, new Bishop(Piece.PieceColorOptions.WHITE, "f1"));
        addPieceToBoard(boardArray, new Bishop(Piece.PieceColorOptions.BLACK, "c8"));
        addPieceToBoard(boardArray, new Bishop(Piece.PieceColorOptions.BLACK, "f8"));

        // Rooks
        addPieceToBoard(boardArray, new Rook(Piece.PieceColorOptions.WHITE, "a1"));
        addPieceToBoard(boardArray, new Rook(Piece.PieceColorOptions.WHITE, "h1"));
        addPieceToBoard(boardArray, new Rook(Piece.PieceColorOptions.BLACK, "a8"));
        addPieceToBoard(boardArray, new Rook(Piece.PieceColorOptions.BLACK, "h8"));

        // Queens
        addPieceToBoard(boardArray, new Queen(Piece.PieceColorOptions.WHITE, "d1"));
        addPieceToBoard(boardArray, new Queen(Piece.PieceColorOptions.BLACK, "d8"));

        // Kings
        addPieceToBoard(boardArray, new King(Piece.PieceColorOptions.WHITE, "e1"));
        addPieceToBoard(boardArray, new King(Piece.PieceColorOptions.BLACK, "e8"));
    }

    public static void addPieceToBoard(Piece[][] boardArray, Piece piece) {
        Coordinate pieceCoordinate;

        pieceCoordinate = piece.getPieceCoordinate();
        boardArray[pieceCoordinate.getPosY()][pieceCoordinate.getPosX()] = piece;
    }

    public static void printBoard(Piece[][] boardArray) {
        Piece piece;

        for (int i = Board.VERTICAL_BOARD_LENGTH - 1; i >= 0; i--) {
            for (int j = 0; j < Board.HORIZONTAL_BOARD_LENGTH; j++) {
                piece = boardArray[i][j];
                if (piece == null) {
                    System.out.print(DEFAULT_PIECE_SYMBOL + " ");
                }
                else {
                    System.out.print(piece.getPieceSymbol() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
