public class Board {
    // 9 by 9 board with nums from 1-9
    // 0 would mean empty 
    private int[][] board;

    public Board() {
        this.board = new int[9][9];
    }

    // method to set board to any 9 by 9 array
    public void setBoard(int[][] newBoard) {
        if (newBoard.length != 9)
            throw new IllegalStateException("Board is not a valid board.");
        this.board = newBoard;
    }
    // returns board
    public int[][] getBoard() {
        return this.board;
    }

    // string version of board
    public String toString() {
        String s = "";

        // traverse the array and print elements
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                s += board[i][j] + " ";
            }
            s += System.lineSeparator();
        }

        return s;
    }

    // checks if column is filled
    public boolean isColFilled(int col) {
        // traverse through column and rtrn false if there is a 0
        for (int i = 0; i < 9; i++) {
            if (this.board[i][col] != 0) {
                return false;
            }
        }

        return true;
    }

    // traverses the array and returns first element w/ 0
    public int[] nextOpenSpot() {
        int [] openSpot = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.board[j][i] == 0) {
                    openSpot[0] = j;
                    openSpot[1] = i;
                    return openSpot;
                }
            }
        }
        int[] defaultt = {10,10};
        return defaultt;
    }

    
}