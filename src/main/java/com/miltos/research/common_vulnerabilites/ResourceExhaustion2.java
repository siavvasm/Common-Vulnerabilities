package com.miltos.research.common_vulnerabilites;

/**
 * This class demonstrates how Memory can be exhausted due to instantiation inside loops.
 * @author siavvasm
 *
 */
public class ResourceExhaustion2 {
	
	public static void longRunningProcessVulnerable() {
		
		while (true) {
			//...
//			receivingSocket.receive(receivedPacket);
//			String message = new String(rxBuffer, 0, receivedPacket.getLength()); 
			// Do something with the message...
		}
	}
	
	public static void longRunningProcessClean() {
		
		String message = "";
		
		while (true) {
			//...
//			receivingSocket.receive(receivedPacket);
//			message = new String(rxBuffer, 0, receivedPacket.getLength()); 
			// Do something with the message...
		}
	}

}
