package ro.ucv.thread.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunMe {
	
	public static void main(String[] args) {
		
		int threadCount=50;

		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		Collection collection = new ArrayList<PasswordTester>( );
		
		
		for(int i=0; i< threadCount; i++){
			
			//TODO: divide your problem into manageable intervals here
			
		   PasswordTester task = new PasswordTester("Johnny"+i+"_");
		   collection.add(task);
		  }
		
		try {
			//this is called when one of the threads returns something other than null
			// all other threads are canceled
			String f=executor.invokeAny(collection);
			System.out.println("Finished  - "+f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		executor.shutdown();
		
	}

}
