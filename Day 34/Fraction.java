public class Fraction {
    // fraction class
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator){
        if(denominator == 0){
            denominator = 1;
            return;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void setDenominator(int denominator) {
        if(denominator == 0){
            denominator = 1;
            return;
        }
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void print() {
        System.out.println(numerator + "/" + denominator);
    }

    private void simplify() {
        int getHCF = 1;
        for(int i = 2; i <= Math.min(numerator, denominator); i++){
            if(numerator % i == 0 && denominator % i == 0){
                getHCF = i;
            }
        }
        numerator = numerator/getHCF;
        denominator = denominator/getHCF;
    }

    public void increment(){
        numerator = numerator + denominator;
        simplify();
    }

    public void add(Fraction f2){
        // first object will be on which function will be called on
        // second object is passed in the arguments
        // we don't have to use THIS keyword but for understanding we are doing it
        this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }

    public static Fraction addFraction(Fraction f1, Fraction f2){
        int numerator = f1.numerator * f2.denominator + f1.denominator * f2.numerator;
        int denominator = f1.denominator * f2.denominator;
        Fraction f3 = new Fraction(numerator, denominator);
        return f3;
        // no need to call simplify as f3 will call an contructor and it have simplify() in it.
    }
}
