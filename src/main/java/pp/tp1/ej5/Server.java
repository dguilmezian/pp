package pp.tp1.ej5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public Server(String ip, int port) {
		try {
			IWeather weatherServer = new WeatherServer();
			IWeather remoteWeatherServer = (IWeather) UnicastRemoteObject.exportObject(weatherServer, 8001);
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("WeatherServer", remoteWeatherServer);
			System.out.println("Server ON in port: " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server server = new Server("localhost", 8000);

	}
}
