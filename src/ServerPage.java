import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPage {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server= new ServerSocket(2000);
		Socket sk=server.accept();
		InputStreamReader in=new InputStreamReader(sk.getInputStream());
		BufferedReader cin = new BufferedReader(in);
		PrintStream cout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true)
		{
			s=cin.readLine();
			if(s.equalsIgnoreCase("bye"))
			{
				cout.println("BYE");
				break;
			}
			else
			{
				System.out.println("Client:   "+s+"\n");
				System.out.println("Server:   ");
				s=stdin.readLine();
			}
		}
		server.close();
		sk.close();
		in.close();
		cin.close();
		cout.close();
		stdin.close();
	}

}
