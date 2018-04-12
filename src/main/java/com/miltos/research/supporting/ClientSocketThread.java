package com.miltos.research.supporting;

import java.net.Socket;

public class ClientSocketThread implements Runnable {
	public ClientSocketThread(Socket client){
		System.out.println("Client Thread Created...");
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Client invoked!!!!");
	}
}
