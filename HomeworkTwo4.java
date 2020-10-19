package vanilla.demo;

import java.util.Scanner;

public class HomeworkTwo4 {
    public static void main(String[] args) {
        double[] array= new double[10];
        System.out.println("请输入10个数字");
        for(int i=0; i<10; i++){
            Scanner input =new Scanner(System.in);
            array[i] = input.nextDouble();
        }
        int minindex = indexOfSmallestElement(array);
        System.out.println("最小元素的下标为："+minindex);
    }
    //不是整数数组吗为什么函数里给的是double型Orz
    public static int indexOfSmallestElement(double[] array){
        int min=0;
        for (int i=0; i<array.length; i++)
            if (array[min]>array[i]) min=i;
        return min;
    }
}
