package ro.ucv.thread.pool;

import java.security.MessageDigest;
import java.util.concurrent.Callable;


public class PasswordTester implements Callable<String> {

	String m_name="";
	String m_hash="";
	int m_intervalStart;
	int m_intervalEnd;
	//TODO: check off all the todos
	
	/**
	 * TODO: this constructor should receive an interval where to generate passwords 
	 * and the password hash 
	 * TODO: all three parameters must be saved locally just like name
	 * 
	 * @param intervalStart int
	 * @param intervalEnd int
	 * @param hash String
	 * @param name name of the PasswordTester instance
	 */
	public PasswordTester(String name,String hash,int intervalStart,int intervalEnd){
		m_name=name;//save name locally in this class
		
		m_hash = hash;
		m_intervalStart = intervalStart;
		m_intervalEnd = intervalEnd;
	}
	
	
	
	@Override
	public String call() throws Exception {
		
		System.out.println(m_name+Thread.currentThread().getId()+": i'm starting");
		
		//TODO: all passwords from intervalStart to intervalEnd must be hashed using sha256 
		//TODO: and checked if their sha256 hash is equal to  the locally saved hash from the constructor
		
		return m_name; 
		//return null;
	}
	
	
	String sha256(int possiblePassword) {
		 try{
		        MessageDigest digest = MessageDigest.getInstance("SHA-256");
		        byte[] hash = digest.digest((""+possiblePassword).getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();
		    } catch(Exception ex){
		       throw new RuntimeException(ex);
		    }
	}

}
