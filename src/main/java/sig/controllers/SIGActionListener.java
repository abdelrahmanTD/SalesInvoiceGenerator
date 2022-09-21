package sig.controllers;

import sig.models.Invoice;
import sig.models.InvoiceItem;
import sig.models.InvoiceTableModel;
import sig.views.SIGFrame;
import sig.views.NewInvoiceFrame;
import sig.views.NewItemFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author abdelrahmanTalaat
 */
public class SIGActionListener implements ActionListener {
    private SIGFrame sigFrame;
    private NewInvoiceFrame newInvoiceFrame;
    private NewItemFrame newItemFrame;

    private File invoicesFile;
    private File itemsFile;

    // Constructor
    public SIGActionListener(SIGFrame sigFrame) {
        this.sigFrame = sigFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load Files":
                load(null, null);
                break;

            case "Save Files":
                save();
                break;

            case "New Invoice":
                createNewInvoice();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "Add Item":
                createItem();
                break;

            case "Delete Item":
                deleteItem();
                break;
        }
    }

    // Methods
    public void load(String invoicesPath, String itemsPath) {
        if (invoicesPath == null && itemsPath == null) {
            JOptionPane.showMessageDialog(sigFrame, "Select header file first, then select line file.", "Invoice files", JOptionPane.WARNING_MESSAGE);
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(sigFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                invoicesFile = fc.getSelectedFile();
                result = fc.showOpenDialog(sigFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemsFile = fc.getSelectedFile();
                }
            }
        } else {
            invoicesFile = new File(invoicesPath);
            itemsFile = new File(itemsPath);
        }

        if (invoicesFile != null && itemsFile != null) {
            try {
                List<String> invoicesLines = Files.lines(Paths.get(invoicesFile.getAbsolutePath())).collect(Collectors.toList());
                List<String> itemsLines = Files.lines(Paths.get(itemsFile.getAbsolutePath())).collect(Collectors.toList());
                sigFrame.getInvoices().clear();

                for (String line: invoicesLines) {
                    String [] lineParts = line.split(",");
                    int invID = Integer.parseInt(lineParts[0]);
                    Date invDate = SIGFrame.dateFormat.parse(lineParts[1]);
                    String custName = lineParts[2];
                    sigFrame.getInvoices().add(new Invoice(invID, invDate, custName));
                }

                for (String line: itemsLines) {
                    String [] lineParts = line.split(",");
                    int invID = Integer.parseInt(lineParts[0]);
                    String name = lineParts[1];
                    double price = Double.parseDouble(lineParts[2]);
                    int count = Integer.parseInt(lineParts[3]);
                    Invoice invoice = sigFrame.getInvoiceByID(invID);
                    invoice.getItems().add(new InvoiceItem(name, price, count, invoice));
                }

                loadTestConsole(invoicesLines, itemsLines);
                sigFrame.setInvoiceTableModel(new InvoiceTableModel(sigFrame.getInvoices()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(sigFrame, "Cannot find file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(sigFrame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(sigFrame, "Something wrong with parsing", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void loadTestConsole(List<String> invoices, List<String> items) {
        System.out.println("Invoices File");
        for (String invoice: invoices)
            System.out.println(invoice);

        System.out.println();
        System.out.println("Items File");
        for (String item: items)
            System.out.println(item);
    }

    private void save() {
        String invoices = "";
        String items = "";

        for (Invoice invoice: sigFrame.getInvoices()) {
            String invoiceLine = invoice.toString();
            invoices += invoiceLine + "\n";

            for (InvoiceItem item: invoice.getItems()) {
                String itemLine = item.toString();
                items += itemLine + "\n";
            }
        }

        if (invoicesFile == null && itemsFile == null) {
            JOptionPane.showMessageDialog(sigFrame, "Select where to save files", "Invoice & Items Files", JOptionPane.INFORMATION_MESSAGE);
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(sigFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                invoicesFile = fileChooser.getSelectedFile();
                result = fileChooser.showOpenDialog(sigFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemsFile = fileChooser.getSelectedFile();
                }
            }
        } else {
            try {
                FileWriter headerFileWriter = new FileWriter(invoicesFile);
                FileWriter linesFileWriter = new FileWriter(itemsFile);
                headerFileWriter.write(invoices);
                linesFileWriter.write(items);
                headerFileWriter.flush();
                linesFileWriter.flush();
                headerFileWriter.close();
                linesFileWriter.close();
                JOptionPane.showMessageDialog(sigFrame, "Saved successfully", "Files Saving Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(sigFrame, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(sigFrame, "File couldn't be saved", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    // Invoice Table Methods
    private void createNewInvoice() {
        newInvoiceFrame = new NewInvoiceFrame();
        newInvoiceFrame.setSigFrame(sigFrame);
        newInvoiceFrame.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedInvoice = sigFrame.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            sigFrame.getInvoices().remove(selectedInvoice);
            sigFrame.getInvoiceTableModel().fireTableDataChanged();
        }
    }

    // Items Table Methods
    public void createItem() {
        newItemFrame = new NewItemFrame();
        newItemFrame.setSigFrame(sigFrame);
        newItemFrame.setVisible(true);
    }

    public void deleteItem() {
        int selectedItem = sigFrame.getItemsTable().getSelectedRow();
        if (selectedItem != -1) {
            Invoice invoice = sigFrame.getItemTableModel().getInvoice();
            invoice.getItems().remove(selectedItem);
            sigFrame.getInvoiceTotalLabel().setText(invoice.calculateTotal() + "");
            sigFrame.getItemTableModel().fireTableDataChanged();
            sigFrame.getInvoiceTableModel().fireTableDataChanged();
        }
    }
}
