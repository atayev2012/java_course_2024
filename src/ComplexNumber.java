public class ComplexNumber {
    int realNumber, imaginaryNumber;

    public ComplexNumber(int r, int i){
        this.realNumber = r;
        this.imaginaryNumber = i;
    }

    // Add complex number
    public void addComplex(ComplexNumber a){
        this.realNumber += a.realNumber;
        this.imaginaryNumber += a.imaginaryNumber;
    }

    // Subtract complex number
    public void subComplex(ComplexNumber a){
        this.realNumber -= a.realNumber;
        this.imaginaryNumber -= a.imaginaryNumber;
    }

    // Multiplication of complex numbers
    public void multiplyComplex(ComplexNumber a){
        int r = this.realNumber * a.realNumber - this.imaginaryNumber * a.imaginaryNumber;
        int i = this.realNumber * a.imaginaryNumber + this.imaginaryNumber * a.realNumber;
        this.realNumber = r;
        this.imaginaryNumber = i;
    }

    // Division of complex numbers
    public void divideComplex(ComplexNumber a){
        int d = a.realNumber * a.realNumber + a.imaginaryNumber * a.imaginaryNumber;
        int r = (this.realNumber * a.realNumber + this.imaginaryNumber * a.imaginaryNumber) / d;
        int i = (this.imaginaryNumber * a.realNumber - this.realNumber * a.imaginaryNumber) / d;
        this.realNumber = r;
        this.imaginaryNumber = i;
    }

    // Output values
    public void printValue(){
        String text = "" + this.realNumber;
        if(this.imaginaryNumber != 0){
            text += (this.imaginaryNumber > 0 ? "+":"") + this.imaginaryNumber + "i";
        }
        System.out.println(text);
    }
}
