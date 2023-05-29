
public class AddBinaryStrings {

	static String addBinary(String a, String b) 
    { 
          
        // Initialize result 
        String result = "";  
          
        // Initialize digit sum 
        int s = 0;          
  
        // Traverse both strings starting  
        // from last characters 11 1
        int i = a.length() - 1, j = b.length() - 1; 
        while (i >= 0 || j >= 0 || s == 1) 
        { 
              
            // Compute sum of last  
            // digits and carry 
            s += ((i >= 0)? a.charAt(i) - '0': 0); 
            s += ((j >= 0)? b.charAt(j) - '0': 0); 
  
            // If current digit sum is  
            // 1 or 3, add 1 to result 
            result = s%2 + result; 
  
            // Compute carry 
            s /= 2; 
  
            // Move to next digits 
            i--; j--; 
        } 
          
    return result; 
    } 
	
	/**
	 * Add N binary String
	 * @param a
	 * @return
	 */
	static String addNBinaryString(String a[])
	{
		String result = "";
		for(int i=0;i<a.length;i++)
			result = addBinary(a[i], result);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="1011"; 
		String b = "1";
		
		System.out.println(addBinary(a, b));
		
		String an[] = {"1", "10", "11"};
		System.out.println(addNBinaryString(an));

	}

}
