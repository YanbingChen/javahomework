package vanilla.demo;

import java.util.Date;

public class HomeworkThree1 {
    public static void main(String[] args) {
    long time=10000;
    for (int i=1; i<=8; i++){
        Date date = new Date(time);
        time*=10;
        System.out.println(date.toString());
        }
    }
}