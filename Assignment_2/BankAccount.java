public class BankAccount {
    int accNumber;
    int bal;

    public BankAccount() {
        accNumber = 1000101;
        bal = 0;
    }

    public BankAccount(int num) {
        accNumber = 1000101;
        bal = num;
    }

    public BankAccount(int acc, int num) {
        accNumber = acc;
        bal = num;
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        System.out.print("Default constructor: ");
        System.out.println(a.accNumber + " " + a.bal);
        System.out.print("Parameterized constructor(1): ");
        BankAccount b = new BankAccount(100);
        System.out.println(b.accNumber + " " + b.bal);
        System.out.print("Parameterized constructor(2): ");
        BankAccount c = new BankAccount(10101, 200);
        System.out.println(c.accNumber+" " +c.bal);
    }
    
}
