/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WilcoxonSignedRankTestDialog.java
 *
 * Created on Jan 8, 2010, 1:12:00 PM
 */

package org.statcato.dialogs.stat.nonparametrics;

import org.statcato.StatcatoDialog;
import org.statcato.Statcato;
import org.statcato.DialogEdit;
import org.statcato.statistics.inferential.nonparametrics.WilcoxonSignedRankTest;
import org.statcato.spreadsheet.Cell;
import org.statcato.utils.HelperFunctions;

import javax.swing.ButtonGroup;
import java.util.Vector;

/**
 * A dialog for Wilcoxon signed rank test for one sample or two samples
 * of matched pairs.  
 *
 * Allows the user to specify data values of a single sample or matched pairs
 * of two samples.  The user must provide
 * the alternative hypothesis and significance level.
 * Computes and displays in log window the sample size, rank sums,
 * test statistic, cricial value, as well as the p-Value.
 * 
 * @author Margaret Yau
 * @see org.statcato.statistics.inferential.nonparametrics.WilcoxonSignedRankTest
 * @version %I%, %G%
 * @since 1.0
 */
public class WilcoxonSignedRankTestDialog extends StatcatoDialog {

    /** Creates new form WilcoxonSignedRankTestDialog */
    public WilcoxonSignedRankTestDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        app = (Statcato)parent;
        ParentSpreadsheet = app.getSpreadsheet();

        ParentSpreadsheet.populateComboBox(Sample1ComboBox);
        ParentSpreadsheet.populateComboBox(Sample2ComboBox);

