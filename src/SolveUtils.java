public class SolveUtils {

    public static boolean isValidPlacement(SudokuBoard board, int row, int column, int number) {
        if(isValidRow(board, row, number) && isValidColumn(board, column, number) && isValidSquare(board, row, column, number)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidRow(SudokuBoard board, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board.getNumber(row, i).getNumber() == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumn(SudokuBoard board, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (board.getNumber(i, column).getNumber() == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSquare(SudokuBoard board, int row, int column, int number) {
        int rowStart = row - (row % 3);
        int columnStart = column - (column % 3);

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                // loop through the square
                if (board.getNumber(i, j).getNumber() == number) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
