public class Prime {
    static boolean isPrime(int num) {
        int i = 2;
        int count = 0;
        while (i < num) {
            count += (num % i == 0) ? 1 : 0;
            i++;
        }
        if (count == 0) {
            System.out.print(num + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("The prime numbers are: ");
        int count = 1;
        for (int i = 2; i < 100 && count <= 10; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
    }
}
