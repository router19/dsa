import java.math.BigInteger;
import java.util.Scanner;

//HandShaking problem
//Scooby and his friends(total n including him) are sitting in circle, Scooby is currently sitting next to a.
//Now as scooby is excited he wants to handsake with all friends and hence changes sit by b.
//How many friends with whom he will able to handsake

//
public class ExcitedScooby {

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);
		
		int t;
		t = in.nextInt();
		BigInteger a,b,n;
		
		while (t-- > 0)
		{
			a = new BigInteger(in.next());
			b = new BigInteger(in.next());
			n = new BigInteger(in.next());
			System.out.println(n.divide(b.gcd(n)));
		}

	}

}
