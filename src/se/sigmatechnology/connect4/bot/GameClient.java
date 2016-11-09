package se.sigmatechnology.connect4.bot;

import java.util.List;

/**
 * Created by msk on 2016-11-08.
 */
public class GameClient {


    public boolean connect(String name) {
    	 System.out.println("Enter IP address of server");
      	  
         Scanner scanner = new Scanner(System.in);
    	    String IPaddress = scanner.nextLine();
    	    
    	    String request = "http://"+IPaddress +"/connect/?";
    	 
    	    HttpClient client = new HttpClient();
         PostMethod method = new PostMethod(request);
    	  
         method.addParameter("name",name);
       
         int statusCode = client.executeMethod(method);
         
         scanner.close();
        
         if (statusCode == HttpStatus.SC_OK) {
        	     return true;
         }
       	
     	    return false; 
    }

    public State getState() {
        return State.LOST; //TODO: implement me
    }

    public String enterDisk(int column) {
        return "";//TODO: implement me
    }

    public List<String> getNames() {
        return null;//TODO: implement me
    }

    public int getLastTurn() {
        return -1;//TODO: implement me
    }

}
