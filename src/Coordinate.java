public class Coordinate {

    /* Examples: 'd2', 'e4', 'f8', 'a1' */
    private String chessStringPos;

    /* Constructors */
    public Coordinate(String chessStringPos) {
        setChessStringPos(chessStringPos);
    }

    /* Getters and Setters */
    public String getChessStringPos() {
        return chessStringPos;
    }

    public void setChessStringPos(String chessStringPos) {
        this.chessStringPos = chessStringPos;
    }

}
