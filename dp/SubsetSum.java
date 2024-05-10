//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

/*
Given a set of size n, determine if a subset exists whose sum is given sum
 */


public class SubsetSum {
    static boolean subSetExists(int[] arr, int sum){
        int n = arr.length;
        boolean t[][] = new boolean[n + 1][sum + 1];

        //Initialize the matrix
        //for sum =0, there is always an empty suvset
        //x asix repsent sums
        //y axis represent index of the array
        for(int i=0;i< n+1; i++){
            t[i][0]= true;
        }

        for(int j = 1; j < sum+1; j++){
            t[0][j] = false;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i-1] <= sum && j >= arr[i-1])
                {
                    try {
                        t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                    }catch (Exception e){
                        System.out.println("i -> "+ i + " j -> " + j);
                    }
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }




    public static void main(String[] args) {
        System.out.println(subSetExists(new int[]{1,2,7}, 10));
    }
}
