package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer
{
	
	public static void main(String[] args) {
		int portNumber = 4444;
		
		serverSocket = null;
		while(true) 
		{
			try {
				ServerSocket serverSocket = new ServerSocket(portNumber);
			}catch(IOException e) {
				System.err.println("porting broken"+portNumber);
				System.exit(1);
			}
		}
	}
}
