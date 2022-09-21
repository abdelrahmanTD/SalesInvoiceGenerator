package sig.models;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author abdelrahmanTalaat
 */
public class ItemsTableModel extends AbstractTableModel {
    private String [] columnsName = {"Item", "Count", "Price Total", "Total"};
    private Invoice invoice;

    public ItemsTableModel(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public int getRowCount() {
        return invoice.getItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItem line = invoice.getItems().get(rowIndex);

        switch (columnIndex) {
            case 0: return line.getName();
            case 1: return line.getCount();
            case 2: return line.getPrice();
            case 3: return line.calculateTotal();
            default: return "";
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
