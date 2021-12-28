package com.hb.ds.dp;

import java.util.Arrays;

public class MaximalSquare {
    int[][] mem=null;
    int maxSquare=0;
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalSquare ms1=new MaximalSquare();
        int result=ms1.maxSquare(matrix);
        System.out.println("Result= "+result);
    }

    public int maxSquare(char[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        mem=new int[rows+1][cols+1];

        for (int i=0;i<rows;i++){
            mem[i][0]=0;
        }
        for (int i=0;i<cols;i++){
            mem[0][i]=0;
        }
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=cols;j++){
                dp(matrix,i,j);
            }
        }
        return maxSquare;
    }
    public void dp(char[][] matrix,int i,int j){

        if(matrix[i-1][j-1]=='0'){
            mem[i][j]=0;
        }else{
            mem[i][j]=1+Math.min(Math.min(mem[i-1][j],mem[i][j-1]),mem[i-1][j-1]);
            if(mem[i][j]> maxSquare){
                maxSquare=mem[i][j];
            }
        }
    }
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) {
            return 0;
        }
        int maxSquareLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int currentSqLen = 1;
                    boolean bool = true;
                    while (i + currentSqLen < rows && j + currentSqLen < cols && bool) {
                        int tillTheRow=i+currentSqLen;
                        int tillTheColumn=j+currentSqLen;

                        for (int k = j; k <= j + currentSqLen; k++) {
                            if (matrix[tillTheRow][k] == '0') {
                                bool = false;
                                break;
                            }
                        }
                        for (int l = i; l <= i + currentSqLen; l++) {
                            if (matrix[l][tillTheColumn] == '0') {
                                bool = false;
                                break;
                            }
                        }
                        if (bool) {
                            currentSqLen++;
                        }

                    }
                    if (currentSqLen > maxSquareLen) {
                        maxSquareLen = currentSqLen;
                    }
                }
            }
        }
        return maxSquareLen * maxSquareLen;
    }
}
