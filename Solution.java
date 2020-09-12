import java.util.*;

public class Solution{

    // brute forced
    // runtime O(N^2)
    public int[] twoSum(int[] array, int target){
        int[] result = {-1, -1};

        for(int i=0; i<array.length; i++){
            for(int j = i+1; j < array.length; j++){

                if( (array[i] + array[j]) == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // checks for diff i.e. target - array[i]
    // runtime O(N)
    // to search/look-up and insert in HashMap is O(1)
    public int[] twoSumH(int[] array, int target){

        int[] result = {-1, -1};

        HashMap<Integer, Integer>  set = new HashMap<Integer, Integer>();

        for(int i=0; i < array.length; i++){

            // if map contains the diff?
            if(set.containsKey(target - array[i]) && set.get(target - array[i]) != i){
                result[0] = set.get(target - array[i]);
                result[1] = i;
                break;
            }
            // use elements as "keys" and indices as "values"
            // will be easier to use HashMap.get(<key>) method to return "value"
            // much harder to use "value" to return "key"
            set.put( array[i], i);
        }
        return result;
    }


    // prints the solution in this format: [ x, y ]
    // x == index of first value
    // y == index of second value
    public void printSolution(int[] result){

        Boolean once = true;

        for(int i=0; i<result.length; i++){
            if(result[i] == -1){
                System.out.println("-1");
                return;
            }

            if(once){
                System.out.print("[");
                once = false;
            }
            System.out.print(result[i]);

            if(i != result.length -1 ){
                System.out.print(", ");
            }

        }

        System.out.print("]\n");
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test1 = {2, 12, 8, 7}; //[0,3]
        s.printSolution(s.twoSumH(test1, 9));

        int[] test2 = {2, 7, 11, 15}; //[0,1]
        s.printSolution(s.twoSumH(test2, 9));

        int[] test3 = {3, 2, 4}; //[1,2]
        s.printSolution(s.twoSumH(test3, 6));

        int[] test4 = {3, 3}; //[0,1]
        s.printSolution(s.twoSumH(test4, 6));

        int[] test5 = {0, 0}; //[-1,-1]
        s.printSolution(s.twoSumH(test5, 6));

        int[] test6 = {0}; //[-1,-1]
        s.printSolution(s.twoSumH(test6, 6));
    }
}