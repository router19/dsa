/*
 Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated
 multiple times and some other elements can be absent from the array. Count frequency of all elements that are 
 present and print the missing elements.

Examples:

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1
 */
class CountFrequency  
{ 
    // Function to find counts of all elements present in 
    // arr[0..n-1]. The array elements must be range from 
    // 1 to n 
    void printfrequency(int arr[], int n)  
    { 
        // Subtract 1 from every element so that the elements 
        // become in range from 0 to n-1 
        for (int j = 0; j < n; j++) 
            arr[j] = arr[j] - 1; 
  
        // Use every element arr[i] as index and add 'n' to 
        // element present at arr[i]%n to keep track of count of 
        // occurrences of arr[i] 
        for (int i = 0; i < n; i++) 
            arr[arr[i] % n] = arr[arr[i] % n] + n; 
  
        // To print counts, simply print the number of times n 
        // was added at index corresponding to every element 
        for (int i = 0; i < n; i++) 
            System.out.println(i + 1 + "->" + arr[i] / n); 
    } 
  
    /*
Algorithm:
1) Initialize i as 0
2) Do following while i < n

   // If this element is already processed,
   // then nothing to do
   a) If arr[i]  > 0)
         (i) arr[i] = arr[elementIndex];

         // After storing arr[elementIndex], change it
         // to store initial count of 'arr[i]'
         (ii) arr[elementIndex] = -1;

     d) else       
            // If this is NOT first occurrence of arr[i],
            // then decrement its count.
          (i) arr[elementIndex]--;

            // And initialize arr[i] as 0 means the element
            // 'i+1' is not seen so far
          (ii) arr[i] = 0;
          (iii) i++;

3) Now -arr[i] stores count of i+1. 
     */
    void findCounts(int arr[], int n)  
    { 
        // Traverse all array elements 
        int i = 0; 
        while (i < n)  
        { 
            // If this element is already processed, 
            // then nothing to do 
            if (arr[i] <= 0)  
            { 
                i++; 
                continue; 
            } 
  
            // Find index corresponding to this element 
            // For example, index for 5 is 4 
            int elementIndex = arr[i] - 1; 
  
            // If the elementIndex has an element that is not 
            // processed yet, then first store that element 
            // to arr[i] so that we don't loose anything. 
            if (arr[elementIndex] > 0)  
            { 
                arr[i] = arr[elementIndex]; 
  
                // After storing arr[elementIndex], change it 
                // to store initial count of 'arr[i]' 
                arr[elementIndex] = -1; 
            }  
            else 
            { 
                // If this is NOT first occurrence of arr[i], 
                // then decrement its count. 
                arr[elementIndex]--; 
  
                // And initialize arr[i] as 0 means the element 
                // 'i+1' is not seen so far 
                arr[i] = 0; 
                i++; 
            } 
        } 
  
        System.out.println("Below are counts of all elements"); 
        for (int j = 0; j < n; j++) 
            System.out.println(j+1 + "->" + Math.abs(arr[j])); 
    } 
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        CountFrequency count = new CountFrequency(); 
        int arr[] = {2, 3, 3, 2, 5}; 
        int n = arr.length; 
        count.printfrequency(arr, n);
        int arr1[] = {2, 3, 3, 2, 5}; 
        int n1 = arr1.length;
        count.findCounts(arr1, n1);
    } 
} 