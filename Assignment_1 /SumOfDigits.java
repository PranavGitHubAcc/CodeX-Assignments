import java.util.Scanner;
public class SumOfDigits{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        var number = scanner.nextInt();
        var sum = 0;
        while(number!=0){
            sum += (number%10);
            number/=10;
        }
        System.out.println("The sum of the digits is: "+sum);
        scanner.close();
    }
}
