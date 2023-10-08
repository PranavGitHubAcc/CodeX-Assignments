import java.util.Scanner;
public class Reverse_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        int size = inputString.length(); 
        String reverseString = "";
        for (int i = size - 1; i >= 0; i--) {
            reverseString += inputString.charAt(i); 
        }
        System.out.println(reverseString);
        scanner.close();
    }
}
