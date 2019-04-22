package pp.tp1.ej5;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	Scanner scanner=new Scanner(System.in);
	
	public Client(String ip, int port) throws MalformedURLException, RemoteException, NotBoundException{
		Registry rmiRegistry=LocateRegistry.getRegistry(ip,port);
		IWeather weather=(IWeather) rmiRegistry.lookup("WeatherServer");
		System.out.println("Client asking for the weather\nPress any key...\n");
		scanner.nextLine();
		System.out.println("The weather is "+weather.getWeather());
	}
	
	public static void main (String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		Client rmiCLient= new Client("localhost", 8000);
	}
}
