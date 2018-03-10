/**
 * Class for Coordinates not on the Board
 */
public class InvalidBoardPositionException extends Exception {
    public void printErrorMsg() {
        System.out.println("Invalid Board Position!");
    }
}
