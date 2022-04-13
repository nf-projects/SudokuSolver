public class SudokuItem {
    private boolean isEmpty;
    private int x; // 0-8
    private int y; // 0-8

    public SudokuItem(boolean isEmpty, int x, int y) {
        this.isEmpty = isEmpty;
        this.x = x;
        this.y = y;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }    

    public boolean getEmpty() {
        return isEmpty;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}