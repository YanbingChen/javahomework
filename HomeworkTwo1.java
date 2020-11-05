package vanilla.demo;
import java.util.Scanner;

public class HomeworkTwo1 {
    public static void main(String[] args) {
        int number;
        System.out.println("请输入一个整数:");
        Scanner input= new Scanner(System.in);
        number= input.nextInt();
        reverse(number);
    }
    public static void reverse(int number){
        int reversenum = 0;
        //从number的最后一位取起，依次放入reversenum中，每放一个新的数前面就进位
        while (number!= 0){
            reversenum = reversenum*10 + number % 10;
            number = number / 10;
        }
        System.out.println("反序数为："+reversenum);
    }
}
