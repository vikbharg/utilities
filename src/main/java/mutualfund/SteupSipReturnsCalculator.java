package mutualfund;

public class SteupSipReturnsCalculator {

	public static void main(String[] args) {

		int sipAmount = 4000;
		double rateOfInterest = 12;
		int investmentDuration = 27;
		double stepUpPercent = 10;
		
		System.out.println(getReturns(sipAmount, rateOfInterest, investmentDuration, stepUpPercent));
	}
	
	public static int getReturns(int sipAmount, double rateOfInterest, int investmentDuration, double stepUpPercent) {
		double i = rateOfInterest/12/100;
		
		Double corpusAmount =  sipAmount * (Math.pow(1+i, investmentDuration*12)-1) * ((1+i)/i);
		Double previousSipAmount = Double.valueOf(sipAmount);
		
		long amountInvested = sipAmount * 12;
		
		for(int j=investmentDuration-1;j>=1;j--) {
			
			Double normalizedSipAmount = (sipAmount*Math.pow((1+stepUpPercent/100), investmentDuration-j));
			
			int effectiveSipAmount = normalizedSipAmount.intValue() - previousSipAmount.intValue();
			previousSipAmount = normalizedSipAmount;
			
			Double extraCorpus = effectiveSipAmount * (Math.pow(1+i, j*12)-1) * ((1+i)/i);
			corpusAmount = Double.sum(corpusAmount, extraCorpus);
			amountInvested += normalizedSipAmount*12;
			
		}
		System.out.println("Amount Invested : "+amountInvested);
		
		return corpusAmount.intValue();
	}
}