        ButtonGroup group = new ButtonGroup();
        group.add(Sample2RadioButton);
        group.add(Sample1RadioButton);

        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-nonparam-wilcoxon");
        name = "Wilcoxon Signed Rank Test";
        description = "For performing the Wilcoxon Signed Rank Test for a single "
                + "population mean or matched pairs.";
        helpStrings.add("Select whether there is one sample or two sapmles of " +
                "matched pairs.  Select the column names in the drop-down menus.");
        helpStrings.add("Provide the alternative hypothesis and significance level.");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        HyMedianTextField = new javax.swing.JTextField();
        AltComboBox = new javax.swing.JComboBox();
        HyMedianLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Sample2ComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Sample2RadioButton = new javax.swing.JRadioButton();
        Sample1ComboBox = new javax.swing.JComboBox();
        ColumnComboBox = new javax.swing.JComboBox();
        Sample1RadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SigTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wilcoxon Signed Rank Test");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Alternative Hypothesis"));

        jLabel8.setText("<html>Alternative Hypothesis:  ");

        HyMedianTextField.setText("0");

        AltComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Less than", "Not Equal to", "Greater than" }));
        AltComboBox.setSelectedIndex(1);

        HyMedianLabel.setText("Hypothesized Median:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AltComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(HyMedianLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HyMedianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(AltComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HyMedianLabel)
                    .addComponent(HyMedianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        jLabel2.setText("Second Sample:");

        Sample2ComboBox.setEnabled(false);

        jLabel1.setText("First Sample:");

        Sample2RadioButton.setText("Two Samples (Matched Pairs)");
        Sample2RadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Sample2RadioButtonStateChanged(evt);
            }
        });

        Sample1ComboBox.setEnabled(false);

        Sample1RadioButton.setSelected(true);
        Sample1RadioButton.setText("One Sample ");
        Sample1RadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Sample1RadioButtonStateChanged(evt);
            }
        });

        jLabel4.setText("Sample in Column:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sample2RadioButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                            .addComponent(ColumnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addComponent(Sample1RadioButton, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Sample2ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sample1ComboBox, 0, 114, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Sample1RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColumnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(Sample2RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sample1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sample2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(124, 124, 124))
        );

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Significance"));

        jLabel6.setText("Significance level:");

        SigTextField.setText("0.05");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Updates elements on the dialog so that they have the most
     * current values.  Called by {@link #setVisible} to make
     * sure the dialog displays current values when made visible again.
     *
     * @see #setVisible(boolean)
     */
    @Override
    public void updateElements() {
        updateComboBox(Sample1ComboBox);
        updateComboBox(Sample2ComboBox);
        updateComboBox(ColumnComboBox);
    }

    private void Sample2RadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Sample2RadioButtonStateChanged
        if (Sample2RadioButton.isSelected()) {
            Sample1ComboBox.setEnabled(true);
            Sample2ComboBox.setEnabled(true);
        } else {
            Sample1ComboBox.setEnabled(false);
            Sample2ComboBox.setEnabled(false);
        }
}//GEN-LAST:event_Sample2RadioButtonStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("wilcoxon signed rank test");

        String heading = "Wilcoxon Signed Rank Test:";
        String text = "";

        String columnLabel1 = "", columnLabel2 = "";
        WilcoxonSignedRankTest st;

        double median = 0;

        // get hypothesized median
        try {
            median = Double.parseDouble(HyMedianTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a valid number for the hypothesized mean.");
            return;
        }
        // get type of test
        int typeTest = AltComboBox.getSelectedIndex();

        // get confidence level from dialog
        double significance;
        try {
            significance = Double.parseDouble(SigTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a number between 0 and 1 for the significance level.");
            return;
        }
        if (significance <= 0 || significance >= 1) {
            app.showErrorDialog("Enter a number between 0 and 1 for the confidence level.");
            return;
        }
        heading += "  Significance level = " + significance;

        // samples of matched pairs provided
        if (Sample2RadioButton.isSelected()) {
            // get data for first sample input column
            columnLabel1 = Sample1ComboBox.getSelectedItem().toString();
            Vector<Double> ColumnVector1 = new Vector<Double>();
            Vector<Double> ColumnVector2 = new Vector<Double>();

            if (columnLabel1.equals("")) { // no input variable
                app.showErrorDialog("Select sample 1 input column.");
                return;
            }
            int column = ParentSpreadsheet.parseColumnNumber(columnLabel1);
            Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(column);
            ColumnVector1 = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (ColumnVector1 == null) {
                app.showErrorDialog("Invalid input column " + columnLabel1 +
                        ": all data must be numbers.");
                return;
            }
            text += "Sample 1: " + columnLabel1 + "<br>";

            columnLabel2 = Sample2ComboBox.getSelectedItem().toString();
            if (columnLabel2.equals("")) { // no input variable
                app.showErrorDialog("Select sample 2 input column.");
                return;
            }
            column = ParentSpreadsheet.parseColumnNumber(columnLabel2);
            StrColumnVector = ParentSpreadsheet.getColumn(column);
            ColumnVector2 = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (ColumnVector2 == null) {
                app.showErrorDialog("Invalid input column " + columnLabel2 +
                        ": all data must be numbers.");
                return;
            }
            text += "Sample 2: " + columnLabel2 + "<br>";

            Vector<Double> DiffVector = HelperFunctions.ComputeDiffVector(
                    ColumnVector1, ColumnVector2);
            if (DiffVector == null) {
                app.showErrorDialog("There are unmatched pairs in the sample.");
                return;
            }

            text += "Difference of Matched Pairs " + columnLabel1 + " - " +
                    columnLabel2 + "<br>";

            st = new WilcoxonSignedRankTest(DiffVector, median, typeTest, significance);
        }
        // one sample provided
        else {
            // get data for first sample input column
            columnLabel1 = ColumnComboBox.getSelectedItem().toString();
            Vector<Double> ColumnVector1 = new Vector<Double>();

            if (columnLabel1.equals("")) { // no input variable
                app.showErrorDialog("Select sample input column.");
                return;
            }
            int column = ParentSpreadsheet.parseColumnNumber(columnLabel1);
            Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(column);
            ColumnVector1 = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (ColumnVector1 == null) {
                app.showErrorDialog("Invalid input column " + columnLabel1 +
                        ": all data must be numbers.");
                return;
            }
            text += "Single Sample: " + columnLabel1 + "<br>";

            st = new WilcoxonSignedRankTest(ColumnVector1, median, typeTest, significance);
        }

        // outputs
        text += "H<sub>0</sub>: = " + median + "<br>";
        text += "H<sub>1</sub>: ";
        if (typeTest == WilcoxonSignedRankTest.LESS)
            text += " &lt; ";
        else if (typeTest == WilcoxonSignedRankTest.GREATER)
            text += " &gt; ";
        else
            text += " &ne; ";
        text += median + "<br>";
        text += st;

        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);

        setVisible(false);
}//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_CancelButtonActionPerformed

    private void Sample1RadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Sample1RadioButtonStateChanged
        if (Sample1RadioButton.isSelected()) {
            ColumnComboBox.setEnabled(true);
        } else {
            ColumnComboBox.setEnabled(false);
        }
}//GEN-LAST:event_Sample1RadioButtonStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AltComboBox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox ColumnComboBox;
    private javax.swing.JLabel HyMedianLabel;
    private javax.swing.JTextField HyMedianTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox Sample1ComboBox;
    private javax.swing.JRadioButton Sample1RadioButton;
    private javax.swing.JComboBox Sample2ComboBox;
    private javax.swing.JRadioButton Sample2RadioButton;
    private javax.swing.JTextField SigTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
