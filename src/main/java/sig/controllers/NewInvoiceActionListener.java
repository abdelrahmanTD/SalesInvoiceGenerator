package sig.controllers;

import sig.models.Invoice;
import sig.views.NewInvoiceFrame;
import sig.views.SIGFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author abdelrahmanTalaat
 */
public class NewInvoiceActionListener implements ActionListener {
    private NewInvoiceFrame newInvoiceFrame;

    public NewInvoiceActionListener(NewInvoiceFrame newInvoiceFrame) {
        this.newInvoiceFrame = newInvoiceFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add Invoice":
                System.out.println("here");
                addNewInvoice();
                break;

            case "Cancel":
                cancel();
                break;
        }
    }

    public void addNewInvoice() {
        try {
            Date date = SIGFrame.dateFormat.parse(newInvoiceFrame.getDateField().getText());
            String customerName = newInvoiceFrame.getCustomerNameField().getText();
            int invoiceID = newInvoiceFrame.getSigFrame().getNextInvoiceID();
            newInvoiceFrame.getSigFrame().getInvoices().add(new Invoice(invoiceID, date, customerName));
            newInvoiceFrame.getSigFrame().getInvoiceTableModel().fireTableDataChanged();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(newInvoiceFrame, "Date Format is wrong, should be DD-MM-YYYY", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        cancel();
    }

    public void cancel() {
        newInvoiceFrame.setVisible(false);
        newInvoiceFrame.dispose();
        newInvoiceFrame = null;
    }
}
