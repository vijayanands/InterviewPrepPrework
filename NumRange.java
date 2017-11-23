public class Solution {
    public int numRange(int[] A, int B, int C) {
        if (A.length == 1) {
            if ((A[0] >= B) && (A[0] <= C))
                return 1;
            else 
                return 0;
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum >= B && sum <= C) count++;
                if(sum > C) break;
            }
        }
        return count;
    }
    
    private void printSequence(int [] A, int i, int j) {
        System.out.print("[");
        for (int k = i; k <=j ; k++)
            System.out.print(A[k] + " ");
        System.out.print("]");
        System.out.println();
    }
}
