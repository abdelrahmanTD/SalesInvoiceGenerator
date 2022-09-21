package sig.models;

import sig.views.SIGFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author abdelrahmanTalaat
 */
public class InvoiceTableModel extends AbstractTableModel {
    private ArrayList<Invoice> invoices;

    public InvoiceTableModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return "";
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice invoice = invoices.get(rowIndex);

        switch (columnIndex) {
            case 0: return invoice.getId();
            case 1: return SIGFrame.dateFormat.format(invoice.getDate());
            case 2: return invoice.getCustomerName();
            case 3: return invoice.calculateTotal();
            default: return "";
        }
    }
}
