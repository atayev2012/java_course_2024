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
