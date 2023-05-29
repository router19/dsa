import java.util.ArrayList;

public class PermuteString {
	/** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
	String W[] = new String[100];  
	
	static ArrayList<String> permutations = new ArrayList();
    public static void permute(String str, int l, int r) 
    { 
        if (l == r) {
        	//Printing all permutations
            //System.out.println(str);
        	
        	//Getting distinct permutations 
        	if(!permutations.contains(str))
        		permutations.add(str);
        }
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 
  
    /** 
     * Swap Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
  
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abbb";
		permute(s, 0, 3);
		System.out.println(permutations);
	}

}
