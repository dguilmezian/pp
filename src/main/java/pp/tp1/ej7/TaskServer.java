package pp.tp1.ej7;

import java.rmi.RemoteException;

public class TaskServer implements IRMI {

	@Override
	public Object execute(ITask t) throws RemoteException {
		return t.executeTask();
	}
	
}
