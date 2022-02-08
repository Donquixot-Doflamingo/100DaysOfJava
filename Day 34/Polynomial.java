public class Polynomial {
    private int polynomials[];

    Polynomial(){
        polynomials = new int[10];
    }

    public int get(int index){
        return polynomials[index];
    }

    public void setCoeficents(int index, int Coeficent){
        if(index >= polynomials.length){
            doubleCapacity();
            setCoeficents(index, Coeficent);
        }
        polynomials[index] = Coeficent;
    }

    private void doubleCapacity() {
        int temp[] = polynomials;
        polynomials =  new int[temp.length * 2];
        for(int i = 0; i < temp.length; i++){
            polynomials[i] = temp[i];
        }
    }

    public void print(){
        System.out.println();
        for(int i = 0; i < this.size(); i++){
            int element = this.get(i);
            if(element != 0){
                System.out.print(element+ "x^" + i + " + ");
            }
        }
        System.out.println();
    }

    public int size(){
        return polynomials.length;
    }

    public void add(Polynomial p1){
        int n = Math.max(this.size(), p1.size());
        for(int i = 0; i < n; i++){
            int element1 = this.get(i);
            int element2 = p1.get(i);
            this.setCoeficents(i, element1+element2);
        }
    }

    public int evaluate(int x){
        int result = 0;
        for(int i =0; i < this.size(); i++){
            if(this.get(i) != 0){
                Double var = Math.pow(x, i);
                Double term = var * get(i);
                result += term;
            }
            // int value = Math.pow(this.get(i), b)
        }
        return result;
    }

    public static Polynomial addData(Polynomial p1, Polynomial p2){
        int n = Math.max(p2.size(), p1.size());
        Polynomial p3 = new Polynomial();
        for(int i = 0; i < n; i++){
            int element1 = p2.get(i);
            int element2 = p1.get(i);
            p3.setCoeficents(i, element1+element2);
        }
        return p3;
    }

    public void multiply(Polynomial p1){
        int n = Math.max(this.size(), p1.size());

        for(int i = 0; i < n; i++){
            int element1 = this.get(i);
            int element2 = p1.get(i);
            if(element1 != 0 && element2 != 0){
                this.setCoeficents(i, element1*element2);
            }
            else if(element1 == 0){
                this.setCoeficents(i, element2);
            }
        }
    } 
}
