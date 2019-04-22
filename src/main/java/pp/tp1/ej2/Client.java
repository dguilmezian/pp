package pp.tp1.ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public Client(String ip, int port) {
		try {
			// open socket
			Socket socket = new Socket(ip, port);
			System.out.println(" Client Connected with ip:port : " + ip + ":" + port);
			// initialize input and output channels
			BufferedReader inputChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter outputChannel = new PrintWriter(socket.getOutputStream(), true);
			// send message to server
			outputChannel.println("Message From Client");
			// read server channel for reply
			String reply = inputChannel.readLine();
			System.out.println(" Reply from server: " + reply);
//			close connection
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		Client client = new Client ("localhost", 8000);
		
	}
}
