/*
 * SampleFromColumnDialog.java
 *
 * Created on July 28, 2008, 12:47 PM
 */

package org.statcato.dialogs.data;

import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import org.statcato.random.SampleFromVector;
import java.util.Vector;

/**
 * A dialog for generating random samples from a column of data values.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.random.SampleFromVector
 * @since 1.0
 */
public class SampleFromColumnDialog extends StatcatoDialog {
   
    /** Creates new form SampleFromColumnDialog */
    public SampleFromColumnDialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        ParentSpreadsheet = app.getSpreadsheet();
        this.app = app;
        initComponents();
        customInitComponents();
        setHelpFile("data-random-random-user");
        name = "Random Samples from Column";
        description = "For drawing random samples from a set of data values " +
                "with or without replacement.";
        helpStrings.add("Specify a column containing data values to draw " +
                "samples from, column name(s) in which samples will be " +
                "stored, whether the samples are replaced after being " +
                "chosen, and the sample size.");
    }

    /**
     * Updates elements on the dialog so that they have the most
     * current values.  Called by {@link #setVisible} to make
     * sure the dialog displays current values when made visible again.
     * 
     * @see #setVisible(boolean)
     */
    @Override
    public void updateElements() {
        updateComboBox(ColumnComboBox); 
    }
    
    public void customInitComponents() {  
        ParentSpreadsheet.populateComboBox(ColumnComboBox);
       
        getRootPane().setDefaultButton(OKButton);
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ColumnComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        StoreTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        SeedTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ReplaceCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Random Samples from Column");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Sample from Column:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(68, 68, 68)
                .addComponent(ColumnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ColumnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Store Samples in:");

        jLabel5.setText("<html>\n- Enter valid column names separated by space.<br>\nFor a continuous range of columns, separate using dash (e.g. C1-C30).<br>\n- The random sampling process is repeated for each column.\n</html>\n");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(90, 90, 90)
                        .addComponent(StoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        jLabel4.setText("Random Generator Seed (optional):");

        jLabel1.setText("Number of Samples to Generate:");

        ReplaceCheckBox.setText("Sample With Replacement");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ReplaceCheckBox)
                        .addGap(107, 107, 107))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(nTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SeedTextField, nTextField});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReplaceCheckBox)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SeedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("sample from column");
        
        // get the column from which samples are drawn
        String yColumnLabel = ColumnComboBox.getSelectedItem().toString();
        if (yColumnLabel.equals("")) { // no input variable
            app.showErrorDialog("Select the column containing samples.");
            return;
        }
        int column = ParentSpreadsheet.parseColumnNumber(yColumnLabel);
        Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(column);
        StrColumnVector = HelperFunctions.removeNullCells(StrColumnVector);
               
        // get sample size
        int n = 0;
        try {
                n = Integer.parseInt(nTextField.getText());
                if (n <= 0)
                    throw new NumberFormatException();
                if (!ReplaceCheckBox.isSelected()) {    // no replacement
                    int max = StrColumnVector.size();
                    if (n > max) {
                        app.showErrorDialog("The sample size can be " +
                                "no larger than the number of possible " +
                                "data values in " + yColumnLabel + ".");
                        return;
                    }
                }
        }
        catch (NumberFormatException e) {
            app.showErrorDialog("Enter a valid sample size.");
            return;
        }
   
        // get and check column(s) for storing samples
        int storeColumnNum;
        String StoreColumn = StoreTextField.getText();
        
        Vector<Integer> nums = ParentSpreadsheet.getColumnNumbersFromString(StoreColumn);
        if (nums == null) {
            app.showErrorDialog(
                            "Invalid column(s) for storing results.");
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            storeColumnNum = nums.elementAt(i).intValue();
            // generate random samples
            SampleFromVector sampler = new SampleFromVector(StrColumnVector,
                    ReplaceCheckBox.isSelected());
            try {   // set seed if needed
                long seed = Long.parseLong(SeedTextField.getText());
                sampler.setSeed(seed);
            } catch (NumberFormatException e) {
            }
            
            Vector<String> results = new Vector<String>();
            for (int j = 0; j < n; ++j) {
                Cell sample = sampler.nextSample();
                results.addElement(sample.getContents());
            }
            ParentSpreadsheet.setColumn(storeColumnNum, results);      
        }
        
        app.addLogParagraph("Random Samples from Column " + yColumnLabel, 
                n + " samples stored in each of " + StoreColumn);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox ColumnComboBox;
    private javax.swing.JButton OKButton;
    private javax.swing.JCheckBox ReplaceCheckBox;
    private javax.swing.JTextField SeedTextField;
    private javax.swing.JTextField StoreTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nTextField;
    // End of variables declaration//GEN-END:variables
    
}
