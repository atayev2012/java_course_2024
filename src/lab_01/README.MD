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
1+3i 2+8i 2 
3-3i 4+5i -9+9i 
-7i -3-3i -8+8i 

Matrix C:
3+6i 2-3i -7-2i 
4-10i -2+1i 8+8i 
-9+3i -2-3i 5 

Matrix A = A+C:
4+9i 4+5i -5-2i 
7-13i 2+6i -1+17i 
-9-4i -5-6i -3+8i 

Matrix A = A-C:
1+3i 2+8i 2 
3-3i 4+5i -9+9i 
-7i -3-3i -8+8i 

Matrix B:
4 2 
-6 -1 
2 -5 

Matrix A = A*B:
-4-36i 72i 
-30-24i 138-84i 
2+6i 62-154i 

Matrix Transpose(A):
-4-36i -30-24i 2+6i 
72i 138-84i 62-154i 

Matrix C:
3+6i 2-3i -7-2i 
4-10i -2+1i 8+8i 
-9+3i -2-3i 5 

det(C):
-133+324i 
```