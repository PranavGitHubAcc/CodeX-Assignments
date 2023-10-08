public class MathOperations {
    static int addition(int x, int y) {
        int x_ = x;
        int y_ = y;
        return(x_+y_);
    }

    static double addition(double x, double y) {
        return(x+y);
    }

    static double addition(int x, double y) {
        return (x + y);
    }

    public static void main(String[] args) {
        System.out.println(addition(10, 20));
        System.out.println(addition(10.5, 20.9));
        System.out.println(addition(10,20.8));
    }
}