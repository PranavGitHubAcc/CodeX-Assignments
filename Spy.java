import java.util.Scanner;
public class Spy{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        var number = scanner.nextInt();
        var sum = 0;
        var product = 1;
        while(number!=0){
            sum += number%10;
            product *= number%10;
            number /=10;
        }
        if(product == sum){
            System.out.println("spy number");
        }
        else{
            System.out.println("not a spy number");
        }
        scanner.close();
    }
}