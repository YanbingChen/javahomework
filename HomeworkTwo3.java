package vanilla.demo;

import java.util.Scanner;

public class HomeworkTwo3 {
    public static void main(String[] args) {
        int[] count={0,1,2,3,4,5,6,7,8,9};
        int[] numlist=new int[100];
        int numbercount;
        for (int i=0; i<100; i++){
            numlist[i]=(int)(Math.random()*10);
        }
        for (int j=0; j<=9; j++){
            numbercount = 0;
            for (int i=0; i<100; i++)
                if (numlist[i]==count[j]) numbercount++;
            System.out.println(j+"出现了"+numbercount+"次");
        }
    }
}
