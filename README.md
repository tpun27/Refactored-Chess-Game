# Chess Game (Refactored)

## Overview
- A Bite-Sized Commit Tutorial Project
- This project converts [this][original-chess-game-repo] Java Chess repository into a tutorial with step-by-step commits.

**Project SDK**: Java 1.8 (1.8.0_144)

- [Step 0 - Piece Creation](#step-0)
- [Step 1 - Piece Symbols & Colors](#step-1)
- [Step 2 - Piece Constructor Implementation & Coordinate Positions](#step-2)
- [Step 3 - Chess Board Array & Coordinate Validation](#step-3)
- [Step 4 - Initialize Board Pieces](#step-4)
- [Step 5 - Piece Movement & Example Game](#step-5)
- [Step 6 - Checking Valid Moves Based On Start & End Positions](#step-6)
- [Step 7 - Checking For Valid Knight Moves](#step-7)
- [Step 8 - Checking For Valid Diagonal Moves](#step-8)
- [Step 9 - Checking For Valid Vertical/Horizontal Moves](#step-9)
- [Step 10 - Checking For Valid King Moves](#step-10)
- [Step 11 - Checking For Valid Pawn Moves (2-Space Forward Moves)](#step-11)
- [Step 12 - Checking For Valid Pawn Moves (1-Space Forward & Diagonal Moves)](#step-12)
- [Step 13 - Exception Handling For Invalid Moves](#step-13)
- [Step 14 - Verifying That Moves Are Valid Based On Whether Or Not King Is In Check](#step-14)
- [Step 15 - Determining Whether Or Not King Is In Check](#step-15)
- [Step 16 - Determining Whether Or Not King Is In Checkmate](#step-16)
- [Step 17 - Determining Whether Or Not Check Is Blockable](#step-17)
- [Step 18 - Determining Whether Or Not A Stalemate Has Occured](#step-18)
- [Step 19 - Determining Whether Or Not Any Pieces Are Moveable For Stalemate](#step-19)
- [Step 20 - Calculating Possible Moves](#step-20)
- [Step 21 - Adding Check, Checkmate, & Stalemate Verification To Movement Method](#step-21)
- [Step 22 - Castling](#step-22)
- [Step 23 - Making The Game Playable](#step-23)

## Commits / Tutorial Outline

You can check out any point of the tutorial using:

```
git checkout step-?
```

To see the changes made between any two lessons use the `git diff` command:

```
git diff step-?..step-?

```

## Steps

### Step 0 - Piece Creation [Diff][diff-0]


    - Reset Instructions: git checkout -f step-0
    - Created initial Java Project using IntelliJ
    - Created Chess Piece classes
    - King, Queen, Rook, Bishop, Knight, Pawn extend abstract class Piece
    - **Keywords**: class, abstract, extends

### Step 1 - Piece Symbols & Colors
    - Added Unicode constants into each Chess piece symbol
    - Created Enum for piece color
    - Created attributes for Piece color and symbol
    - Added getters/setters for Piece color and symbol, including abstract setPieceSymbol() method
    - Implemented setPieceSymbol() in each subclass
    - **Keywords**: enum, static, final, void, protected, attribute, method, getter, setter

### Step 2 - Piece Constructor Implementation & Coordinate Positions
    - Added Coordinate class for piece positioning
    - Coordinate will allow you to interchange string (e.g. 'd4') and integer (e.g. (2, 5)) board positions
    - Added Coordinate attribute to Piece class
    - Modified piece constructors to use pieceColor and pieceStringPos
    - **Keywords**: constructor, super

### Step 3 - Chess Board Array & Coordinate Validation
    - Created Board class with boardArray attribute
    - Created BoardUtility to provide static helper methods
    - Modified Coordinate to dynamically calculate integer board positions (posX and posX) from chessStringPos

### Step 4 - Initialize Board Pieces
    - Added methods to BoardUtility to populate Board's boardArray
    - boardArray is a 2-D array that contains Piece objects
    - The mappings from traditional board notation to the boardArray indices are:
        - <img src="./images/traditional-board-notation.png" width="50%" height="50%">
        - <img src="./images/board-array-mapping.png" width="50%" height="50%">
    - Created PlayChess class to run the program and display the chess board on the console

### Step 5 - Piece Movement & Example Game
    - Added method to Board to make Chess moves
    - Updated PlayChess to show an example game

### Step 6 - Checking Valid Moves Based On Start & End Positions
    - Created MoveUtility class to store methods that validate moves
    - Implemented isValidEndpoints() to validate moves solely on piece color
    - Started implementing isValidPath() to check for piece specific movement validation
    - Modified PlayChess to demonstrate isValidEndpoints()

### Step 7 - Checking For Valid Knight Moves
    - Added method isValidKnightMove() to MoveUtility to check for legal start and end Coordinates
    - Added helper methods subtractXCoordinates() and subtractYCoordinates()
    - Continued implementing isValidPath()

### Step 8 - Checking For Valid Diagonal Moves
    - Added isValidDiagonalPath() to check that two Coordinates form an unobstructed diagonal path
    - Added helper methods to the Coordinate class

### Step 9 - Checking For Valid Vertical/Horizontal Moves
    - Added isValidStraightPath() to check that two Coordinates form an unobstructed straight path

### Step 10 - Checking For Valid King Moves
    - Made methods in MoveUtility static
    - Implemented isValidKingMove()
    - Modified PlayChess to demonstrate isValidPath()

### Step 11 - Checking For Valid Pawn Moves (2-Space Forward Moves)
    - Started implementing isValidPawnMove()
    - In isValidPawnMove(), a check was added to validated 2-space forward moves
    - Added hasMoved attribute to Piece class

### Step 12 - Checking For Valid Pawn Moves (1-Space Forward & Diagonal Moves)
    - Continued implementing isValidPawnMove()
    - In isValidPawnMove(), checks were added to validate diagonal moves and 1-space forward moves

### Step 13 - Exception Handling For Invalid Moves
    - Created InvalidMoveException and InvalidBoardPositionException classes
    - Created CheckUtility class
    - Added move validation to Board.makeMove() method
    - Implemented PlayChess.move() method to handle exceptions

### Step 14 - Verifying That Moves Are Valid Based On Whether Or Not King Is In Check
    - Added methods isMovePossibleWithoutCheck() and isInCheck() to CheckUtility
    - Implemented isMovePossibleWithoutCheck()

### Step 15 - Determining Whether Or Not King Is In Check
    - Implemented isInCheck() and getKingCoordinate()

### Step 16 - Determining Whether Or Not King Is In Checkmate
    - Implemented is isInCheckMate() which uses helper methods isKingMovable() and isCheckBlockable()
    - Implemented isKingMovable()

### Step 17 - Determining Whether Or Not Check Is Blockable
    - Implemented isCheckBlockable() which determines if a checkmate can be prevented by moving a piece other than the king

### Step 18 - Determining Whether Or Not A Stalemate Has Occured
    - Implemented isInStaleMate() which calls isMovable()

### Step 19 - Determining Whether Or Not Any Pieces Are Moveable For Stalemate
    - Implemented isMovable() which calls calculateMoves()

### Step 20 - Calculating Possible Moves
    - Implemented calculateMoves()

### Step 21 - Adding Check, Checkmate, & Stalemate Verification To Movement Method
    - Added check/checkmate validation to Board.makeMove()

### Step 22 - Castling
    - Overloaded Board.makeMove() to handle castling

### Step 23 - Making The Game Playable
    - Created Game class to allow some to play the game!

[original-chess-game-repo]: https://github.com/tpun27/Chess-Game
[diff-0]: https://github.com/tpun27/Refactored-Chess-Game/commit/0425b8d35fdd462fdea25d19fef104774ee72a28