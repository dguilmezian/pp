package pp.tp1.ej7;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	Scanner scanner = new Scanner(System.in);

	public Client(String ip, int port) throws RemoteException, NotBoundException {
		Registry rmiRegistry = LocateRegistry.getRegistry(ip, port);
		IRMI generic = (IRMI) rmiRegistry.lookup("TaskServer");
		boolean flag = true;
		while (flag) {
			System.out.println(
					"#####################\nGeneric Server\nChoose an option\n1-Random Number\n2-First Five Prime Numbers\n3-Return PI\nAny-Exit");
			String clientOption = scanner.nextLine();
			switch (clientOption) {
			case "1":
				ITask randomNumber=new RandomNumber();
				System.out.println("Your Random number: "+generic.execute(randomNumber));
				break;
			case "2":
				ITask primeNumbers=new PrimeNumber();
				System.out.println("First five prime numbers: "+generic.execute(primeNumbers));
				break;
			case "3":
				ITask pi=new PiNumber();
				System.out.println("Your PI : "+generic.execute(pi));
				break;
			default:
				flag=false;
				break;
			}
		}
	}

	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		Client rmiCLient = new Client("localhost", 8000);
	}
}
