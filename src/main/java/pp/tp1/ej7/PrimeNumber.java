package pp.tp1.ej7;

import java.io.Serializable;

public class PrimeNumber implements ITask, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7188953053484783458L;

	/**
	 * 
	 */
//	private static final long serialVersionUID = -5989268958624790183L;

	@Override
	public Object executeTask() {
		return (Object) primeNumbers();
	}

	private Object primeNumbers() {
		int i;
		int num = 0;
		int maxCheck = 100000; 
		boolean flag = true;
		int[] primes=new int[5];
		int j=0;
		while (j<4) {
			for (i = 1; i <= maxCheck; i++) {
				flag = isPrime(i);
				if (flag) {
					primes[j] = i;
					j++;
				}
			}
		}
		return primes;
	}

	public static boolean isPrime(int numberToCheck) {
		int remainder;
		for (int i = 2; i <= numberToCheck / 2; i++) {
			remainder = numberToCheck % i;
			if (remainder == 0) {
				return false;
			}
		}
		return true;

	}
}
