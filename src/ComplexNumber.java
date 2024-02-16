public class ComplexNumber {
    int realNumber, imaginaryNumber;

    public ComplexNumber(int r, int i){
        this.realNumber = r;
        this.imaginaryNumber = i;
    }

    public void printValue(){
        System.out.println(this.realNumber + (this.imaginaryNumber > 0 ? "+":"") + this.imaginaryNumber + "i");
    }
}
