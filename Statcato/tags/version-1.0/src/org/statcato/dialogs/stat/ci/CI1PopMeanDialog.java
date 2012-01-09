/*
 * CI1PopMeanDialog.java
 *
 * Created on May 20, 2008, 11:52 AM
 */

package org.statcato.dialogs.stat.ci;

import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.statistics.inferential.*;
import org.statcato.utils.HelperFunctions;
import java.util.*;
import javax.swing.*;
import org.statcato.statistics.BasicStatistics;

/**
 * A dialog for creating confidence intervals for one population mean, 
 * given the confidence level and whether the population standard 
 * deviation is known or unknown.
 * Allows the user to specify the data values in a column or provide
 * summary data.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.CIOnePopMeanSigmaUnknown
 * @see org.statcato.statistics.inferential.CIOnePopMeanSigmaKnown
 * @since 1.0
 */
public class CI1PopMeanDialog extends StatcatoDialog {

    /** Creates new form CI1PopMeanDialog */
    public CI1PopMeanDialog(java.awt.Frame parent, boolean modal,
            Statcato mTab) {
        super(parent, modal);
        initComponents();
        
        app = mTab;
        ParentSpreadsheet = app.getSpreadsheet(); 
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(SampleRadioButton);
        group1.add(SummaryRadioButton);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(KnownRadioButton);
        group2.add(UnknownRadioButton);
                
        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-ci-1mean");
        name = "Confidence Interval: One Population Mean";
        description = "For computing the confidence intervals for a population " +
                "mean in one population, whether the population standard " +
                "deviation is known or unknown. ";
        helpStrings.add("If your sample data is available in one column, " +
                "select the Samples in column: radio button, and " +
                "select the column name in the given drop-down menu.");
        helpStrings.add("If individual sample data is not available, " +
                "select the Summarized sample data radio button and provide " +
                "the sample size, mean, and standard deviation " +
                "(only if population standard deviation is unknown).");
        helpStrings.add("Enter the confidence level (between 0 and 1).");
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
        jPanel2 = new javax.swing.JPanel();
        UnknownRadioButton = new javax.swing.JRadioButton();
        KnownRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        SigmaTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        sTextField = new javax.swing.JTextField();
        SampleSizeTextField = new javax.swing.JTextField();
        sLabel = new javax.swing.JLabel();
        SampleRadioButton = new javax.swing.JRadioButton();
        SampleSizeLabel = new javax.swing.JLabel();
        SampleMeanTextField = new javax.swing.JTextField();
        SummaryRadioButton = new javax.swing.JRadioButton();
        SampleMeanLabel = new javax.swing.JLabel();
        InputTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ConfidenceTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confidence Interval: One Population Mean");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Population Standard Deviation"));

        UnknownRadioButton.setSelected(true);
        UnknownRadioButton.setText("Unknown");
        UnknownRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                UnknownRadioButtonStateChanged(evt);
            }
        });

        KnownRadioButton.setText("Known:");
        KnownRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                KnownRadioButtonStateChanged(evt);
            }
        });

        jLabel4.setText("Population standard deviation:");

        SigmaTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UnknownRadioButton)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(KnownRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SigmaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SigmaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KnownRadioButton))
                .addGap(5, 5, 5)
                .addComponent(UnknownRadioButton)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        sTextField.setEnabled(false);

        SampleSizeTextField.setEnabled(false);

        sLabel.setText("Standard deviation:");
        sLabel.setEnabled(false);

        SampleRadioButton.setSelected(true);
        SampleRadioButton.setText("Samples in column:");
        SampleRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SampleRadioButtonStateChanged(evt);
            }
        });

        SampleSizeLabel.setText("Size:");
        SampleSizeLabel.setEnabled(false);

        SampleMeanTextField.setEnabled(false);

        SummaryRadioButton.setText("Summarized sample data:");
        SummaryRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SummaryRadioButtonStateChanged(evt);
            }
        });

        SampleMeanLabel.setText("Mean:");
        SampleMeanLabel.setEnabled(false);

        jLabel8.setText("<html>\nEnter valid column names separated by space.<br>\nFor a continuous range of columns, separate using dash (e.g. C1-C30).<br>\n</html>\n");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SampleRadioButton)
                    .addComponent(InputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SummaryRadioButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SampleMeanLabel)
                                    .addComponent(SampleSizeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SampleSizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(SampleMeanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(sTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(sLabel))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SampleMeanTextField, SampleSizeTextField, sTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SampleRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SummaryRadioButton)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SampleSizeLabel)
                            .addComponent(SampleSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SampleMeanLabel)
                            .addComponent(SampleMeanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Confidence"));

        jLabel6.setText("Confidence level:");

        jLabel1.setText("0 - 1.00 (e.g. 0.95)");

        ConfidenceTextField.setText("0.95");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SampleRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SampleRadioButtonStateChanged
        if (SampleRadioButton.isSelected()) {
            InputTextField.setEnabled(true);
        }
        else {
            InputTextField.setEnabled(false);
        }
    }//GEN-LAST:event_SampleRadioButtonStateChanged

    private void SummaryRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SummaryRadioButtonStateChanged
        if (SummaryRadioButton.isSelected()) {
            SampleSizeLabel.setEnabled(true);
            SampleSizeTextField.setEnabled(true);
            SampleMeanLabel.setEnabled(true);
            SampleMeanTextField.setEnabled(true);
            if (UnknownRadioButton.isSelected()) {
                sLabel.setEnabled(true);
                sTextField.setEnabled(true);
            }
            else {
                sLabel.setEnabled(false);
                sTextField.setEnabled(false);
            }
        }
        else  {
            SampleSizeLabel.setEnabled(false);
            SampleSizeTextField.setEnabled(false);
            SampleMeanLabel.setEnabled(false);
            SampleMeanTextField.setEnabled(false);
            sLabel.setEnabled(false);
            sTextField.setEnabled(false);
        }           
    }//GEN-LAST:event_SummaryRadioButtonStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("CI 1 mean");
        
        int n = 0;
        double s = 0, mean = 0, confidenceLevel;
        Vector<ConfidenceInterval> vectorsCI = new Vector<ConfidenceInterval>();
        Vector<String> labels = new Vector<String>();
        double stdev = 0;

        String heading = "Confidence Interval - One population mean:";
        String text = "";
        
        // get confidence level from dialog
        try {
            confidenceLevel = Double.parseDouble(ConfidenceTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a number between 0 and 1 for the confidence level.");
            return;
        }
        if (confidenceLevel <= 0 || confidenceLevel >= 1) {
            app.showErrorDialog("Enter a number between 0 and 1 for the confidence level.");
            return;
        }

        heading += "  confidence level = " + confidenceLevel;

        // get standard deviations
        if (KnownRadioButton.isSelected()) {    // sigma known
            text += "<b>&sigma; known</b><br>";
            try {
                stdev = Double.parseDouble(SigmaTextField.getText());
                text += "Assumed population standard deviation &sigma; = " + stdev + "<br>";
            }
            catch (NumberFormatException e) {
                app.showErrorDialog("Enter a valid population standard deviation.");
                return;
            }
        }
        
        // get input
        if (SampleRadioButton.isSelected()) {
            if (InputTextField.getText().length() == 0) {
                app.showErrorDialog("No input column is provided.");
                return;
            } else {
                // get data for selected input column
                int[] inputColumnNumbers =
                    ParentSpreadsheet.getColumnNumbersArrayFromString(InputTextField.getText());
                if (inputColumnNumbers.length == 0) { // invalid column
                    app.showErrorDialog("Invalid input column name(s).");
                    return;
                }
                
                text += "Input: ";
                for (int i = 0; i < inputColumnNumbers.length; ++i) {
                    Vector<Cell> StrColumnVector =
                            ParentSpreadsheet.getColumn(inputColumnNumbers[i]);
                    String columnLabel =
                            ParentSpreadsheet.getColumnFullLabel(inputColumnNumbers[i]);
                    Vector<Double> ColumnVector =
                            HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
                    if (ColumnVector == null) {
                        app.showErrorDialog("Invalid input column " + columnLabel +
                                ": all data must be numbers.");
                        return;
                    }
                    if (HelperFunctions.isEmptyVector(ColumnVector)) {
                        app.showErrorDialog("Empty input column " + columnLabel +
                                ".");
                        return;
                    }
                    text += columnLabel + " ";
                    n = BasicStatistics.Nnonmissing(ColumnVector);
                    mean = BasicStatistics.mean(ColumnVector).doubleValue();
                    s = BasicStatistics.stdev(ColumnVector).doubleValue();
                    if (KnownRadioButton.isSelected()) {
                        vectorsCI.addElement(
                                new CIOnePopMeanSigmaKnown(confidenceLevel, n, mean, stdev));
                    }
                    else {
                        vectorsCI.addElement(
                                new CIOnePopMeanSigmaUnknown(confidenceLevel, n, mean, s));
                    }
                    labels.addElement(columnLabel);
                }
                text += "<br>";
            }
        } else {
            // get summary data
            try {
                n = Integer.parseInt(SampleSizeTextField.getText());
                mean = Double.parseDouble(SampleMeanTextField.getText());
                if (UnknownRadioButton.isSelected())
                    stdev = Double.parseDouble(sTextField.getText());

                if (KnownRadioButton.isSelected()) {
                    vectorsCI.addElement(
                            new CIOnePopMeanSigmaKnown(confidenceLevel, n, mean, stdev));
                }
                else {
                    vectorsCI.addElement(
                            new CIOnePopMeanSigmaUnknown(confidenceLevel, n, mean, stdev));
                }
                labels.addElement("summary");
            } catch (NumberFormatException e) {
                app.showErrorDialog("Invalid summary data.");
                return;
            }
            text += "Input: Summary data" + "<br>";
        }
        
        if (KnownRadioButton.isSelected()) {    // sigma known            
            text += "<br><table border='1'>";
            text += "<tr><td>Var</td><td>N</td><td>Mean</td><td>Margin of Error</td><td>";
                text += HelperFunctions.formatFloat(confidenceLevel * 100, 2) + "%CI</td></tr>";
            for (int i = 0; i < vectorsCI.size(); ++i) {
                CIOnePopMeanSigmaKnown CI = (CIOnePopMeanSigmaKnown)vectorsCI.elementAt(i);
                text += "<tr>";
                text += "<td>" + labels.elementAt(i) + "</td><td>" +
                        CI.getN() + "</td><td>" +
                        HelperFunctions.formatFloat(CI.center(), 3) + "</td><td>" +
                        HelperFunctions.formatFloat(CI.marginOfError(), 3) + "</td><td>" +
                        CI.toString() + "</td></tr>";
            }
            text += "</table>";
        }
        else {  // sigma unknown
            text += "<b>&sigma; unknown</b><br>";
            
            text += "<br><table border='1'>";
            text += "<tr><td>Var</td><td>N</td><td>Mean</td><td>Stdev</td><td>Margin of Error</td><td>";
            text += HelperFunctions.formatFloat(confidenceLevel * 100, 2) + "%CI</td></tr>";
            for (int i = 0; i < vectorsCI.size(); ++i) {
                CIOnePopMeanSigmaUnknown CI2 = (CIOnePopMeanSigmaUnknown)vectorsCI.elementAt(i);
                text += "<tr>";
                text += "<td>" + labels.elementAt(i) + "</td><td>" +
                        CI2.getN()+ "</td><td>" +
                        HelperFunctions.formatFloat(CI2.center(), 3) + "</td><td>" +
                        HelperFunctions.formatFloat(CI2.getStdev(), 3) +
                        "</td><td>" + HelperFunctions.formatFloat(CI2.marginOfError(), 3)
                        + "</td><td>" + CI2.toString() + "</td></tr>";
            }
            text += "</table>";
        }

        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void KnownRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_KnownRadioButtonStateChanged
        if (KnownRadioButton.isSelected()) {
            SigmaTextField.setEnabled(true);
        }
        else {
            SigmaTextField.setEnabled(false);
        }
    }//GEN-LAST:event_KnownRadioButtonStateChanged

    private void UnknownRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_UnknownRadioButtonStateChanged
        if (UnknownRadioButton.isSelected()) {
            if (SummaryRadioButton.isSelected()) {
                sLabel.setEnabled(true);
                sTextField.setEnabled(true);
            }
            else {
                sLabel.setEnabled(false);
                sTextField.setEnabled(false);
            }
        }
        else {
            sLabel.setEnabled(false);
            sTextField.setEnabled(false);
        }
    }//GEN-LAST:event_UnknownRadioButtonStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField ConfidenceTextField;
    private javax.swing.JTextField InputTextField;
    private javax.swing.JRadioButton KnownRadioButton;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel SampleMeanLabel;
    private javax.swing.JTextField SampleMeanTextField;
    private javax.swing.JRadioButton SampleRadioButton;
    private javax.swing.JLabel SampleSizeLabel;
    private javax.swing.JTextField SampleSizeTextField;
    private javax.swing.JTextField SigmaTextField;
    private javax.swing.JRadioButton SummaryRadioButton;
    private javax.swing.JRadioButton UnknownRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel sLabel;
    private javax.swing.JTextField sTextField;
    // End of variables declaration//GEN-END:variables
    
}
