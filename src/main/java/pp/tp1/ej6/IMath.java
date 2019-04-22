package pp.tp1.ej6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMath extends Remote{
	public int[] sum(int[] v1, int[] v2) throws RemoteException;
	public int[] substraction(int[] v1, int[] v2) throws RemoteException;
}
