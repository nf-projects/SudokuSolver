import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {
    private List<SudokuNumber> numbers;

    /**
    * Generates a new SudokuBoard object using existing values
    * @param board 2d array containing the sudoku board
    */
    public SudokuBoard(int[][] board) {
        numbers = new ArrayList<SudokuNumber>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0) {
                    numbers.add(new SudokuNumber(board[i][j], i, j));
                } else {
                    numbers.add(new SudokuNumber(i, j));
                }
                
            }
        }
    }

    /**
    * Generates a new SudokuBoard object using random values
    */  
    public SudokuBoard() {
        // generate random board

        //min & max for the random number
        //TODO make 0 more likely
        int min = 0; // 0 means empty
        int max = 9;

        numbers = new ArrayList<SudokuNumber>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Random rand = new Random();

                int randomNum = rand.nextInt((max - min) + 1) + min;
                if(randomNum != 0) {
                    numbers.add(new SudokuNumber(randomNum, i, j));
                } else {
                    numbers.add(new SudokuNumber(i, j));
                }
                
            }
        }        
    }
    
    /**
     * Get the SudokuNumber object at the specified row and column
    */
    public SudokuNumber getNumber(int row, int column) {
        for (SudokuNumber num : numbers) {
            if(num.getX() == row && num.getY() == column) {
                return num;
            }
        }
        // couldn't find any
        return null;
    }
    
    /**
    * Format & print the board to console
    * Empty spots are marked as an X
    */ 
    public void printBoard() {
        // for each row
          // for each column
            // print number or X if empty
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (SudokuNumber num : numbers) {
                    if(num.getX() == i && num.getY() == j) {
                        if(num.getEmpty()) {
                            System.out.print("X");
                        } else {
                            System.out.print(num.getNumber());
                        }
                        System.out.print(" ");
                    }
                }
                
            }
            System.out.println("");
        }
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(getNumber(row, column).getEmpty()) {
                    // try numbers 1-9 inclusive
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if(SolveUtils.isValidPlacement(this, row, column, numberToTry)) {
                            // set the number
                            getNumber(row, column).setNumber(numberToTry);
                            
                            if(solve()) {
                                return true;
                            } else {
                                // reset the number
                                getNumber(row, column).setEmpty(true);
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