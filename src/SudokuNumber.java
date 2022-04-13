public class SudokuNumber extends SudokuItem {
    private int number;

    public SudokuNumber(int number, int x, int y) {
        super(false, x, y);
        this.number = number;
    }

    public SudokuNumber(int x, int y) {
        super(true, x, y);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

