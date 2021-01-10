import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TrappedWaterVolumeFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] ip = br.readLine().split(" ");
        int M = Integer.parseInt(ip[0]);
        int N = Integer.parseInt(ip[1]);
        String[] Grid = new String[N];
        for(int i_Grid = 0; i_Grid < N; i_Grid++)
        {
            Grid[i_Grid] = br.readLine();
        }

        long out_ = volume_trapped(M, N, Grid);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static long volume_trapped(int M, int N, String[] Grid){
        char[][] grid = new char[M][N];
        for(int i = 0; i < M; i ++){
            String row = Grid[i];
            for(int j = 0; j < N; j ++){
                grid[i][j] = row.charAt(j);
            }
        }
        int numberOfCellsThatCanHoldWater = 0;
        for(int i = 1; i < M - 1; i ++){
            for(int j = 1; j < N - 1; j ++){
                char currentPos = grid[i][j];
                if(currentPos == 'T'){
                    numberOfCellsThatCanHoldWater++;
                }else if(currentPos == '.'){
                    boolean isUseable = isUsableEmptyCell(i, j, grid, M, N, 'N');
                    if(isUseable){
                        numberOfCellsThatCanHoldWater++;
                    }
                }
            }
        }
        return numberOfCellsThatCanHoldWater;
    }

    static boolean isUsableEmptyCell(int i, int j, char[][] grid, int M, int N, char incomingDir){
        if(i == M - 1 || j == N - 1 || i == 0 || j == 0){
            return false;
        }
        grid[i][j] = 'P';
        boolean isUseable = true;
        char cellAbove = grid[i-1][j];
        if(cellAbove == 'F' && incomingDir != 'U'){
            return false;
        }else if(cellAbove == '.' && incomingDir != 'U'){
            isUseable = isUsableEmptyCell( i-1,  j,  grid,  M,  N, 'B');
            if(isUseable){
                grid[i-1][j] = 'T';
            }else{
                grid[i-1][j] = 'F';
                grid[i][j] = 'F';
                return false;
            }
        }
        char cellBelow = grid[i+1][j];
        if(cellBelow == 'F' && incomingDir != 'B'){
            return false;
        }else if(cellBelow == '.' && incomingDir != 'B'){
            isUseable = isUsableEmptyCell( i+1,  j, grid,  M,  N, 'U');
            if(isUseable){
                grid[i+1][j] = 'T';
            }else{
                grid[i+1][j] = 'F';
                grid[i][j] = 'F';
                return false;
            }
        }
        char cellRight = grid[i][j+1];
        if(cellRight == 'F' && incomingDir != 'R'){
            return false;
        }else if(cellRight == '.' && incomingDir != 'R'){
            isUseable = isUsableEmptyCell( i,  j + 1, grid,  M,  N, 'L');
            if(isUseable){
                grid[i][j+1] = 'T';
            }else{
                grid[i][j+1] = 'F';
                grid[i][j] = 'F';
                return false;
            }
        }
        char cellLeft = grid[i][j-1];
        if(cellLeft == 'F' && incomingDir != 'L'){
            return false;
        }else if(cellLeft == '.' && incomingDir != 'L'){
            isUseable = isUsableEmptyCell( i,  j - 1, grid,  M,  N, 'R');
            if(isUseable){
                grid[i][j-1] = 'T';
            }else{
                grid[i][j-1] = 'F';
                grid[i][j] = 'F';
                return false;
            }
        }
        grid[i][j] = 'T';
        return true;
    }
}