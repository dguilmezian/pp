package pp.tp1.ej7;

import java.io.Serializable;

public class PiNumber implements ITask,Serializable {

	@Override
	public Object executeTask() {
		// TODO Auto-generated method stub
		return (Object) piNumber();
	}

	private Object piNumber() {
		// TODO Auto-generated method stub
		return Math.PI;
	}

}
