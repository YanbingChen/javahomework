package vanilla.demo;

import java.util.Date;

public class HomeworkThree2 {
    //用于测试Account
    public static void main(String[] args){
        Account account1 = new Account(1122,20000);
        account1.setAnnualInterestRate(4.5);
        account1.withDraw(2500);
        account1.deposit(3000);
        System.out.println("账户"+account1.getId()+"的余额为："+account1.getBalance()+
                "，月利息为："+account1.getMonthlyInterest()+"，开户日期为"+account1.getDateCreated());
    }
}

class Account{
    //为账号定义一个名为id的int类型私有数据域标识账号
    private int id=0;
    //名为balance的double型私有数据域表示余额
    private double balance=0;
    //名为annualInterestRate的double型私有数据域存储当前利率，假设所有帐户都有相同的利率
    private double annualInterestRate=0;
    //名为dateCreated的Date类型私有数据域，存储账户的开户日期
    private Date dateCreated;
    //用于创建默认账户的无参构造方法
    public Account(){
        dateCreated=new Date();
    }
    //用于创建具有指定id和初始余额的账户构造方法
    public Account(int id, double balance){
        this.id = id;
        this.balance =balance;
        dateCreated=new Date();
    }
    //id、balance和annualInterestRate的访问器方法和修改器方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    //dateCreated的访问器方法
    public Date getDateCreated() {
        return dateCreated;
    }
    //一个名为getMonthlyInterestRate的方法，返回月利率
    public double getMonthlyInterestRate() {
        double MonthlyInterestRate=annualInterestRate/12;
        return MonthlyInterestRate;
    }
    //一个名为getMonthlyInterest的方法，返回月利息
    public double getMonthlyInterest(){
        double MonthlyInterest =balance*getMonthlyInterestRate()/100;
        return MonthlyInterest;
    }
    //一个名为withDraw的方法，从账户提取指定额度
    public void withDraw(double money){
        balance-=money;
    }
    //一个名为deposit的方法向账户存储指定额度
    public void deposit(double money){
        balance+=money;
    }
}