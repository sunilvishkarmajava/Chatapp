import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientPage {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sk= new Socket("192.168.43.66",2000);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true)
		{
			System.out.println("Client:   ");
			s=stdin.readLine();
			sout.println(s);
			s=sin.readLine();
			System.out.println("Server:    "+s+"\n");
			if(s.equalsIgnoreCase("Bye"))
			{
				break;
			}
		}
		sk.close();
		sin.close();
		sout.close();
		stdin.close();
	}

}
