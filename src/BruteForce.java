import java.util.*;
import java.math.*;

public class BruteForce {
	
	private long publicKey;
	private BigInteger bigPublicKey;
	private ArrayList<Long> publicKeyFactors = new ArrayList<>();
	private long startTime, endTime;
	
	public BruteForce(long publicKey) {
		startTime = System.currentTimeMillis();
		this.publicKey = publicKey;
	}
	
	public BruteForce(BigInteger publicKey) {
		startTime = System.currentTimeMillis();
		this.bigPublicKey = publicKey;
	}
	
	public void crack() {
		for (long i = publicKey; i > 0; i--) {
			if (publicKey % i == 0) {
				publicKeyFactors.add(publicKey / i);
			}
		}
	}
	
	public void bigCrack() {
		for (BigInteger i = bigPublicKey; i.longValueExact() > 0; i.subtract(new BigInteger("1"))) {
			if (bigPublicKey.mod(i).longValueExact() == 0) {
				publicKeyFactors.add(bigPublicKey.divide(i).longValueExact());
			}
		}
	}
	
	public String getFactors() {
		String factors = "";
		
		for (int i = 0; i < publicKeyFactors.size(); i++) {
			factors += (publicKeyFactors.get(i) + ", ");
		}
		
		return factors;
	}
	
	public long getTimeToComplete() {
		endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
}
