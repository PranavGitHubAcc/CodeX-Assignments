class Worker {
    String name;
    double basic;

    public Worker(String name, double basic) {
        this.name = name;
        this.basic = basic;
    }

    public void display() {
        System.out.println("Worker Name: " + name);
        System.out.println("Basic Pay: " + basic);
    }
}

class Wages extends Worker {
    double hrs;
    double rate;
    double wage;

    public Wages(String name, double basic, double hrs, double rate) {
        super(name, basic);
        this.hrs = hrs;
        this.rate = rate;
        wage = 0.0;
    }

    public double overtime() {
        if (hrs > 40) {
            return (hrs - 40) * rate;
        }
        return 0.0;
    }

    @Override
    public void display() {
        super.display();
        double overtimeAmount = overtime();
        wage = basic + overtimeAmount;
        System.out.println("Hours Worked: " + hrs);
        System.out.println("Rate per Hour: " + rate);
        System.out.println("Overtime Amount: " + overtimeAmount);
        System.out.println("Total Wage: " + wage);
    }
}

public class WagesCalc {
    public static void main(String[] args) {
        Wages worker = new Wages("Shyam Kumar", 5200.0, 45, 20.0);

        worker.display();
    }
}
