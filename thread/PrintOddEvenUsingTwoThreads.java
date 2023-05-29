
public class PrintOddEvenUsingTwoThreads {
	int count = 1;
	
	static int N;
	
	void printOdd()
	{
		synchronized (this) {
			while(count <= N)
			{
				while(count % 2 == 0)
				{
					try {
						wait();
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				System.out.println(count++ + " ");
				notify();
			}
			
			
		}
	}
	void printEven()
	{

		synchronized (this) {
			while(count <= N)
			{
				while(count % 2 == 1)
				{
					try {
						wait();
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					
				}
				System.out.println(count++ + " ");
				notify();
				
			}
			
		}
	
	}
	public static void main(String ars[])

	{
		PrintOddEvenUsingTwoThreads poe = new PrintOddEvenUsingTwoThreads();
		N = 10;
		Thread t1 = new Thread(()-> poe.printOdd());
		Thread t2 = new Thread(() -> poe.printEven());
		t1.start();t2.start();
	}

}
