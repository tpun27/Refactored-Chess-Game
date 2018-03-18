# Chess Game (Refactored)
---

## Overview
- A Bite-Sized Commit Tutorial Project
- This project converts [this][original-chess-game-repo] Java Chess repository into a tutorial with step-by-step commits

Project SDK: Java 1.8 (1.8.0_144)

- [Step 0](#step-0)
- [Step 1](#step-1)
- [Step 2](#step-2)
- [Step 3](#step-3)
- [Step 4](#step-4)
- [Step 5](#step-5)
- [Step 6](#step-6)
- [Step 7](#step-7)
- [Step 8](#step-8)
- [Step 9](#step-9)
- [Step 10](#step-10)
- [Step 11](#step-11)
- [Step 12](#step-12)
- [Step 13](#step-13)
- [Step 14](#step-14)
- [Step 15](#step-15)
- [Step 16](#step-16)
- [Step 17](#step-17)
- [Step 18](#step-18)
- [Step 19](#step-19)
- [Step 20](#step-20)
- [Step 21](#step-21)
- [Step 22](#step-22)
- [Step 23](#step-23)

### Step 0
    - Created initial Java Project using IntelliJ
    - Created Chess Piece classes
    - King, Queen, Rook, Bishop, Knight, Pawn extend abstract class Piece

### Step 1
    - Added Unicode constants into each Chess piece symbol
    - Created Enum for piece color
    - Created attributes for Piece color and symbol
    - Added getters/setters for Piece color and symbol, including abstract setPieceSymbol() method
    - Implemented setPieceSymbol() in each subclass

### Step 2
    - Added Coordinate class for piece positioning
    - Coordinate will allow you to interchange string (e.g. 'd4') and integer (e.g. (2, 5)) board positions
    - Added Coordinate attribute to Piece class
    - Modified piece constructors to use pieceColor and pieceStringPos

### Step 3
    - Created Board class with boardArray attribute
    - Created BoardUtility to provide static helper methods
    - Modified Coordinate to dynamically calculate integer board positions (posX and posX) from chessStringPos

### Step 4
    - Added methods to BoardUtility to populate Board's boardArray
    - boardArray is a 2-D array that contains Piece objects
    - The mappings from traditional board notation to the boardArray indices are:
        - <img src="./images/traditional-board-notation.png" width="50%" height="50%">
        - <img src="./images/board-array-mapping.png" width="50%" height="50%">
    - Created PlayChess class to run the program and display the chess board on the console

### Step 5
    - Added method to Board to make Chess moves
    - Updated PlayChess to show an example game

### Step 6
    - Created MoveUtility class to store methods that validate moves
    - Implemented isValidEndpoints() to validate moves solely on piece color
    - Started implementing isValidPath() to check for piece specific movement validation
    - Modified PlayChess to demonstrate isValidEndpoints()

### Step 7
    - Added method isValidKnightMove() to MoveUtility to check for legal start and end Coordinates
    - Added helper methods subtractXCoordinates() and subtractYCoordinates()
    - Continued implementing isValidPath()

### Step 8
    - Added isValidDiagonalPath() to check that two Coordinates form an unobstructed diagonal path
    - Added helper methods to the Coordinate class

### Step 9
    - Added isValidStraightPath() to check that two Coordinates form an unobstructed straight path

### Step 10
    - Made methods in MoveUtility static
    - Implemented isValidKingMove()
    - Modified PlayChess to demonstrate isValidPath()

### Step 11
    - Started implementing isValidPawnMove()
    - In isValidPawnMove(), a check was added to validated 2-space forward moves
    - Added hasMoved attribute to Piece class

### Step 12
    - Continued implementing isValidPawnMove()
    - In isValidPawnMove(), checks were added to validate diagonal moves and 1-space forward moves

### Step 13
    - Created InvalidMoveException and InvalidBoardPositionException classes
    - Created CheckUtility class
    - Added move validation to Board.makeMove() method
    - Implemented PlayChess.move() method to handle exceptions

### Step 14
    - Added methods isMovePossibleWithoutCheck() and isInCheck() to CheckUtility
    - Implemented isMovePossibleWithoutCheck()

### Step 15
    - Implemented isInCheck() and getKingCoordinate()

### Step 16
    - Implemented is isInCheckMate() which uses helper methods isKingMovable() and isCheckBlockable()
    - Implemented isKingMovable()

### Step 17
    - Implemented isCheckBlockable() which determines if a checkmate can be prevented by moving a piece other than the king

### Step 18
    - Implemented isInStaleMate() which calls isMovable()

### Step 19
    - Implemented isMovable() which calls calculateMoves()

### Step 20
    - Implemented calculateMoves()

### Step 21
    - Added check/checkmate validation to Board.makeMove()

### Step 22
    - Overloaded Board.makeMove() to handle castling

### Step 23
    - Created Game class to allow some to play the game!

[original-chess-game-repo]: https://github.com/tpun27/Chess-Game