import java.util.*;
import java.net.*;
import java.io.*;

public class receive extends Thread
{
	public int xpos;
	public int ypos;
	DatagramSocket socket;
	
	public receive(DatagramSocket s)
	{
		socket=s;
	}

	public byte[] inBuff = new byte[]{-1,-1};
	private DatagramPacket inPacket = new DatagramPacket(inBuff , inBuff.length);
	private String DEST_IP ="127.0.0.1";
	
	public void run() 
	{
		try
		{
			while(true)
			{	//每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
			socket.receive(inPacket);
			System.out.println(inBuff[0]+" "+inBuff[1]);
			}
		
		}
		catch (	IOException e)
		{
			System.out.println("error_server");
		}
			
	}

}
