package moneycalculator.model;

public class MoneyAmount {
    private long numerator;
    private long denominator;

    public MoneyAmount (long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }


    public MoneyAmount (long number) {
        numerator = number;
        denominator = 1;
    }
    
    public MoneyAmount (MoneyAmount number){
        this.numerator = number.numerator; 
        this.denominator = number.denominator; 
    }
    
    public MoneyAmount (double number){
        this(numberFromDouble(number));
    }

    public static MoneyAmount numberFromDouble (double number) {
        long denominatorContainer = 1;
        while(number != (long) number){
            number *= 10;
            denominatorContainer *= 10;
        }
        return new MoneyAmount((long) number, denominatorContainer);
    }

    private int[] getPrimeNumbers(){
        return new int[]{2,3,5,7,11,13,17,19,23};
    }
    
    private void reduce() {
        int[] primes = getPrimeNumbers();
        for (int divisor : primes) {
            if(numerator < divisor) break;
            if(denominator < divisor) break;
            divide(divisor);
        }
    }

    private void divide(int divisor) {
        while(numerator % divisor == 0 && denominator % divisor == 0){
            numerator /= divisor;
            denominator /= divisor;
        }
    }
    
    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
    
    public static MoneyAmount valueOf (String value) throws NumberFormatException{
        return new MoneyAmount (Double.valueOf(value));
    }
    
    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        final MoneyAmount other = (MoneyAmount) obj;
        
        if (this.numerator != other.numerator) return false;
        if (this.denominator != other.denominator) return false;
        return true;
    }

    public MoneyAmount multiplicate(double exchangeRate) {
        return multiplicate(new MoneyAmount(exchangeRate));
    }
    
    public MoneyAmount multiplicate(MoneyAmount number) {
        this.numerator *= number.numerator;
        this.denominator *= number.denominator;
        reduce();
        return new MoneyAmount(this.numerator, this.denominator);
    }
    
    
    
    
}
