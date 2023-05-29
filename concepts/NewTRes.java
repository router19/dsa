import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class NewTRes {

public static void main(String arp[])
{
	//String str = "𝐴";
    //byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
    //printBytes(bytes);      // xe4 xbd xa0  (3 bytes)
    byte[] bytes1 = {-16, -99, -111, -97};
    	//{-16, -99, -112, -76};
    // decode
    String decodedStr = new String(bytes1, StandardCharsets.UTF_8);
    System.out.println(decodedStr);
    
    try {
		byte[] byte2 =decodedStr.getBytes("UTF-8");
		System.out.println("TEST    "+new String(byte2,StandardCharsets.UTF_8));
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    CharBuffer buffer = CharBuffer.allocate(decodedStr.length());
    buffer.put(decodedStr);
    //    System.out.println(System.getProperty("java.version"));
//    System.out.println("CharBuffer is "+buffer.);
    
    try {
        
        // Returns a charset object for the named charset.
        Charset charset = Charset.forName("UTF-8");
         
        // Constructs a new decoder for this charset.
        CharsetDecoder decoder = charset.newDecoder();
         
        // Constructs a new encoder for this charset.
        CharsetEncoder encoder = charset.newEncoder();
         
        // Wrap the character sequence into a buffer.
        CharBuffer uCharBuffer = CharBuffer.wrap("𝐴");
         
        // Encode the remaining content of a single input character buffer to a new byte buffer.
        // Converts to ISO-8859-1 bytes and stores them to the byte buffer
        ByteBuffer bbuf = encoder.encode(uCharBuffer);
         
        // Decode the remaining content of a single input byte buffer to a new character buffer.
        // Converts from ISO-8859-1 bytes and stores them to the character buffer
        CharBuffer cbuf = decoder.decode(bbuf);
        System.out.println(cbuf.toString()); 
        String s = cbuf.toString();
        System.out.println("Original String is: " + s);
         
    }
    catch (CharacterCodingException e) {
        System.out.println("Character Coding Error: " + e.getMessage());
    }
}
}
