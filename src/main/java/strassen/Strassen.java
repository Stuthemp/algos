package strassen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * todo Document type Strassen
 */
public class Strassen {

    public int[][] iteration(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int[][] result = new int[n][n];

        if(n == 1)
            return new int[][] {{arr1[0][0]*arr2[0][0]}};

        int[][] A = new int[n/2][n/2];
        int[][] B = new int[n/2][n/2];
        int[][] C = new int[n/2][n/2];
        int[][] D = new int[n/2][n/2];

        int[][] E = new int[n/2][n/2];
        int[][] F = new int[n/2][n/2];
        int[][] G = new int[n/2][n/2];
        int[][] H = new int[n/2][n/2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i < n/2 && j < n/2) {
                    A[i][j] =arr1[i][j];
                    E[i][j] =arr2[i][j];
                }
                if(i < n/2 && j >= n/2) {
                    B[i][j-n/2] = arr1[i][j];
                    F[i][j-n/2] = arr2[i][j];
                }
                if(i >= n/2 && j < n/2) {
                    C[i-n/2][j] = arr1[i][j];
                    G[i-n/2][j] = arr2[i][j];
                }
                if(i >= n/2 && j >= n/2) {
                    D[i-n/2][j-n/2] = arr1[i][j];
                    H[i-n/2][j-n/2] = arr2[i][j];
                }
            }
        }

        int[][] P1 = iteration(A,subMatrix(F,H));
        int[][] P2 = iteration(sumMatrix(A,B),H);
        int[][] P3 = iteration(sumMatrix(C,D),E);
        int[][] P4 = iteration(D,subMatrix(G,E));
        int[][] P5 = iteration(sumMatrix(A,D),sumMatrix(E,H));
        int[][] P6 = iteration(subMatrix(B,D),sumMatrix(G,H));
        int[][] P7 = iteration(subMatrix(A,C),sumMatrix(E,F));

        int[][] firstQuater = sumMatrix(subMatrix(sumMatrix(P5,P4),P2),P6);
        int[][] secondQuater = sumMatrix(P1,P2);
        int[][] thirdQuater = sumMatrix(P3,P4);
        int[][] fourthQuater = subMatrix(subMatrix(sumMatrix(P1,P5),P3),P7);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i < n/2 && j < n/2) {
                    result[i][j] = firstQuater[i][j];
                }
                if(i < n/2 && j >= n/2) {
                    result[i][j] = secondQuater[i][j-n/2];
                }
                if(i >= n/2 && j < n/2) {
                    result[i][j] = thirdQuater[i-n/2][j];
                }
                if(i >= n/2 && j >= n/2) {
                    result[i][j] = fourthQuater[i-n/2][j-n/2];
                }
            }
        }

        return result;
    }

    private int[][] sumMatrix(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return res;
    }

    private int[][] subMatrix(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                res[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return res;
    }

}
