import java.util.Scanner;
/**
 * Class for Chess Game
 */
public class Game {
    private Board chessBoard;

    public Game() {
        chessBoard = new Board();
    }

    public void startGameLoop() {
        char inputChar, castleChar;
        String initialCoordinate, finalCoordinate;

        inputChar = '?';
        while (inputChar != 'Q') {
            System.out.println("Your options are: 'M', 'C', 'P', and 'Q'");
            System.out.println("For Move, Castle, Print Board, and Quit\n");
            inputChar = getPlayerInput();

            switch (inputChar) {
                case 'M':
                    System.out.println("***All moves must use 2-character Chess Coordinates***");
                    System.out.println("***The first character is a letter from a to h***");
                    System.out.println("***The second character is an integer from 1 to 8:***");
                    System.out.println("*EXAMPLES: e2, d3, f6, a1, h8*\n");
                    initialCoordinate = getInputCoordinate("CURRENT");
                    finalCoordinate = getInputCoordinate("DESTINATION");
                    makeMove(chessBoard, initialCoordinate, finalCoordinate);
                    break;
                case 'C':
                    castleChar = getCastleChar();
                    if (castleChar == 'K') {
                        makeMove("O-O");
                    }
                    else {
                        makeMove("O-O-O");
                    }
                    break;
                case 'P':
                    printBoard();
                    break;
                case 'Q':
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("*** Invalid Input! ***");
                    break;
            }
        }
    }

    public void makeMove(Board board, String initialPos, String newPos) {
        try {
            board.makeMove(initialPos, newPos);
            BoardUtility.printBoard(chessBoard.getBoardArray());
        } catch (InvalidBoardPositionException e) {
            e.printErrorMsg();
        } catch (InvalidMoveException e) {
            e.printErrorMsg();
        }
    }

    public void makeMove(String castleString) {
        try {
            chessBoard.makeMove(castleString);
            BoardUtility.printBoard(chessBoard.getBoardArray());
        } catch (InvalidMoveException e) {
            e.printErrorMsg();
        }
    }

    public void printBoard() {
        BoardUtility.printBoard(chessBoard.getBoardArray());
    }

    protected char getPlayerInput() {
        char optionChar;
        Scanner moveScanner = new Scanner(System.in);

        while (true) {
            System.out.println("What Would You Like To Do? ('M', 'C', 'P', or 'Q')");
            optionChar = moveScanner.next().charAt(0);
            if (optionChar == 'M' || optionChar == 'C' || optionChar == 'P' || optionChar == 'I' || optionChar == 'Q') {
                break;
            }
        }
        return optionChar;
    }

    protected String getInputCoordinate(String queryString) {
        String moveString;
        char tempChar;
        Scanner inputScanner = new Scanner(System.in);
        boolean inputValid;

        moveString = "";
        inputValid = false;

        while (!inputValid) {
            System.out.println("Enter The " + queryString + " Coordinate Of The Piece You Wish To Move:");
            moveString = inputScanner.nextLine();
            if (moveString.length() != 2) {
                System.out.println("*** INVALID COORDINATE LENGTH ***");
                continue;
            }

            tempChar = moveString.charAt(0);
            if (tempChar < 'a' || tempChar > 'h') {
                System.out.println("*** INVALID FIRST CHARACTER ***");
                continue;
            }

            tempChar = moveString.charAt(1);
            if (tempChar < '1' || tempChar > '8') {
                System.out.println("*** INVALID SECOND CHARACTER ***");
                continue;
            }
            inputValid = true;
        }
        return moveString;
    }

    protected char getCastleChar() {
        char optionChar;
        Scanner moveScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 'K' to castle King-side or 'Q' to castle Queen-side");
            optionChar = moveScanner.next().charAt(0);
            if (optionChar == 'K' || optionChar == 'Q') {
                break;
            }
        }
        return optionChar;
    }
}
