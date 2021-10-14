package mutualfund;

public class RegularSipReturnsCalculator {

	public static void main(String[] args) {
		
		int sipAmount = 2000;
		double rateOfInterest = 11;
		int investmentDuration = 30;
		
		System.out.println(getReturns(sipAmount, rateOfInterest, investmentDuration));
	}
	
	public static int getReturns(int sipAmount, double rateOfInterest, int investmentDuration) {
		double i = rateOfInterest/12/100;
		
		Double corpusAmount =  sipAmount * (Math.pow(1+i, investmentDuration*12)-1) * ((1+i)/i);
		return corpusAmount.intValue();
	}
}
