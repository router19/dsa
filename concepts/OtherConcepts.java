
public class OtherConcepts {

	int j = 1;
	static {
		System.out.println("static block called");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

      /*
       * 1. CONCEPT of final in java 		
      */
		
		//final for primitive type
		final int i = 10;
		
		//below statement give compilation error
		//final variable cannot be re-assigned or modified
		//i = 30;
		
		
		//final for non-primitive type
		//Note  final for non-primitive variables just mean that they cannot be changed to refer to any other object
		//but the members of the referred object can be changed.
		final OtherConcepts o = new OtherConcepts();
		//Works fine , as we are modifying the member not referring to a new object.
		o.j = 10;
		
		//below statement give compilation error
		//o = new OtherConcepts();
		
		
	}

}
