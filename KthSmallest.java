public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int[] smallestArray;
    public int kthsmallest(final int[] A, int B) {
        if ((B < 0) || (B > A.length))
            System.out.println("Invalid Input. k out of range");
        smallestArray = new int[B];
        for (int i = 0; i < B; i++)
            smallestArray[i] = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            // printSmallestArray(B);
            // System.out.println("current int : " + A[i]);
            if (A[i] < smallestArray[B-1]) {
                insertIntoSmallestArray(A[i], B);
            }
        }
        return smallestArray[B-1];
    }
    
    private void printSmallestArray(int B) {
        for (int i = 0; i < B; i++) {
            System.out.print(smallestArray[i] + " ");
        }
        System.out.println();
    }
    
    private void insertIntoSmallestArray(int val, int B) {
        for (int i = 0; i < B; i++) {
            if (val <= smallestArray[i]) {
                int tmp = smallestArray[i];
                smallestArray[i] = val;
                val = tmp;
            }
        }
    }
}
