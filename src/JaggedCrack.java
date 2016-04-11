import java.math.*;
import java.util.*;

public class JaggedCrack {

	private long publicKey;
	private ArrayList<Long> keyValues = new ArrayList<>();
	
	public JaggedCrack(long publicKey) {
		this.publicKey = publicKey;
	}
	
	/* WILL NOT FIND 1 OR SELF */
	public void crack() {
		double initialJag = (publicKey / (publicKey - 1.0));
		int factorCounter = 1;
		
		while (factorCounter < publicKey) {
			approachWholeNumber(factorCounter, initialJag, Double.parseDouble(factorCounter + ".0"));
			factorCounter++;
		}
	}
	
	public void approachWholeNumber(int factorCounter, double initialJag, double i) {
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
		if ((jagArray[0] > 8) || (jagArray[0] < 2)) {
			System.out.println(i + "\t" + nextJag);
			
		}
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
