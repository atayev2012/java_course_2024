public class Matrix {
    int x, y;
    ComplexNumber[][] arr;

    // initialization of matrix
    public Matrix(int a, int b){
        this.x = a;
        this.y = b;
        this.arr = new ComplexNumber[a][b];
    }

    // randomly fill the matrix
    public void randGenerateFill(boolean complex){
        for(int i=0; i<this.x; i++){
            for(int j=0; j<this.y; j++){
                // Fill randomly with max 2-digit numbers
                int complexNum = complex ? (int)(Math.random()*10):0;
                this.arr[i][j] = new ComplexNumber((int)(Math.random()*10),complexNum);
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
            int temp_sum = 0;
            ComplexNumber[][] newArr = new ComplexNumber[this.x][a.y];
            for(int i=0; i<this.x; i++){
                for(int j=0; j<a.y; j++){
                    newArr[i][j] = new ComplexNumber(0,0);
                    for(int k=0; k<this.y; k++){
                        this.arr[i][k].multiplyComplex(a.arr[k][j]);
                        newArr[i][j].addComplex(this.arr[i][k]);
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

}
