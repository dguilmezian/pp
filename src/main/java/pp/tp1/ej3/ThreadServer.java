package pp.tp1.ej3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer implements Runnable {
	Socket client;
	ArrayList<Message> messages;

	public ThreadServer(Socket client, ArrayList<Message> messages) {
		this.client = client;
		this.messages = messages;
	}

	public void run() {
		try {
			boolean flag = true;
			while (flag) {
				BufferedReader inputChannel = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
//				read option selected by the client
				String clientOption = inputChannel.readLine();
				System.out.println("Client Option: " + clientOption);
				switch (clientOption) {
				case "1":
					//download my messages
					String userClient = inputChannel.readLine();
					System.out.println("Messages for client " + userClient);
					String serverAnswer = searchMessage(userClient);
					PrintWriter outputChannel = new PrintWriter(client.getOutputStream(), true);
					outputChannel.println(serverAnswer);
					break;
				case "2": // client want to add a message
					InputStream input = client.getInputStream();
					ObjectInputStream inputMessage = new ObjectInputStream(input);
					Message message = (Message) inputMessage.readObject();
					messages.add(message);
					System.out.println("Message from client added");
					System.out.println(messages);
					break;
				case "3": // exit
					flag = false;
					client.close();
					break;
				}
			}

			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String searchMessage(String userClient) {
		String list = "" ;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getReciever().contains(userClient)) {
				list = list +  messages.get(i).toString();
			}
		}
		return list;
	}

}
