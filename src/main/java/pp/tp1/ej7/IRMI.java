package pp.tp1.ej7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMI extends Remote {
	
	public Object execute(ITask t) throws RemoteException;
}
