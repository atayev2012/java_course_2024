package lab_01;
public class Matrix {
    int x, y;
    ComplexNumber[][] arr;

    // initialization of matrix
    public Matrix(int a, int b){
        this.x = a;
        this.y = b;
        this.arr = new ComplexNumber[a][b];
    }

    // Randomly decide if number is negative or positive
    int signGen(){
        return ((int)(Math.random()*10))%2 == 0 ? 1:-1;
    }
    // randomly fill the matrix
    public void randGenerateFill(boolean complex, int range){
        for(int i=0; i<this.x; i++){
            for(int j=0; j<this.y; j++){
                // Fill randomly with max 2-digit numbers
                double complexNum = complex ? Math.round(Math.random()*range)*signGen():0;
                this.arr[i][j] = new ComplexNumber(Math.round(Math.random()*range)*signGen(),complexNum);
            }
        }
    }

    // Matrix addition
    public void addMatrix(Matrix a){
        // check if sizes are identical
        if(this.x == a.x && this.y == a.y){
            for(int i=0; i<this.x; i++){
                for(int j=0; j<this.y; j++){
                    this.arr[i][j].addComplex(a.arr[i][j]);
                }
            }
        }else{
            System.out.println("Addition cannot be performed! Wrong dimensions!");
            System.out.println(this.x + "x" + this.y + " vs. "+ a.x + "x" + a.y);
        }
    }

    // Matrix subtraction
    public void subMatrix(Matrix a){
        // check if sizes are identical
        if(this.x == a.x && this.y == a.y){
            for(int i=0; i<this.x; i++){
                for(int j=0; j<this.y; j++){
                    this.arr[i][j].subComplex(a.arr[i][j]);
                }
            }
        }else{
            System.out.println("Subtraction cannot be performed! Wrong dimensions!");
            System.out.println(this.x + "x" + this.y + " vs. "+ a.x + "x" + a.y);
        }
    }

    // Matrix multiplication
    public void multiplyMatrix(Matrix a){
        // check if sizes are acceptable
        if(this.y == a.x){
            ComplexNumber[][] newArr = new ComplexNumber[this.x][a.y];
            for(int i=0; i<this.x; i++){
                for(int j=0; j<a.y; j++){
                    newArr[i][j] = new ComplexNumber(0,0);
                    ComplexNumber temp = new ComplexNumber(0,0);
                    for(int k=0; k<this.y; k++){
                        temp.addComplex(this.arr[i][k]);
                        temp.multiplyComplex(a.arr[k][j]);
                        newArr[i][j].addComplex(temp);
                        temp.realNumber = 0;
                        temp.imaginaryNumber = 0;
                    }
                }
            }
            this.arr = newArr;
            this.y = a.y;
        }else{
            System.out.println("Multiplication cannot be performed! Wrong dimensions!");
            System.out.println(this.x + "x" + this.y + " vs. "+ a.x + "x" + a.y);
        }
    }

    // Transpose matrix
    public void transposeMatrix(){
        ComplexNumber[][] newArr = new ComplexNumber[this.y][this.x];
        int temp = this.x;
        for(int i=0; i<this.x; i++){
            for(int j=0; j<this.y; j++){
                newArr[j][i] = this.arr[i][j];
            }
        }
        this.x = this.y;
        this.y = temp;
        this.arr = newArr;
    }

    // print matrix out
    public void printMatrix(){
        for(int i=0; i<this.x; i++){
            for(int j=0; j<this.y; j++){
                this.arr[i][j].printValue();
            }
            System.out.print("\n");
        }
    }

    // Determinant
    ComplexNumber recursiveDet(ComplexNumber[][] arr, int size){
        if(size == 1){
            return arr[0][0];
        }
        int newSize = size-1;
        ComplexNumber det = new ComplexNumber(0,0);
        for(int i=0; i<size; i++){
            if(arr[0][i].realNumber == 0 && arr[0][i].imaginaryNumber == 0){
                continue;
            }
            ComplexNumber[][] newArr = new ComplexNumber[newSize][newSize];
            int x=0, y=0, step=0;
            while(y < newSize){
                while(x < newSize){
                    if(y==i){
                        step = 1;
                    }
                    newArr[x][y] = new ComplexNumber(0,0);
                    newArr[x][y].addComplex(arr[x+1][y+step]);
                    x++;
                }
                x=0;
                y++;
            }
            // -1 if odd i%2
            ComplexNumber multiplier = new ComplexNumber(1,0);
            if(i%2 != 0){
                multiplier.realNumber = -1;
            }
            multiplier.multiplyComplex(arr[0][i]);
            multiplier.multiplyComplex(this.recursiveDet(newArr, newSize));
            det.addComplex(multiplier);
        }
        return det;
    }

    public void determinantMatrix(){
        // Check if matrix is square
        if(this.x != this.y){
            System.out.println("The matrix is not square (nxn), therefore determinant cannot be found!");
        } else{
            recursiveDet(this.arr, this.x).printValue();
        }
    }
}
