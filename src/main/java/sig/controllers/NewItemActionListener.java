package sig.controllers;

import sig.models.Invoice;
import sig.models.InvoiceItem;
import sig.views.NewItemFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author abdelrahmanTalaat
 */
public class NewItemActionListener implements ActionListener {
    private NewItemFrame newItemFrame;
    public NewItemActionListener(NewItemFrame newItemFrame) {
        this.newItemFrame = newItemFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add Item":
                addNewItem();
                break;

            case "Cancel":
                cancel();
                break;
        }
    }

    private void addNewItem() {
        String name = newItemFrame.getItemField().getText();
        double price = Double.parseDouble(newItemFrame.getPriceField().getText());
        int count = Integer.parseInt(newItemFrame.getCountField().getText());

        int selectedInvoiceIndex = newItemFrame.getSigFrame().getInvoiceTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            Invoice invoice = newItemFrame.getSigFrame().getInvoiceByID(selectedInvoiceIndex + 1);
            invoice.getItems().add(new InvoiceItem(name, price, count, invoice));
            newItemFrame.getSigFrame().getInvoiceTotalLabel().setText(invoice.calculateTotal() + "");
            newItemFrame.getSigFrame().getItemTableModel().fireTableDataChanged();
            newItemFrame.getSigFrame().getInvoiceTableModel().fireTableDataChanged();
        }

        cancel();
    }

    private void cancel() {
        newItemFrame.setVisible(false);
        newItemFrame.dispose();
        newItemFrame = null;
    }
}
