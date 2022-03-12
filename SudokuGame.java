

public class SudokuGame {

    public static void main(String[] args) {
        UI.main(args);
    }


    // wrapper for recursive method
    public static String solve(Board board) {

        if (!sudokuSolve(board))
            return "Solution not found";
            
        else {
            // System.out.println("A solution was found: ");
            return board.toString();
        }
    }

    // recursive backtrack
    private static boolean sudokuSolve(Board space) {
        int[][] board = space.getBoard();
        int[] spot = space.nextOpenSpot();

        // if no spot is available, nextOpenSpot() rtrns 10,10 if there is no open spot
        if (spot[0] == 10 && spot[1] == 10) {
            return true;
        }

        int y = spot[1];
        int x = spot[0];

        // loop through choices
        for (int j = 1; j <= 9; j++) {
            // checks if numbers if allowed here
            if (isValid(j, x,y,space))  {
                board[x][y] = j;
                if (sudokuSolve(space)) {
                    return true;
                } 

                // backtrack if problem occurs
                board[x][y] = 0;
            }
        }

        
        return false;
    }


    /* Checks three by three square, row 
    and column to see if number is allowed
    at x,y in board
    */
    private static boolean isValid(int number, int x, int y, Board newBoard) {
        int[][] board = newBoard.getBoard();
        // checks if number is valid 
        if (number < 1 || number > 9) {
            return false;
        } 
        // check if it has a number already
        if (board[x][y] != 0){
            return false;
        }
        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == number) {
                return false;
            }
        }
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == number)
                return false;
        }
        // check 3 by 3 square
        if (x >= 3) {
            x = x - (x % 3);
        } else {
            x = 0;
        }
        if (y >= 3) {
            y = y - (y % 3);
        } else {
            y = 0;
        }

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == number) {
                    return false ;
                }
            }
        }

        return true;

    }

}