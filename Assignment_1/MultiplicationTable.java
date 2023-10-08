import java.util.Scanner;
public class MultiplicationTable{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        var number = scanner.nextInt();
        var i = 1;
        while(i!=11){
            System.out.println(number+" X "+i+" = "+(i*number));
            i++;
        }
        scanner.close();
    }
}
