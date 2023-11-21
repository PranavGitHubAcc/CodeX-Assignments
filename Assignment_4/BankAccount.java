import java.util.*;

class Bank {
    String name;
    int accno;
    double p;

    public Bank(String name, int accno, double principal) {
        this.name = name;
        this.accno = accno;
        this.p = principal;
    }

    public void display() {
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accno);
    }
}

class Account extends Bank {
    double amt;

    public Account(String name, int accno, double principal) {
        super(name, accno, principal);
        amt = 0;
    }

    public void deposit(double amount) {
        amt = amount;
        p += amt;
    }

    public void withdraw(double amount) {
        if (amount > p) {
            System.out.println("INSUFFICIENT BALANCE");
        } else {
            amt = amount;
            p -= amt;
            if (p < 500) {
                double penalty = (500 - p) / 10;
                p -= penalty;
            }
        }

    }

    @Override
    public void display() {
        super.display();
        System.out.println("Principal Amount: " + p);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        
        Account account = new Account("Agastya", 19365, 36000.0);
        
         System.out.println();
       
        account.display();
        System.out.println();
         System.out.println("************************");

        account.deposit(500.0);

       
        account.display();
        System.out.println();

        System.out.println("************************");

      
        account.withdraw(300.0);

        
        account.display();
    }
}
