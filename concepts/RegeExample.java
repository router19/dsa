import java.io.UnsupportedEncodingException;

 class UnicodeFormatter  {

	   static public String byteToHex(byte b) {
	      // Returns hex String representation of byte b
	      char hexDigit[] = {
	         '0', '1', '2', '3', '4', '5', '6', '7',
	         '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	      };
	      char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
	      return new String(array);
	   }

	   static public String charToHex(char c) {
	      // Returns hex String representation of char c
	      byte hi = (byte) (c >>> 8);
	      byte lo = (byte) (c & 0xff);
	      return byteToHex(hi) + byteToHex(lo);
	   }

	} // class
public class RegeExample {
	public static void printBytes(byte[] array, String name) {
	    for (int k = 0; k < array.length; k++) {
	        System.out.println(name + "[" + k + "] = " + "0x" +
	            UnicodeFormatter.byteToHex(array[k]));
	    }
	}
	
	public static void main(String args[]) {
//		String regex = "\\[[1-9][0-9]*\\]";
//		String s = "[0]!A0";
//		String[] splitted_s = s.split("\\!");
//		System.out.println("String matches -> " +splitted_s[0].matches(regex));
//		char c = '1';
//		int x = (c - '0');
//		int pp=2;
//		System.out.println(x);
//		
//		String s2 = "DDEAUT";
//		String dde_auto = "DDEAUT";
//		System.out.println(s2.indexOf(dde_auto));
//		if(s2.contains(dde_auto))
//		System.out.println(s2.substring(s2.indexOf(dde_auto) + dde_auto.length(), s2.length()).trim());
//		//assert(pp!=2);
//		System.out.println("Not here");
		String s = new String("\uD835\uDC34");
		System.out.println(s);
		
		String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");
		System.out.println(original);
		
		
		try {
		    byte[] utf8Bytes = original.getBytes("UTF8");
		    byte[] defaultBytes = original.getBytes();

		    String roundTrip = new String(utf8Bytes, "UTF8");
		    System.out.println("roundTrip = " + roundTrip);
		    System.out.println();
		    printBytes(utf8Bytes, "utf8Bytes");
		    System.out.println();
		    printBytes(defaultBytes, "defaultBytes");
		} 
		catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}
	}
}
