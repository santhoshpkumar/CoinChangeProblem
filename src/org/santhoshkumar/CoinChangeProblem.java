package org.santhoshkumar;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int changeFor = 4;
        CoinChangeProblem c = new CoinChangeProblem();
        c.totalWays(coins,changeFor);
        c.minCoins(coins,changeFor);
    }

    public void totalWays(int[] coins, int changeFor){
        int cols = changeFor;
        int rows = coins.length;

        int[][] matrix = new int[rows+1][cols+1];

        for(int i=0; i <= rows; i++){
            matrix[i][0] = 1;
        }
        for(int i=0; i <= cols; i++){
            matrix[0][i] = 0;
        }

        for(int i=1; i <= rows; i++){
            for(int j=1; j <=cols; j++){
                if(j >= coins[i-1]){
                    matrix[i][j] = (matrix[i-1][j])+(matrix[i][j-coins[i-1]]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        /*
        for(int i=0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        //*/
        System.out.println(matrix[rows][cols]);
    }

    public void minCoins(int[] coins, int changeFor){
        int cols = changeFor;
        int rows = coins.length;

        int[][] matrix = new int[rows+1][cols+1];

        for(int i=0; i <= rows; i++){
            matrix[i][0] = 0;
        }
        for(int i=0; i <= cols; i++){
            matrix[0][i] = Integer.MAX_VALUE-2;
        }

        for(int i=1; i <= rows; i++){
            for(int j=1; j <=cols; j++){
                if(j >= coins[i-1]){
                    matrix[i][j] = Math.min(matrix[i-1][j],1+matrix[i][j-coins[i-1]]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        for(int i=0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
