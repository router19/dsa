import java.util.ArrayList;
import java.util.List;

public class MunSubsetSumDifference {

    static int minsubsetDifferenceForArray(int arr[], int n)
    {


        /*
        //similar to subset sum problem. here sum is not given
        //we will use range as sum given
        //basically to minimize the subset sum difference S2 - S1, where s1 is smaller
        // s1 = subsets with smaller sums
        s2= subsets with larger sum
        if range is sum of all nums in the given array, then S1 + S2 = range
        hence , we need to minimize S2- S1 , or Range - S1- S1 , or Range - 2 * S1

        Now we need to determine possible values of S1.

        e.g. for array 1,2,7
        range = 10 (sum of subset sum problem ) , n = 3

        so we need to create the subset sum matrix for this first
        and as we need to include all the elements, the last row of the matrix is something we are interested with
        The last row will give for arr of size 3 , what all sums are available

        As shown below
        x  0  1  2  3  4  5  6  7  8  9  10
        0  T  F  F  F  F  F  F  F  F  F  F
        1  T
        2  T
        3  T  T  T  T  F  F  F  T  T  T  T

        row = 3 shows , sums possible for all 3 elements are
        0 -> {}.
        1 -> {1}
        2 -> {2}
        3 -> {1,2}
        7 -> {7}
        8 -> {1,7}
        9 -> {2,7}
        10 -> {1,2,7}

        Now as we are going to take s1 which is lesser than S2, we will create a array from first half
        of the matrix, i.e. for sum <= 5
        hence our final array to chose s1 would be -> {0,1,2,3}

        Now we need to find for all elements in s1 {0,1,2,3}, the min value for Range - 2 * s1

         */
        int range = 0;
     for(int num : arr){
         range += num;
     }

     boolean t[][] = new boolean[n+1][range+1];

     for(int i =0; i < n +1 ; i++){
         t[i][0] = true;

     }

     for(int j=1; j < range + 1 ; j++){
         t[0][j] = false;
     }

     for(int i =1; i < n+1 ; i++){
         for(int j=1; j< range+ 1; j++){
            if(arr[i-1] <= range && j-arr[i-1] >= 0){
                t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
            }
            else
                t[i][j] = t[i-1][j];
         }
     }
     List<Integer> smallerSubset = new ArrayList<>();
     for(int j=0; j< (range +1) /2; j++){
         if(t[n][j])
            smallerSubset.add(j);
     }
     int min = Integer.MAX_VALUE;

     for(int num : smallerSubset)
     {
         min = Math.min(min, range - 2 * num);
     }
     return min;
    }

    public static void main(String[] args) {
        System.out.println(minsubsetDifferenceForArray(new int[]{1,6,11,5},4));
    }
}
