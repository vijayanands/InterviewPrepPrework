public class Solution {
    static HashMap<Integer,Integer> setOfNumbers = new HashMap<Integer,Integer>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    static int[][] permuteArray = null;
    
    public int[][] permute(int[] A) {
        int arraySize = A.length;
        setOfNumbers.clear();
        result.clear();
        
        for (int i = 0; i < arraySize; i++) {
            if (setOfNumbers.containsKey(A[i])) {
                int value = setOfNumbers.get(A[i]);
                setOfNumbers.put(A[i], value + 1);
            } else {
                setOfNumbers.put(A[i], 1);
            }
        }
        
        // System.out.println("Set of Number size : " + setOfNumbers.size());
        int [] oneResult = new int[arraySize];
        int position = 0;
        
        fillPosition(arraySize, position, oneResult);
        
        int noOfPermutations = result.size();
        permuteArray = new int[noOfPermutations][A.length];
        populatePermuteArray(noOfPermutations, arraySize);
        // printPermuteArray(noOfPermutations, arraySize);
        return permuteArray;
    }
    
    private void populatePermuteArray(int noOfPermutations, int arraySize) {
        for (int i = 0 ; i < noOfPermutations; i++) {
            for (int j = 0; j < arraySize; j++) {
                permuteArray[i][j] = (result.get(i)).get(j);
                // System.out.println("(" + i + "," + j + ") :" + result.get(i).get(j));
                // System.out.println("(" + i + "," + j + ") :" + permuteArray[i][j]);

            }
        }
    }
    
    private void printPermuteArray(int noOfPermutations, int arraySize) {
        System.out.println("printing array");
        for (int i = 0; i < noOfPermutations; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(permuteArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("end printing");
    }
    
    private void fillPosition(int arraySize, int position, int[] oneResult) {
        // System.out.println("fillPosition : " + position);
        if (position == arraySize) {
            // System.out.println("add result");
            addResult(oneResult);
        } else {
            Set set = this.setOfNumbers.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                int key = (int) mentry.getKey();
                int value = (int) mentry.getValue();
                if (value > 0) {
                    oneResult[position] = key;
                    setOfNumbers.put(key, value - 1);
                    fillPosition(arraySize, position+1, oneResult);
                    setOfNumbers.put(key, value);
                }
            }
        }
    }
    
    private void addResult(int[] oneResult) {
        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        for (int i = 0; i < oneResult.length; i++) {
            // System.out.print(oneResult[i] + " ");
            resultArray.add(oneResult[i]);
        }
        // System.out.println();
        result.add(resultArray);
    }
}
