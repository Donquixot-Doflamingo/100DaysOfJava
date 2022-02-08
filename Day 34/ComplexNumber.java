public class ComplexNumber {
    private int realNumber;
    private int imaginaryNumber;

    // contructor initialising the num. and den.
    ComplexNumber(int realNumber, int imaginaryNumber){
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    // get the value of imaginaryNumber
    public int getImaginaryNumber() {
        return imaginaryNumber;
    }
    
    // get the value of realNumber
    public int getRealNumber() {
        return realNumber;
    }
    
    // changinging or setting the value of imaginaryNumber
    public void setImaginaryNumber(int imaginaryNumber) {
        this.imaginaryNumber = imaginaryNumber;
    }
    
    // changinging or setting the value of realNumber
    public void setRealNumber(int realNumber) {
        this.realNumber = realNumber;
    }

    // print the value of real and imaginary number
    public void print(){
        System.out.println(realNumber + " " + imaginaryNumber);
    }

    // adding complex number of the Obj2 in Obj1 or viceversa depends on who calls it.
    public void add(ComplexNumber c2){
        realNumber = realNumber + c2.realNumber;
        imaginaryNumber = imaginaryNumber + c2.imaginaryNumber;
    }

    //similarly just multiplying obj1 in obj2 or vica versa
    public void multiply(ComplexNumber c2){
        int real = realNumber* c2.realNumber + (-1)*imaginaryNumber*c2.imaginaryNumber;
        int imaginary =  realNumber * c2.imaginaryNumber + c2.realNumber * imaginaryNumber;
        realNumber = real;
        imaginaryNumber = imaginary;
    }

    // storing the sum of two objects in 3RD object
    public static ComplexNumber addNumber(ComplexNumber c1 , ComplexNumber c2){
        int realNum = c1.realNumber + c2.realNumber;
        int imaginaryNum = c1.imaginaryNumber + c2.imaginaryNumber;
        ComplexNumber c3 = new ComplexNumber(realNum, imaginaryNum);
        return c3;
    }
}
