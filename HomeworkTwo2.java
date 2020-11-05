package vanilla.demo;
import java.util.Scanner;

public class HomeworkTwo2 {
    public static void main(String[] args) {
        int n;
        System.out.println("请输入方阵阶数n:");
        Scanner input= new Scanner(System.in);
        n= input.nextInt();
        printMatrix(n);
    }
    public static void printMatrix(int n){
        int i, j;
        double b;
        for (i=1;i<=n;i++){
            for (j=1;j<=n;j++){
                b = Math.random();
                if (b>0.5) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}