import java.nio.charset.StandardCharsets;

public class Test {

	public static void main(String ars[]) {
		
		String str = "𝐴";
	    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
	    //printBytes(bytes);      // xe4 xbd xa0  (3 bytes)
	    byte[] bytes1 = {-16, -99, -111, -97};
	    	//{-16, -99, -112, -76};
	    // decode
	    String decodedStr = new String(bytes1, StandardCharsets.UTF_8);
	    System.out.println(decodedStr);
	}
}
