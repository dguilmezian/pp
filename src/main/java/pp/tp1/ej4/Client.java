package pp.tp1.ej4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client(String ip, int port) {
		PrintWriter printWriter;
		try {
			Scanner scanner = new Scanner(System.in);
			Socket socket = new Socket(ip, port);
			boolean flag = true;
			BufferedReader inputChannel;
			while (flag) {
				System.out.println("Client connected to Messages Server\n");
				System.out.println("Choose an option\n1-Download my Messages\n2-Send a Message\n3-Exit");
				String clientOption = scanner.nextLine();
				switch (clientOption) {
				case "1":
					System.out.println("################\nMessages for the Client");
					printWriter = new PrintWriter(socket.getOutputStream(), true);
					printWriter.println(clientOption);
					System.out.println("Enter your Username");
					String userName = scanner.nextLine();
					printWriter = new PrintWriter(socket.getOutputStream(), true);
					printWriter.println(userName);
					inputChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String serverAnswer = inputChannel.readLine();
					System.out.println("Client Messages: \n" + serverAnswer + "\n");
					System.out.println("Delete your inbox?");
					String answer=scanner.nextLine();
					if(answer.contains("y")) {
						printWriter=new PrintWriter(socket.getOutputStream(),true);
						printWriter.println(answer);
					}
					
					break;
				case "2":
					System.out.println("################\nThe client want to send a message");
					printWriter = new PrintWriter(socket.getOutputStream(), true);
					Message message = new Message();
					printWriter.println(clientOption);
					System.out.println("Enter the message reciever");
					message.setReciever(scanner.nextLine());
					System.out.println("Enter your Username");
					message.setSender(scanner.nextLine());
					System.out.println("Write your message");
					message.setDetail(scanner.nextLine());
					ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
					outputChannel.writeObject(message);
					break;
				case "3":
					System.out.println("#############\nExiting...");
					printWriter = new PrintWriter(socket.getOutputStream(), true);
					printWriter.println(clientOption);
					flag = false;
					socket.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client("localhost", 8000);

	}
}
