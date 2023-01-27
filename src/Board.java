import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Board {
    private static class Cell{
        private char data;
        private final boolean isMutable;
        public Cell(char data, boolean isMutable){
            this.data = data;
            this.isMutable = isMutable;
        }
        @Override
        public String toString(){
            return this.data + "";
        }
    }
    private final Cell[][] board; // Current board state

    public Board(String pathToFile){
        this.board = new Cell[9][9];
        this.readInput(new File(pathToFile));
    }
    private void readInput(File input){
        Scanner reader;
        try {
            reader = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            System.out.println("Exiting.");
            System.exit(1);
            return;
        }
        int i = 0;
        while(reader.hasNext()){
            String line = reader.nextLine();
            line = line.replaceAll(" ","");
            for (int j = 0; j < 9; j++){
                char c = line.charAt(j);
                Cell cell = new Cell(c, c == '0');
                this.board[i][j] = cell;
            }
            i++;
        }
    }

    public boolean place(char digit, int row, int col){
        if (!this.canPlace(digit,row,col)){
            return false;
        }
        this.board[row][col].data = digit;
        return true;
    }
    private boolean canPlace(char digit, int row, int col){
        // Row
        for (int j = 0; j < 9; j++){
            if (this.board[row][j].data == digit){
                return false;
            }
        }
        // Column
        for (int i = 0; i < 9; i++){
            if (this.board[i][col].data == digit){
                return false;
            }
        }
        // Square
        for (int k = (row / 3) * 3; k < (row / 3) * 3 + 3; k++ ){
            for (int l = (col / 3) * 3; l < (col / 3) * 3 + 3; l++){
                if (this.board[k][l].data == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public void remove(int row, int col){
        this.board[row][col].data = '0';
    }
    public boolean isFixed(int row, int col){
        return !this.board[row][col].isMutable;
    }
    public String toString(){
        StringBuilder result= new StringBuilder();
        result.append(" -------------------------------------");
        result.append("\n");
        for(int i = 0; i < 9; i++){
            result.append(" |  ");
            for(int j = 0; j < 9; j++){
                result.append(this.board[i][j]);
                if(j % 3 == 2){
                    result.append("  |  ");
                    continue;
                }
                result.append("  ");
            }
            result.append("\n");
            if(i % 3 == 2){
                result.append(" -------------------------------------");
                result.append("\n");
            }
        }
        return result.toString();
    }

}
