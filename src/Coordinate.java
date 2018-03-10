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

    public Coordinate(Coordinate oldCoordinate) {
        setChessStringPos(oldCoordinate.getChessStringPos());
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

    // xIncr moves left and right, yIncr moves down and up
    public int addVals(int xIncr, int yIncr) {
        int tempX, tempY;

        tempX = posX + xIncr;
        tempY = posY + yIncr;
        setPosXY(tempX, tempY);

        // return 1 if posX and posY were incremented and return 0 otherwise
        if (tempX == posX && tempY == posY) {
            return 1;
        }
        else {
            return 0;
        }
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

    public void setPosXY(int posX, int posY) {
        if (isWithinBoard(posX) && isWithinBoard(posY)) {
            this.posX = posX;
            this.posY = posY;
            reCalcChessStrPos();
        }
    }

    private void reCalcChessStrPos() {
        chessStringPos = convertToChessNotation(posX, posY);
    }

    private String convertToChessNotation(int posX, int posY) {
        String tempStringPos = "";
        tempStringPos += X_POSITIONS.charAt(posX);
        tempStringPos += Integer.toString(posY+1);
        return tempStringPos;
    }

    private boolean isWithinBoard(int posVal) {
        if (posVal >= 0 && posVal <= 7) {
            return true;
        }
        return false;
    }

}
