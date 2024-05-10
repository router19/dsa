import java.util.ArrayList;

public class MaximumSumSubArray {

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        // code here

        int i=0,j=0;
        long currSum=0,maxSum=0;
        while(j < N){
            currSum += ((Integer)Arr.get(j)).longValue();
            if(j-i + 1 < K){
                j++;
            }
            else{
                maxSum = Math.max(maxSum,currSum);
                currSum -= ((Integer)Arr.get(i)).longValue();
                i++;
                j++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
