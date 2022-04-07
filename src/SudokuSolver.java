public class SudokuSolver {
    public static void main(String[] args) {
 
        // 0 means blank
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3} 
          };

          if(solveBoard(board)) {
              System.out.println("Solved the board!");
              System.out.println("The board is:");
              printBoard(board);
          } else {
              System.out.print("Unsolveable");
          }
    }

    // a method that prints out a 2 dimensional int array
    public static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == number) {
                return true;
            } 
        }
        return false;
    }
    
    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < 9; i++) {
            if(board[i][column] == number) {
                return true;
            } 
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        // gets the row & column of the top left corner of the given box
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if(board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column) && !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int column = 0; column < 9; column++) {
                if(board[row][column] == 0) {
                    for(int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if(isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            // recursion: for each number to try, try to solve the board using that number
                            // if it doesn't work, the sudoku can't be completed using that number --> don't use that number
                            if(solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
