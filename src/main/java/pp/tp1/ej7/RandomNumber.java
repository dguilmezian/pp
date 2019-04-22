package pp.tp1.ej7;

import java.io.Serializable;
import java.util.Random;

public class RandomNumber implements ITask,Serializable {

	@Override
	public Object executeTask() {
		// TODO Auto-generated method stub
		return (Object) this.randomNumber();
	}

	private Object randomNumber() {
		// TODO Auto-generated method stub
		Random r= new Random();
		int n=r.nextInt(33);
		return n;
	}
	
}
