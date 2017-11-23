public class Solution {
    public int[][] prettyPrint(int A) {
        if (A < 0) {
            System.out.println("Invalid Input : Assume the input is out of range");
        } else if (A == 0) {
            System.out.println("Invalid input format OR invalid test case.");
        } else {
            int sizeOfArray = 2*A - 1;
            int returnArray[][] = new int[sizeOfArray][sizeOfArray];
            int T = 0;
            int B = sizeOfArray - 1;
            int L = 0;
            int R = sizeOfArray - 1;
        
            for (int i=A; i>=1; i--) {
                for (int j = L; j <= R; j++) {
                    // System.out.println("(" + T + "," + j + "):" + i);
                    // System.out.println("(" + B + "," + j + "):" + i);
                    returnArray[T][j] = i;
                    returnArray[B][j] = i;
                }
                for (int j = T+1; j <= B-1; j++) {
                    // System.out.println("(" + j + "," + L + "):" + i);
                    // System.out.println("(" + j + "," + R + "):" + i);
                    returnArray[j][L] = i;
                    returnArray[j][R] = i;
                }
                T++;
                B--;
                L++;
                R--;
            }
            return returnArray;
        }
        return null;
    }
}
