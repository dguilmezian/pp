package pp.tp1.ej3;

import java.io.Serializable;

public class Message implements Serializable {
	String sender;
	String reciever;
	String detail;
	
	public Message() {
		
	}
	
	public Message(String sender, String reciever, String detail) {
		this.sender=sender;
		this.reciever=reciever;
		this.detail=detail;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", reciever=" + reciever + ", detail=" + detail + "]";
	}
	
	
}
