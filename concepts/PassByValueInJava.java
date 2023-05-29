
public class PassByValueInJava {

	public int j ;
	
	void changeValueOfJ(PassByValueInJava p)
	{
		p.j = 10;
	}
	void changeValueofP(PassByValueInJava p)
	{
		PassByValueInJava temp = new PassByValueInJava();
		temp.j = 5;
		p = temp;
	}
	PassByValueInJava getChangedP(PassByValueInJava p)
	{
		p = new PassByValueInJava();
		p.j = 11;
		
		return p;
	}
	
	static void swap(PassByValueInJava p2,PassByValueInJava p)
	{
		PassByValueInJava temp = p;
		p = p2;
		p2 = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PassByValueInJava p = new PassByValueInJava();
		p.j = 1;
		
		System.out.println("p.j initially is " + p.j);
		
		//Does not changes p
		p.changeValueofP(p);
		System.out.println("Now p.j is " + p.j);
		
		//changes value of j
		p.changeValueOfJ(p);
		System.out.println("Now p.j is " + p.j);
		
		//changes p as we get a new instance
		p = p.getChangedP(p);
		System.out.println("p.j "+ p.j);
		
		/*
		PassByValueInJava p2 = p;
		//System.out.println(" p2.j is " + p2.j);
		
		
		p2 = p.getChangedP(p);
		System.out.println("p2.j is " + p2.j);
		System.out.println("p.j is " + p.j);
		
		swap(p2,p);
		
		System.out.println("Now p2.j is " + p2.j);
		System.out.println("Now p.j is " + p.j);
		
		
		*/
	}

}
