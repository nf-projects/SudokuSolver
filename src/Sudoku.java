public class Sudoku {
    public static void main(String[] args) {
        // 0 means blank
        int[][] boardsetup = {
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

        SudokuBoard board = new SudokuBoard(boardsetup);
        board.printBoard();
        System.out.println("\n");
        //System.out.println(SolveUtils.isValidPlacement(board, 7, 7, 4));
        System.out.println("Solving Board...\n");
        board.solve();
        board.printBoard();
    }
}