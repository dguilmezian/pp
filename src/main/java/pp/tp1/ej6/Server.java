package pp.tp1.ej6;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public Server(String ip, int port) {
		try {
			IMath mathServer = new MathServer();
			IMath remoteMathServer = (IMath) UnicastRemoteObject.exportObject(mathServer, 8001);
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("MathServer", remoteMathServer);
			System.out.println("MathServer ON in port: " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server server = new Server("localhost", 8000);
	}

}
