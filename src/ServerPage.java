import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPage {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server= new ServerSocket(9090);
		System.out.println("Server is ready...........");
		Socket sk=server.accept();

		//Reading form the keyboard 
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		//Sending the data from server
		OutputStream ostream = sk.getOutputStream(); 
		PrintWriter pwrite = new PrintWriter(ostream, true);

		
		//Receiving the data from server
		BufferedReader receiveread=new BufferedReader(new InputStreamReader(sk.getInputStream()));

		String receive, send;
		while(true)
		{

			  receive = receiveread.readLine();//receive from server
		      
				  if(receive.equalsIgnoreCase("bye"))
				  {
					 System.out.println("Client is Going offline........bye");
					 server.close();
				     sk.close();
					 
		             
				  }
				  
					  System.out.println("Client:" +receive+ "\n");// displaying at DOS prompt  
					  send=stdin.readLine();
					  pwrite.println(send);
					  if(send.equalsIgnoreCase("bye"))
						{
							server.close();
							sk.close();
						}
					  pwrite.flush();             
			  	 
		}
	}
}
