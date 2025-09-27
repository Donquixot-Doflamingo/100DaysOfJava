public class Day34 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(4, 8);
        Fraction f2 = new Fraction(4, 8);
        Fraction f3 = Fraction.addFraction(f1, f2);
        f3.print();
        ComplexNumber c1 = new ComplexNumber(3, 4);
        c1.print();
        c1.setRealNumber(6);
        c1.setImaginaryNumber(9);
        c1.print();
        ComplexNumber c2 = new ComplexNumber(4, 5);
        c1.add(c2);
        c1.print();
        c2.print();
        ComplexNumber c3 = new ComplexNumber(5, 6);
        c3.multiply(c2);
        c3.print();
        c2.print();
        ComplexNumber c4 = ComplexNumber.addNumber(c1, c2);
        c1.print();
        c2.print();
        c4.print();

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.setCoeficents(3, 4);
        p1.setCoeficents(5, 8);
        p2.setCoeficents(3, 4);
        p2.setCoeficents(4, 2);
        p1.print();
        p2.print();
        p1.multiply(p2);
        p1.print();
        p2.print();
        System.out.println(p1.evaluate(10));
        p1.add(p2);
        p1.print();
        p2.print();     
     }
}
