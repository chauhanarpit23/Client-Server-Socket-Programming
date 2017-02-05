import java.io.*;
import java.net.*;

public class Server {


	public static void main(String[] args)
	{
		//System.out.println("Server Side Process");
		//System.out.println();
		try 
		{
			ServerSocket s1= new ServerSocket(8004);
			System.out.println("Ready For Client Connection");
		
			Socket mySocket= s1.accept();
			System.out.println("Client Connected...");
			System.out.println();
		
			System.out.println("Messages From Client");
			DataInputStream IntoClient= new DataInputStream(mySocket.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(mySocket.getOutputStream());
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			String msgin="",msgout="";
			while(!msgin.equals("end"))
			{
					msgin = IntoClient.readUTF();
					System.out.println(msgin);
					//DataInputStream br;
					//DataInputStream br = null;
					msgout = br.readLine();
					outToClient.writeUTF(msgout);
					outToClient.flush();
			}
			s1.close();
		}
		catch (Exception e) {
		}
		

	}

}
