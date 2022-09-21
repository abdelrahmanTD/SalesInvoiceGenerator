package sig.models;

import sig.views.SIGFrame;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abdelrahmanTalaat
 */
public class Invoice {
    private int id;
    private Date date;
    private String customerName;
    private ArrayList<InvoiceItem> items;

    public Invoice(int id, Date date, String customerName) {
        this.id = id;
        this.date = date;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceItem> getItems() {
        if (items == null)
            items = new ArrayList<>();

        return items;
    }

    public double calculateTotal() {
        double total = 0;

        for(InvoiceItem item: getItems())
            total += item.calculateTotal();

        return total;
    }

    @Override
    public String toString() {
        return id + "," + SIGFrame.dateFormat.format(date) + "," + customerName;
    }
}
