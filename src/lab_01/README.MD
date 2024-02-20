# Lab - 01: Complex Numbers & Matrices

## Description
The task was to write Java Classes to work with Complex Numbers and Matrices with corresponding operations:

**Complex Numbers (Methods):**
- [Addition (addComplex)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/ComplexNumber.java#L21)
- [Subtraction (subComplex)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/ComplexNumber.java#L26)
- [Multiplication (multiplyComplex)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/ComplexNumber.java#L33)
- [Division (divideComplex)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/ComplexNumber.java#L41)

**Matrices (Methods):**
- [Addition (addMatrix)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Matrix.java#L29)
- [Subtraction (subMatrix)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Matrix.java#L44)
- [Multiplication (multiplyMatrix)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Matrix.java#L59)
- [Transpose (transposeMatrix)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Matrix.java#L81)
- [Determinant (determinantMatrix)](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Matrix.java#L141)

All methods for Complex Numbers and Matrices are void methods, that update the original value and have no returns.

All numbers should be introduced through ComplexNumbers Class to the Matrix.

Class named [Run](https://github.com/atayev2012/java_course_2024/blob/main/src/lab_01/Run.java) contains sample test of the methods

Sample Output (Run.java):
```
Complex numbers operations:
0 + 7 = 7 
7 - 4+9i = 3-9i 
3-9i x 4+9i = 93-9i 
93-9i / 4+9i = 3-9i 

Matrix operations:
Matrix A:
8-1i -3i 1-1i 
9-2i -3+3i 2+5i 
-3+3i 4-2i -8-5i 

Matrix C:
-5-8i -1-4i 4-2i 
-4+5i 6+8i 6-7i 
2+2i 4+3i -7+3i 

Matrix A = A+C:
3-9i -1-7i 5-3i 
5+3i 3+11i 8-2i 
-1+5i 8+1i -15-2i 

Matrix A = A-C:
8-1i -3i 1-1i 
9-2i -3+3i 2+5i 
-3+3i 4-2i -8-5i 

Matrix B:
4 -4 
1 2 
3 -3 

Matrix A = A*B:
35-10i -35+1i 
39+10i -48-1i 
-32-5i 44-1i 

Matrix Transpose(A):
35-10i 39+10i -32-5i 
-35+1i -48-1i 44-1i 

Matrix C:
-5-8i -1-4i 4-2i 
-4+5i 6+8i 6-7i 
2+2i 4+3i -7+3i 

det(C):
350+905i
```