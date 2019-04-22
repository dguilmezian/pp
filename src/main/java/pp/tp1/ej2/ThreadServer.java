package pp.tp1.ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServer implements Runnable{
	Socket client;
	
	public ThreadServer(Socket client) {
		this.client = client;
	}
	public void run() {
		try {
			BufferedReader inputChannel=new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			PrintWriter outputChannel = new PrintWriter(this.client.getOutputStream(),true);
			String message=inputChannel.readLine();
			System.out.println("Message recieved From CLient: "+message);
			message="ACK From Server";
			outputChannel.println(message);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.client.close();
			System.out.println("Client "+this.client.getInetAddress().getCanonicalHostName() + " Disconnected");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
