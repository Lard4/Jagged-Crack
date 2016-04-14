import java.math.*;
import java.util.*;

public class JaggedCrack {

	private long publicKey;
	private HashMap<Long, Double> keyValues = new HashMap<>();
	
	public JaggedCrack(long publicKey) {
		this.publicKey = publicKey;
	}
	
	/* WILL NOT FIND 1 OR SELF */
	public void crack() {
		double initialJag = (publicKey / (publicKey - 1.0));
		long factorCounter = 1;
		
		while (factorCounter < publicKey) {
			factorCounter = approachWholeNumber(factorCounter, initialJag, Double.parseDouble(factorCounter + ".0"));
		}
	}
	
	public long approachWholeNumber(long factorCounter, double initialJag, double i) {
		double nextJag = (publicKey / (publicKey - i));
		
		int frontDigits = 1;
		for (int ii = 10; ii > 0; ii *= 10) {
			if (nextJag - ii < 0) {
				nextJag = makeDecimal(nextJag, frontDigits);
				break;
			}
			frontDigits++;
		}
		
		byte[] jagArray = toByteArray(nextJag);
		
		if (jagArray[0] == 0) {
			if (factorCounter % publicKey == 0) {
				System.out.println("GOTEEM! it's " + factorCounter);
				return publicKey;
			}
		}
		
		if ((jagArray[0] > 8) || (jagArray[0] < 2)) {
			System.out.println(factorCounter + "\t" + nextJag);
			keyValues.put(factorCounter, nextJag);
		} else {
			//factorCounter++;
		}
		
		return factorCounter + 1;
	}
	
	public double makeDecimal(double num, int digitsToLopOff) {
		String sNum = Double.toString(num);
		return Double.parseDouble(sNum.substring(digitsToLopOff));
	}
	
	public byte[] toByteArray(double value) {
		byte[] bytes = new byte[16];
	    char[] cBytes = Double.toString(value).toCharArray();
	    
	    for (int i = 0; i < bytes.length; i++) {
	    	try {
	    		bytes[i] = (byte) Integer.parseInt(String.valueOf(cBytes[i + 2]));
	    	} catch (Exception e) { }
	    }
	    return bytes;
	}
}
