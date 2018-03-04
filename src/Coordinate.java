public class Coordinate {

    public static final String X_POSITIONS = "abcdefgh";

    /* Examples: 'd2', 'e4', 'f8', 'a1' */
    private String chessStringPos;

    /* Values range from 0 to 7 on a 8-by-8 board */
    private int posX;
    private int posY;

    /* Constructors */
    public Coordinate(String chessStringPos) {
        setChessStringPos(chessStringPos);
    }

    /* Getters and Setters */
    public String getChessStringPos() {
        return chessStringPos;
    }

    public void setChessStringPos(String chessStringPos) {
        /* Check if chessStringPos is in the correct format */
        if (isWithinBoard(chessStringPos)) {
            this.chessStringPos = chessStringPos;
            /* Calculate integer values */
            reCalcChessIntPos();
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    /* Utility Methods */
    private  boolean isWithinBoard(String chessStringPos) {
        if (chessStringPos.length() != 2) {
            return false;
        }

        char tempX, tempY;
        tempX = chessStringPos.charAt(0);
        tempY = chessStringPos.charAt(1);

        if (X_POSITIONS.indexOf(tempX) == -1) {
            return false;
        }

        if (tempY < '1' || tempY > '8') {
            return false;
        }
        return true;
    }

    private void reCalcChessIntPos() {
        this.posX = parsePosX(chessStringPos);
        this.posY = parsePosY(chessStringPos);
    }

    private int parsePosX(String chessStringPos) {
        char xChar = chessStringPos.charAt(0);
        return X_POSITIONS.indexOf(xChar);
    }

    private int parsePosY(String chessStringPos) {
        char yChar = chessStringPos.charAt(1);
        return Character.getNumericValue(yChar) - 1;
    }

}
