package pp.tp1.ej4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
		ArrayList<Message> messages;
		
		public Server(int port) {
			try {
				messages=new ArrayList<Message>();
				synchronized (messages) {
					ServerSocket socket= new ServerSocket(port);
					System.out.println("Server started on port: "+port);
					while(true) {
						Socket client=socket.accept();
						ThreadServer threadServer=new ThreadServer(client, messages);
						Thread thread=new Thread(threadServer);
						thread.start();		
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public static void main(String[] args) {
			Server server = new Server(8000);
		}
	}

