public class Solver {
    private final Board board;

    public Solver(Board board){
        this.board = board;
    }
    public boolean solve(int n){
        return this.solveSudoku(n);
    }
    private boolean solveSudoku(int n){
        boolean foundSol = false;
        int row = n / 9;
        int col = n % 9;

        if (n == 81){
            return true;
        }
        if (this.board.isFixed(row,col)){
            return this.solveSudoku(n + 1);
        }
        for (int i = 1; i <= 9; i++){
            char c = (char)(i + 48);

            if (this.board.place(c,row,col)){
                foundSol = this.solveSudoku(n + 1);
            }
            if (foundSol){
                break;
            }
            this.board.remove(row,col);
        }
        return foundSol;
    }
}
