package lab_01;
public class ComplexNumber {
    double realNumber, imaginaryNumber;

    public ComplexNumber(double r, double i){
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
        double r = this.realNumber * a.realNumber - this.imaginaryNumber * a.imaginaryNumber;
        double i = this.realNumber * a.imaginaryNumber + this.imaginaryNumber * a.realNumber;
        this.realNumber = r;
        this.imaginaryNumber = i;
    }

    // Division of complex numbers
    public void divideComplex(ComplexNumber a){
        if(a.realNumber !=0 || a.imaginaryNumber != 0){
            double d = a.realNumber * a.realNumber + a.imaginaryNumber * a.imaginaryNumber;
            double r = (this.realNumber * a.realNumber + this.imaginaryNumber * a.imaginaryNumber) / d;
            double i = (this.imaginaryNumber * a.realNumber - this.realNumber * a.imaginaryNumber) / d;
            this.realNumber = r;
            this.imaginaryNumber = i;
        }else{
            System.out.println("Cannot divide by Zero!");
        }

    }

    // Output values
    public void printValue(){
        String text = "";

        if(this.realNumber == 0){
            text += this.imaginaryNumber == 0 ? "0":String.format("%.0fi", this.imaginaryNumber);
        }else{
            text += String.format("%.0f", this.realNumber);
            if(imaginaryNumber != 0){
                text += String.format("%s%.0fi",(this.imaginaryNumber > 0 ? "+":""), this.imaginaryNumber);
            }
        }
        text += "\t";
        System.out.print(text);
    }
}
