import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientPage {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket sk= new Socket("127.0.0.1",9090);
		
		//Receiving the data from the server
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		
		//Sending the data to ServerPage
		
		PrintStream sout=new PrintStream(sk.getOutputStream());
		
		//Reading the input from keyboard
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Start the chating...., type and enter any word");
		
		String receive, send; 
		while(true)
		{
			send=stdin.readLine();
			sout.println(send);
			if(send.equalsIgnoreCase("bye"))
			{
				sk.close();
			}
			sout.flush();
			
			if((receive=sin.readLine()).equalsIgnoreCase("bye"))
				{
					System.out.println("Server is going offline");
					break;
				}
			
			System.out.println("Server:" +receive+ "\n");
		
		}
		sk.close();
	}

}
