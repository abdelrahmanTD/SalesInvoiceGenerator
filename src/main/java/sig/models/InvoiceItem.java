package sig.models;

/**
 *
 * @author abdelrahmanTalaat
 */
public class InvoiceItem {
    private String name;
    private double price;
    private int count;
    private Invoice invoice;

    public InvoiceItem(String name, double price, int count, Invoice invoice) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public double calculateTotal() {
        return price * count;
    }

    @Override
    public String toString() {
        return invoice.getId() + "," + name + "," + price + "," + count;
    }
}
