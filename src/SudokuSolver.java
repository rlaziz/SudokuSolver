public class SudokuSolver {
    public static void main(String[] args){
        Board board;
        System.out.println("sample1.txt Sudoku Solution: ");
        board = new Board("src/sample1.txt");

        Solver s = new Solver(board);

        // s.solve(int n) - main method that solves the sudoku using backtracking, returns true if the sudoku is solvable

        System.out.println("sample1.txt initial");
        System.out.println(board);
        System.out.println("solvable - " + s.solve(0));
        System.out.println("sample1.txt solved");
        System.out.println(board);

        System.out.println("----------------------------------------");

        board = new Board("src/sample2.txt"); // Second Sample Solution
        s = new Solver(board);

        System.out.println("sample2.txt initial");
        System.out.println(board);
        System.out.println("solvable - " + s.solve(0));
        System.out.println("sample2.txt solved");
        System.out.println(board);

        System.out.println("----------------------------------------");

        board = new Board("src/noSolution.txt");
        s = new Solver(board);

        System.out.println("noSolution.txt initial");
        System.out.println(board);
        System.out.println("solvable - " + s.solve(0));
        System.out.println("noSolution.txt solved");
        System.out.println(board);
    }
}
