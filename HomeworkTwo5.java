package vanilla.demo;
import java.util.Scanner;

public class HomeworkTwo5 {
    public static void main(String[] args) {
        double[][] matrix = new double[4][4];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagonal(matrix));
    }

    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m[1].length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}