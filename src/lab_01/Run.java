package lab_01;

public class Run {
    public static void main(String[] args) {

        System.out.println("Complex numbers operations:");
        // Complex Numbers
        ComplexNumber num1 = new ComplexNumber(); // (0,0)
        ComplexNumber num2 = new ComplexNumber(7); // (7,0)
        ComplexNumber num3 = new ComplexNumber(4,9); // (4,9) 4+9i

        // Addition
        num1.printValue();
        System.out.print("+ ");
        num2.printValue();
        System.out.print("= ");

        num1.addComplex(num2);
        num1.printValue();
        System.out.println();


        // Subtraction
        num1.printValue();
        System.out.print("- ");
        num3.printValue();
        System.out.print("= ");

        num1.subComplex(num3);
        num1.printValue();
        System.out.println();


        // Multiplication
        num1.printValue();
        System.out.print("x ");
        num3.printValue();
        System.out.print("= ");

        num1.multiplyComplex(num3);
        num1.printValue();
        System.out.println();


        // Division
        num1.printValue();
        System.out.print("/ ");
        num3.printValue();
        System.out.print("= ");

        num1.divideComplex(num3);
        num1.printValue();
        System.out.println("\n");

        System.out.println("Matrix operations:");
        // Matrices
        Matrix arr1 = new Matrix(3,3);
        Matrix arr2 = new Matrix(3,2);
        Matrix arr3 = new Matrix(3,3);

        // randomly fill with data
        arr1.randGenerateFill(true, 10); // complex_number = true, number range [-10...10]
        arr2.randGenerateFill(false, 10);
        arr3.randGenerateFill(true, 10);

        // Addition
        System.out.println("Matrix A:");
        arr1.printMatrix();
        System.out.println("\nMatrix C:");
        arr3.printMatrix();
        System.out.println("\nMatrix A = A+C:");
        arr1.addMatrix(arr3);
        arr1.printMatrix();

        // Subtraction
        System.out.println("\nMatrix A = A-C:");
        arr1.subMatrix(arr3);
        arr1.printMatrix();

        // Multiplication
        System.out.println("\nMatrix B:");
        arr2.printMatrix();
        System.out.println("\nMatrix A = A*B:");
        arr1.multiplyMatrix(arr2);
        arr1.printMatrix();

        // Transpose
        System.out.println("\nMatrix Transpose(A):");
        arr1.transposeMatrix();
        arr1.printMatrix();

        // Determinant
        System.out.println("\nMatrix C:");
        arr3.printMatrix();
        System.out.println("\ndet(C):");
        arr3.determinantMatrix();

    }
}