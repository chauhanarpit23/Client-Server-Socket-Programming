import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client 
{

	public static void main(String[] args)
	{
		System.out.println("Client Side Process");
		System.out.println();
		try
		{		
			Socket s2=new Socket(("localhost"),8004);
			int number,temp,account=0,amount=0,exit=0,i;
			int accountList [];
			Scanner sc = new Scanner(System.in);
			DataInputStream IntoClient= new DataInputStream(s2.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(s2.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String msgin="",msgout="";
			while(!msgin.equals("end"))
			{	
				
				msgout = br.readLine();
				System.out.println(msgout);
				outToClient.writeUTF(msgout);
				msgin = IntoClient.readUTF();
				System.out.println(msgin);
				
			}
			s2.close();
				
		}
			catch (Exception e)
			{
			
			}
		}
}

	

