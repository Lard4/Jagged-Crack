import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) {
		BigInteger factor1 = new BigInteger("9999991");
		BigInteger factor2 = new BigInteger("9999973");
		
		BigInteger bigPublicKey = factor1.multiply(factor2);
		//long publicKey = (9999991 * 9999973);
		
		System.out.println("Public Key: " + bigPublicKey.longValueExact());
		
		/*
		Primes primes = new Primes(10000000);
		primes.findPrimes();
		primes.print();
		*/
		
		//new Main().bruteForce(publicKey);
		new Main().bigBruteForce(bigPublicKey);
	}
	
	public void bruteForce(long publicKey) {
		BruteForce brute = new BruteForce(publicKey);
		
		brute.crack();
		System.out.println("Factors: " + brute.getFactors());
		System.out.println(brute.getTimeToComplete() + " milliseconds");
	}
	
	public void bigBruteForce(BigInteger publicKey) {
		BruteForce brute = new BruteForce(publicKey);
		
		brute.bigCrack();
		System.out.println("Factors: " + brute.getFactors());
		System.out.println(brute.getTimeToComplete() + " milliseconds");
	}
}
