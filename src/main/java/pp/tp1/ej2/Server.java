package pp.tp1.ej2;

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
				ThreadServer threadServer=new ThreadServer(client);
				Thread thread=new Thread(threadServer);
				thread.start();			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		Server server=new Server(8000);
	}
}
