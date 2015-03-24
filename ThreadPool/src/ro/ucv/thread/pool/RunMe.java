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
			
		   PasswordTester task = new PasswordTester("Thread" + i,"ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f", Integer.MIN_VALUE,Integer.MAX_VALUE);
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
