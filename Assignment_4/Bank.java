import java.util.*;

public class Bank{

    public static void main(String args[]){
        BankAccount a = new BankAccount();
        System.out.println("The default values are:\n"+ "Account no. = " + a.accountno+ " and Balance = " + a.balance + "\n\n");

        BankAccount b = new BankAccount(80000);
        System.out.println("When 1 parameter is given, the values are:\n"+ "Account no. = " + b.accountno+ " and Balance = " + b.balance+ "\n\n");

        BankAccount c = new BankAccount(175896,80000);
        System.out.println("When 2 parameters are given, the values are:\n"+ "Account no. = " + c.accountno+ " and Balance = " + c.balance+ "\n\n");

    }
}

class BankAccount{

     int accountno;
     int balance;
     
     public BankAccount(){
        accountno = 102593;
        balance = 500;
     }

     public BankAccount(int bal){
        accountno = 102593;
        balance = bal;

     }

     public BankAccount(int acc, int bal){
        accountno = acc;
        balance = bal;

     }
}
