//Bill pugh model
//widely used as no synchronization overhead
//When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class.
//Inner class is created only when getInstance() method is called
public class Singleton {

	private Singleton()
	{
		
	}
	
	private static class BillPughInstance {
		private static final Singleton instance = new Singleton();		
	}
	public static Singleton getInstance() {
		return BillPughInstance.instance;
	}
}

/*
 * Second easy method.
 * Prior to Java5, memory model had a lot of issues and below methods caused failure in certain scenarios
 * in multithreaded environment.Hence Bill Pugh model is used.
 * 
 * public class Singleton {
  
    
    private static Singleton uniqueInstance;
  
    private Singleton()
    {
    }
  
    public static Singleton getInstance()
    {
        if (uniqueInstance == null)
       {
            synchronized(Singleton.class) 
             {
                 if (uniqueInstance == null) 
                   {    
                    uniqueInstance = new Singleton();
                   }
              }
        }
        return uniqInstance;
    }
}*/
//

//https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
