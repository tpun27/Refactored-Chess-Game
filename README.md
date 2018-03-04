Chess-Game-Refactored
- A Bite-Sized Commit Tutorial Project

Project SDK: Java 1.8 (1.8.0_144)

- Step 0
    - Created initial Java Project using IntelliJ
    - Created Chess Piece classes
    - King, Queen, Rook, Bishop, Knight, Pawn extend abstract class Piece

- Step 1
    - Added Unicode constants into each Chess piece symbol
    - Created Enum for piece color
    - Created attributes for Piece color and symbol
    - Added getters/setters for Piece color and symbol, including abstract setPieceSymbol() method
    - Implemented setPieceSymbol() in each subclass

- Step 2
    - Added Coordinate class for piece positioning
    - Coordinate will allow you to interchange string (e.g. 'd4') and integer (e.g. (2, 5)) board positions
    - Added Coordinate attribute to Piece class
    - Modified piece constructors to use pieceColor and pieceStringPos

- Step 3
    - Created Board class with boardArray attribute
    - Created BoardUtility to provide static helper methods
    - Modified Coordinate to dynamically calculate integer board positions (posX and posX) from chessStringPos

- Step 4
    - Added methods to BoardUtility to populate Board's boardArray
    - boardArray is a 2-D array that contains Piece objects
    - The mappings from traditional board notation to the boardArray indices are:
        - <img src="./images/traditional-board-notation.png" width="50%" height="50%">
        - <img src="./images/board-array-mapping.png" width="50%" height="50%">
    - Created PlayChess class to run the program and display the chess board on the console

- Step 5
    - Added method to Board to make Chess moves
    - Updated PlayChess to show an example game