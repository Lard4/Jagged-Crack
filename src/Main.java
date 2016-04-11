import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) {
		/*
		BigInteger factor1 = new BigInteger("9999991");
		BigInteger factor2 = new BigInteger("9999973");
		BigInteger bigPublicKey = factor1.multiply(factor2);
		*/
		
		long publicKey = (91);
		
		System.out.println("Public Key: " + publicKey);
		
		/*
		Primes primes = new Primes(5000, 5500);
		primes.findPrimes();
		primes.print();
		*/
	
		//new Main().bruteForce(publicKey);
		new Main().jaggedCrack(publicKey);
		//new Main().bigBruteForce(bigPublicKey);
	}
	
	public void jaggedCrack(long publicKey) {
		JaggedCrack jagged = new JaggedCrack(publicKey);
		jagged.crack();
	}
	
	public void bruteForce(long publicKey) {
		BruteForce brute = new BruteForce(publicKey);
		
		brute.crack();
		System.out.println("Factors: " + brute.getFactors());
		System.out.println(brute.getTimeToComplete() + " milliseconds");
	}
	
	/* BROKEN AF */
	public void bigBruteForce(BigInteger publicKey) {
		BruteForce brute = new BruteForce(publicKey);
		
		brute.bigCrack();
		System.out.println("Factors: " + brute.getFactors());
		System.out.println(brute.getTimeToComplete() + " milliseconds");
	}
}
