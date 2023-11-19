class Stock {
    String item;
    int qt;
    double rate;
    double amt;

    public Stock(String item, int qt, double rate) {
        this.item = item;
        this.qt = qt;
        this.rate = rate;
        this.amt = qt * rate;
    }

    public void display() {
        System.out.println("Item: " + item);
        System.out.println("Quantity: " + qt);
        System.out.println("Unit Price: " + rate);
        System.out.println("Stock Value: " + amt);
    }
}

class Purchase extends Stock {
    int pqt;
    double prate;

    public Purchase(String item, int qt, double rate, int pqt, double prate) {
        super(item, qt, rate);
        this.pqt = pqt;
        this.prate = prate;
    }

    public void update() {
        qt += pqt;
        if (rate != prate) {
            rate = prate;
        }
        amt = qt * rate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Purchase Quantity: " + pqt);
        System.out.println("Purchase Rate: " + prate);
        System.out.println("Updated Stock Details:");
        System.out.println("Updated Quantity: " + qt);
        System.out.println("Updated Unit Price: " + rate);
        System.out.println("Updated Stock Value: " + amt);
    }
}
public class StockM {
    public static void main(String[] args) {
        Purchase purchase = new Purchase("Item A", 100, 10.0, 50, 12.0);

        System.out.println("Stock Details Before Purchase:");
        purchase.display();

        purchase.update();

        System.out.println("\nStock Details After Purchase:");
        purchase.display();
    }
}
