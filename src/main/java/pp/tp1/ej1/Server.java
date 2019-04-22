package pp.tp1.ej1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	
	public Server(int p) {
		this.port=p;
		this.start();
	}

	private void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(this.port);
			System.out.println("Server Started on Port: "+this.port);
			while (true) {
				Socket client = serverSocket.accept();
				System.out.println("Client Connected from port :"+client.getInetAddress().getCanonicalHostName()+" : "+client.getPort());
//				initialize input channel
				BufferedReader inputChannel = new BufferedReader( new InputStreamReader(client.getInputStream()));
//				initialize output channel
				PrintWriter outputChannel = new PrintWriter(client.getOutputStream(),true);
//				read input channel from client
				String message=inputChannel.readLine();
				System.out.println("Message recieved from client: "+message);
//				ack from server
				message= "ACK From Server";
				outputChannel.println(message);
//				close client connection
				client.close();
				System.out.println("Client "+client.getInetAddress().getCanonicalHostName() + " Disconnected");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		Server server=new Server(8000);
	}
}
