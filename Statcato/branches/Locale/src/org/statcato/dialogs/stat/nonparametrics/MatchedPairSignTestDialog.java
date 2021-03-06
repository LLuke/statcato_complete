/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MatchedPairSignTestDialog.java
 *
 * Created on Oct 16, 2009, 10:55:54 AM
 */

package org.statcato.dialogs.stat.nonparametrics;

import org.statcato.statistics.inferential.nonparametrics.SignTest;
import org.statcato.StatcatoDialog;
import org.statcato.Statcato;
import org.statcato.DialogEdit;
import org.statcato.spreadsheet.Cell;
import org.statcato.utils.HelperFunctions;
import java.util.Vector;
import javax.swing.ButtonGroup;

/**
 * A dialog for the matched-pair sign test (distribution-free, two-sample).
 * Allows the user to specify data samples in two column of a Datasheet,
 * or provide summary data values.  The user must also provide
 * the alternative hypothesis.
 * Computes and displays in log window the number of positive and
 * negative signs as well as the p-Value.
 *
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.nonparametrics.SignTest
 * @since 1.0
 * @author Margaret Yau
 */
public class MatchedPairSignTestDialog extends StatcatoDialog {

    /** Creates new form MatchedPairSignTestDialog */
    public MatchedPairSignTestDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        app = (Statcato)parent;
        ParentSpreadsheet = app.getSpreadsheet();

        ParentSpreadsheet.populateComboBox(Sample1ComboBox);
        ParentSpreadsheet.populateComboBox(Sample2ComboBox);

        ButtonGroup group = new ButtonGroup();
        group.add(SampleRadioButton);
        group.add(SummaryRadioButton);

        HyMedianLabel.setVisible(false);
        HyMedianTextField.setVisible(false);

        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-nonparam-2signtest");
        name = "2-Sample Matched-Pair Sign Test";
        description = "For performing the matched-pair sign test for two population means.";
        helpStrings.add("If individual samples are entered in " +
                "columns of the datasheet, select the Samples in column: radio " +
                "button, and select the column names in the drop-down menus.");
        helpStrings.add("To use summary statistics of the sample data, " +
                "select the Summarized sample data: radio button, and " +
                "input the number of positive and negative signs " +
                "in the provided text fields.");
        helpStrings.add("Provide the alternative hypothesis.");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NumNegativeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Sample2ComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SampleRadioButton = new javax.swing.JRadioButton();
        Sample1ComboBox = new javax.swing.JComboBox();
        NumPositiveTextField = new javax.swing.JTextField();
        SummaryRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        HyMedianTextField = new javax.swing.JTextField();
        AltComboBox = new javax.swing.JComboBox();
        HyMedianLabel = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("2-Sample Matched-Pair Sign Test");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        NumNegativeTextField.setEnabled(false);

        jLabel2.setText("Second Sample:");

        jLabel1.setText("First Sample:");

        jLabel4.setText("Number of Positive (+):");

        SampleRadioButton.setSelected(true);
        SampleRadioButton.setText("Samples in Columns");
        SampleRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SampleRadioButtonStateChanged(evt);
            }
        });

        NumPositiveTextField.setEnabled(false);

        SummaryRadioButton.setText("Summarized Sample Data");
        SummaryRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SummaryRadioButtonStateChanged(evt);
            }
        });

        jLabel3.setText("Number of Negative (-):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SummaryRadioButton)
                    .addComponent(SampleRadioButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumPositiveTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(NumNegativeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Sample2ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Sample1ComboBox, 0, 114, Short.MAX_VALUE))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SampleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Sample1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Sample2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SummaryRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NumNegativeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NumPositiveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

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
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap(25, Short.MAX_VALUE))
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
    }

    private void SampleRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SampleRadioButtonStateChanged
        if (SampleRadioButton.isSelected()) {
            Sample1ComboBox.setEnabled(true);
            Sample2ComboBox.setEnabled(true);
        } else {
            Sample1ComboBox.setEnabled(false);
            Sample2ComboBox.setEnabled(false);
        }
}//GEN-LAST:event_SampleRadioButtonStateChanged

    private void SummaryRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SummaryRadioButtonStateChanged
        if (SummaryRadioButton.isSelected()) {
            NumPositiveTextField.setEnabled(true);
            NumNegativeTextField.setEnabled(true);
        } else {
            NumPositiveTextField.setEnabled(false);
            NumNegativeTextField.setEnabled(false);
        }
}//GEN-LAST:event_SummaryRadioButtonStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("matched-pair sign test");

        String heading = "Matched-Pair Sign Test:";
        String text = "";

        String columnLabel1 = "", columnLabel2 = "";
        SignTest st;

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

        // samples of matched pairs provided
        if (SampleRadioButton.isSelected()) {
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

            st = new SignTest(DiffVector, median, typeTest);
        }
        // summary sample data provided
        else {
            int numPositive, numNegative;
            try {
                numPositive = Integer.parseInt(NumPositiveTextField.getText());
                numNegative = Integer.parseInt(NumNegativeTextField.getText());
            } catch (NumberFormatException e) {
                app.showErrorDialog("Invalid summary data.");
                return;
            }
            text += "Input: Summary data" + "<br>";
            st = new SignTest(numPositive, numNegative, median, typeTest);
        }

        // outputs
        text += "H<sub>0</sub>: &mu;<sub>1</sub> - &mu;<sub>2</sub> OR ";
        text += "median<sub>pairwise differences</sub> = " + median + "<br>";
        text += "H<sub>1</sub>: &mu;<sub>1</sub> - &mu;<sub>2</sub> OR ";
        text += "median<sub>pairwise differences</sub>";
        if (typeTest == SignTest.LESS)
            text += " &lt; ";
        else if (typeTest == SignTest.GREATER)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AltComboBox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel HyMedianLabel;
    private javax.swing.JTextField HyMedianTextField;
    private javax.swing.JTextField NumNegativeTextField;
    private javax.swing.JTextField NumPositiveTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox Sample1ComboBox;
    private javax.swing.JComboBox Sample2ComboBox;
    private javax.swing.JRadioButton SampleRadioButton;
    private javax.swing.JRadioButton SummaryRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
