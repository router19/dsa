
public class Concepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("testing string builder class");
		System.out.println(sb.substring(0, sb.length()));
		sb.delete(0, 7);
		System.out.println(sb.toString());
	}

}
