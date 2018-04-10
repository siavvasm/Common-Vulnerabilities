package com.miltos.research.common_vulnerabilites;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceExhaustion1 {
	
	public static int SERVER_PORT = 4444;
	public static int MAX_CONNECTIONS = 4444;
	
	public void acceptConnectionsVulnerable() {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			int counter = 0;
			boolean hasConnections = true;
			
			while (hasConnections) { // Unlimited number of threads is created
				
				Socket client = serverSocket.accept();
				Thread t = new Thread(new ClientSocketThread(client));
				t.setName(client.getInetAddress().getHostName() + ":" + counter++);
				t.start();
				
			}
			
			// ...

		} catch (IOException ex) {
			// Log the event ...
		}
	}
	
	public void acceptConnectionsClean() {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			int counter = 0;
			boolean hasConnections = true;
			
			while (hasConnections) { // Unlimited number of threads is created
				hasConnections = checkForMoreConnections();
				Socket client = serverSocket.accept();
				Thread t = new Thread(new ClientSocketThread(client));
				t.setName(client.getInetAddress().getHostName() + ":" + counter++);
				
				// Create a thread pool to limit the number of the threads that are generated
				ExecutorService pool = Executors.newFixedThreadPool(MAX_CONNECTIONS);
				pool.execute(t);
				
			}
			
			// ...

		} catch (IOException ex) {
			// Log the event ...
		}
	}

}
