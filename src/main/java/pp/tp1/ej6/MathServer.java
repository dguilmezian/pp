package pp.tp1.ej6;

public class MathServer implements IMath {

	@Override
	public int[] sum(int[] v1, int[] v2) {
		int[] results = new int[v1.length];
		for (int i = 0; i < v1.length; i++) {
			results[i] = v1[i] + v2[i];
			System.out.println("Entering error in vector from server");
			v1[0]=33;
			v2[0]=44;
		}
		return results;
	}

	@Override
	public int[] substraction(int[] v1, int[] v2) {
		int[] results = new int[v1.length];
		for (int i = 0; i < v1.length; i++) {
			results[i] = v1[i] - v2[i];
			System.out.println("Entering error in vector from server");
			v1[0]=33;
			v2[0]=44;
		}
		return results;
	}

}
