import java.util.*;

public class Primes {
	
	private ArrayList<Long> primeList = new ArrayList<>();
	private long limit = 0;
	private long start = 0;

	public Primes(long limit) {
		this.limit = limit;
	}
	
	public Primes(long start, long limit) {
		this.start = start;
		this.limit = limit;
	}
	
	/* LIMIT IS INCLUSIVE */
	public void findPrimes() {
		while (start <= limit) {
			if (isPrime(start)) {
				primeList.add(start);
			}
			start++;
		}
	}
	
	public boolean isPrime(long num) {
	    if (num % 2 == 0) return false;

	    for (int i = 3; i * i <= num; i += 2) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public void print() {
		for (int i = 0; i < primeList.size(); i++) {
			System.out.println(primeList.get(i));
		}
	}
}
