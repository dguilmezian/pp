package pp.tp1.ej6;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
	Scanner scanner = new Scanner(System.in);

	public Client(String ip, int port) throws RemoteException, NotBoundException {
		Registry rmiRegistry = LocateRegistry.getRegistry(ip, port);
		IMath math = (IMath) rmiRegistry.lookup("MathServer");
		boolean flag = true;
		while (flag) {
			System.out.println("#####################\nMathServer\nChoose an option\n1-Add Vectors\n2-Substract Vectors\nAny-Exit");
			String clientOption = scanner.nextLine();
			
//			TODO para que el cliente los cargue despues
			int[] v1 = new int[3];
			v1[0] = 1;
			v1[1] = 1;
			v1[2] = 1;
			int[] v2 = new int[3];
			v2[0] = 5;
			v2[1] = 5;
			v2[2] = 5;
 
			switch (clientOption) {
			case "1":
				System.out.println("Loading Vectors");
				System.out.println("Vectors Loaded");
				System.out.println("Vector 1 : " + Arrays.toString(v1) + "\nVector 2 : " + Arrays.toString(v2));
				int[] result = math.sum(v1, v2);
				System.out.println("Vectors Added: " + Arrays.toString(result));
				System.out.println("Vectors after the operations:\nVector 1: "+Arrays.toString(v1)+"\nVector 2: "+Arrays.toString(v2));
				break;
			case "2":
				System.out.println("Loading Vectors");
				System.out.println("Vectors Loaded");
				System.out.println("Vector 1 : " + Arrays.toString(v1) + "\nVector 2 : " + Arrays.toString(v2));
				int[] result2= math.substraction(v1, v2);
				System.out.println("Substracted Vectors: " + Arrays.toString(result2));
				System.out.println("Vectors after the operations:\nVector 1: "+Arrays.toString(v1)+"\nVector 2: "+Arrays.toString(v2));
				break;
			default:
				flag = false;
				System.out.println("Exiting...");
				break;
			}
		}
	}

	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		Client rmiCLient = new Client("localhost", 8000);
	}

}
