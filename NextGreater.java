public class Solution {
    public int[] nextGreater(int[] A) {
        int B[] = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            Boolean found = false;
            // System.out.println("A[" + i + "] = " + A[i] + ", i = " + i);
            for (int j = i+1; j < B.length; j++) {
                if (A[j] > A[i]) {
                    B[i] = A[j];
                    found = true;
                    break;
                }
            }
            if (!found)
                B[i] = -1;
            // System.out.println("B[" + i + "] = " + B[i]);
        }
        return B;
    }
}
