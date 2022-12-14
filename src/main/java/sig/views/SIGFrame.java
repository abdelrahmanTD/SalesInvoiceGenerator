/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sig.views;

import sig.controllers.SIGActionListener;
import sig.models.Invoice;
import sig.models.InvoiceTableModel;
import sig.models.ItemsTableModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author abdelrahmanTalaat
 */
public class SIGFrame extends javax.swing.JFrame {

    /**
     * Creates new form SIGFrame
     */
    public SIGFrame() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2, dimension.height / 2 - getSize().height / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceIDLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        newInvoiceButton = new javax.swing.JButton();
        newInvoiceButton.addActionListener(listener);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(listener);
        addItemButton = new javax.swing.JButton();
        addItemButton.addActionListener(listener);
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Date", "Customer Name", "Total"
            }
        ));
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Price", "Count", "Total"
            }
        ));
        jScrollPane2.setViewportView(itemsTable);

        jLabel1.setText("Invoice #");

        jLabel2.setText("Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Total");

        newInvoiceButton.setText("New Invoice");

        deleteInvoiceButton.setText("Delete Invoice");

        addItemButton.setText("Add Item");

        deleteItemButton.setText("Delete Item");

        jMenu1.setText("File");

        loadMenuItem.setText("Load Files");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save Files");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceTotalLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerNameLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceDateLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceIDLabel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(newInvoiceButton)
                .addGap(50, 50, 50)
                .addComponent(deleteInvoiceButton)
                .addGap(174, 174, 174)
                .addComponent(addItemButton)
                .addGap(50, 50, 50)
                .addComponent(deleteItemButton)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invoiceIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invoiceDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customerNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invoiceTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(addItemButton)
                    .addComponent(deleteItemButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        int selectedInvoiceIndex = invoiceTable.getSelectedRow();

        invoiceIDLabel.setText(getInvoiceTable().getModel().getValueAt(selectedInvoiceIndex, 0).toString());
        invoiceDateLabel.setText(getInvoiceTable().getModel().getValueAt(selectedInvoiceIndex, 1).toString());
        customerNameLabel.setText(getInvoiceTable().getModel().getValueAt(selectedInvoiceIndex, 2).toString());
        invoiceTotalLabel.setText(getInvoiceTable().getModel().getValueAt(selectedInvoiceIndex, 3).toString());

        setItemTableModel(new ItemsTableModel(getInvoiceByID(selectedInvoiceIndex + 1)));
    }//GEN-LAST:event_invoiceTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SIGFrame sigFrame = new SIGFrame();
                sigFrame.setVisible(true);
                sigFrame.listener.load("Invoice.csv", "Items.csv");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceIDLabel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JButton newInvoiceButton;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    // Static Variables
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Custom Variables
    private final SIGActionListener listener = new SIGActionListener(this);
    private ArrayList<Invoice> invoices;
    private InvoiceTableModel invoiceTableModel;
    private ItemsTableModel itemTableModel;

    // UI Tables Getter
    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    // Table Models Getter and Setter
    public InvoiceTableModel getInvoiceTableModel() {
        return invoiceTableModel;
    }

    public void setInvoiceTableModel(InvoiceTableModel invoiceTableModel) {
        this.invoiceTableModel = invoiceTableModel;
        getInvoiceTable().setModel(invoiceTableModel);
    }

    public ItemsTableModel getItemTableModel() {
        return itemTableModel;
    }

    public void setItemTableModel(ItemsTableModel itemTableModel) {
        this.itemTableModel = itemTableModel;
        getItemsTable().setModel(itemTableModel);
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    // Custom Methods
    public ArrayList<Invoice> getInvoices() {
        if (invoices == null)
            invoices = new ArrayList<>();

        return invoices;
    }

    public Invoice getInvoiceByID(int id) {
        Invoice invoice = null;

        for (Invoice invoiceLine: getInvoices())
            if (invoiceLine.getId() == id) {
                invoice = invoiceLine;
                break;
            }

        return invoice;
    }

    public int getNextInvoiceID() {
        int invoicesCount = invoices.size();
        int nextID = invoices.get(invoicesCount - 1).getId() + 1;
        return nextID;
    }
}
