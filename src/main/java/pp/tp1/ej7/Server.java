package pp.tp1.ej7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public Server(String ip, int port) {
		try {
			IRMI taskServer = new TaskServer();
			IRMI remoteTaskServer = (IRMI) UnicastRemoteObject.exportObject(taskServer, 8001);
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("TaskServer", remoteTaskServer);
			System.out.println("TaskServer ON in port: " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server server = new Server("localhost", 8000);
	}
}
