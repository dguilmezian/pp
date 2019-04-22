package pp.tp1.ej5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWeather extends Remote {
	public String getWeather() throws RemoteException;
}
