package pp.tp1.ej5;

import java.rmi.RemoteException;
import java.util.Random;

public class WeatherServer implements IWeather{

	@Override
	public String getWeather() throws RemoteException {
		String [] options = {"Sunny","Cloudy","Rainy","Stormy"};
		Random random=new Random();
		int optionSelected=random.nextInt(options.length);
		return options[optionSelected];
	}
	
}
