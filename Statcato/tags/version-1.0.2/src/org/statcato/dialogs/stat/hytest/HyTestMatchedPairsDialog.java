/*
 * HyTestMatchedPairsDialog.java
 *
 * Created on June 12, 2008, 11:41 AM
 */

package org.statcato.dialogs.stat.hytest;

import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.statistics.inferential.*;
import org.statcato.utils.HelperFunctions;
import java.util.*;
import javax.swing.*;
import org.statcato.statistics.BasicStatistics;

/**
 * A dialog for testing claims about the mean of the differences 
 * between a population of matched pairs.
 * Allows the user to specify data samples in columns of a Datasheet,
 * or provide summary data values.  The user must also provide
 * the confidence level, alternative hypothesis, and hypothesized 
 * mean.
 * Computes and displays in log window the significance level, 
 * critical value, test statistic, and p-Value.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.HypothesisTestMatchedPairs
 * @since 1.0
 */
public class HyTestMatchedPairsDialog extends StatcatoDialog {
 
    /** Creates new form HyTestMatchedPairsDialog */
    public HyTestMatchedPairsDialog(java.awt.Frame parent, boolean modal,
            Statcato mTab) {
        super(parent, modal);
        initComponents();
        
        app = mTab;
        ParentSpreadsheet = app.getSpreadsheet(); 
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(SampleRadioButton);
        group1.add(SummaryRadioButton);        
        
        ButtonGroup group4 = new ButtonGroup();
        group4.add(SigRadioButton);
        group4.add(ConfRadioButton);
        
        ParentSpreadsheet.populateComboBox(Sample1ComboBox);
        ParentSpreadsheet.populateComboBox(Sample2ComboBox);
        
        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-hytest-matched");
        name = "Hypothesis Test: Matched Pairs";
        description = "For performing calculations for testing claims about " +
                "the mean of the differences between a population of matched pairs.";
        helpStrings.add("The sample data can be inputted in one of two ways...");
        helpStrings.add("Samples in columns: The sample matched pairs are " +
                "provided in two columns, and the two values in a matched " +
                "pair are provided in the same row.");
        helpStrings.add("Summarized Sample Data: The sample size, mean, and " +
                "standard deviation are provided.");
        helpStrings.add("Specify the significance or confidence level.");
        helpStrings.add("Select the form of alternative hypothesis.");
        helpStrings.add("Enter the hypothesized mean difference (hypothesized " +
                "mean of differences for the population of all matched pairs).");
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
        updateComboBox(Sample1ComboBox);
        updateComboBox(Sample2ComboBox);
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
        SizeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Sample2ComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SampleRadioButton = new javax.swing.JRadioButton();
        StdevTextField = new javax.swing.JTextField();
        Sample1ComboBox = new javax.swing.JComboBox();
        MeanTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SummaryRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        HyMeanTextField = new javax.swing.JTextField();
        AltComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        SigPanel = new javax.swing.JPanel();
        SigLabel = new javax.swing.JLabel();
        ConfidenceTextField = new javax.swing.JTextField();
        ConfRadioButton = new javax.swing.JRadioButton();
        SigRadioButton = new javax.swing.JRadioButton();
        SigTextField = new javax.swing.JTextField();
        ConfLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hypothesis Test: Matched Pairs");

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

        SizeTextField.setEnabled(false);

        jLabel2.setText("Second Sample:");

        jLabel1.setText("First Sample:");

        jLabel4.setText("Mean:");

        SampleRadioButton.setSelected(true);
        SampleRadioButton.setText("Samples in Columns");
        SampleRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SampleRadioButtonStateChanged(evt);
            }
        });

        StdevTextField.setEnabled(false);

        MeanTextField.setEnabled(false);

        jLabel5.setText("Standard Deviation:");

        SummaryRadioButton.setText("Summarized Sample Data");
        SummaryRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SummaryRadioButtonStateChanged(evt);
            }
        });

        jLabel3.setText("Sample Size:");

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
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StdevTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(MeanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(SizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sample2ComboBox, 0, 98, Short.MAX_VALUE)
                                    .addComponent(Sample1ComboBox, 0, 98, Short.MAX_VALUE))))))
                .addContainerGap(27, Short.MAX_VALUE))
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
                    .addComponent(SizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MeanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StdevTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Alternative Hypothesis"));

        jLabel8.setText("Alternative Hypothesis:");

        HyMeanTextField.setText("0");

        AltComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Less than", "Not Equal to", "Greater than" }));
        AltComboBox.setSelectedIndex(1);

        jLabel9.setText("Hypothesized Mean:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AltComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HyMeanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
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
                    .addComponent(jLabel9)
                    .addComponent(HyMeanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        SigPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Significance"));

        SigLabel.setText("0 - 1.00 (e.g. 0.05)");

        ConfidenceTextField.setText("0.95");
        ConfidenceTextField.setEnabled(false);
        ConfidenceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ConfidenceTextFieldFocusLost(evt);
            }
        });

        ConfRadioButton.setText("Confidence Level:");
        ConfRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ConfRadioButtonStateChanged(evt);
            }
        });

        SigRadioButton.setSelected(true);
        SigRadioButton.setText("Significance Level:");
        SigRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SigRadioButtonStateChanged(evt);
            }
        });

        SigTextField.setText("0.05");
        SigTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SigTextFieldFocusLost(evt);
            }
        });

        ConfLabel.setText("0 - 1.00 (e.g. 0.95)");
        ConfLabel.setEnabled(false);

        javax.swing.GroupLayout SigPanelLayout = new javax.swing.GroupLayout(SigPanel);
        SigPanel.setLayout(SigPanelLayout);
        SigPanelLayout.setHorizontalGroup(
            SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SigPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfRadioButton)
                    .addComponent(SigRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SigLabel)
                    .addComponent(ConfLabel))
                .addGap(29, 29, 29))
        );
        SigPanelLayout.setVerticalGroup(
            SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SigPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SigRadioButton)
                    .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SigLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfRadioButton)
                    .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SummaryRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SummaryRadioButtonStateChanged
        if (SummaryRadioButton.isSelected()) {
            SizeTextField.setEnabled(true);
            MeanTextField.setEnabled(true);
            StdevTextField.setEnabled(true);
        } else {
            SizeTextField.setEnabled(false);
            MeanTextField.setEnabled(false);
            StdevTextField.setEnabled(false);
        }
    }//GEN-LAST:event_SummaryRadioButtonStateChanged

    private void SampleRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SampleRadioButtonStateChanged
        if (SampleRadioButton.isSelected()) {
            Sample1ComboBox.setEnabled(true);
            Sample2ComboBox.setEnabled(true);
        } else {
            Sample1ComboBox.setEnabled(false);
            Sample2ComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_SampleRadioButtonStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("hypothesis test matched pairs");
        
        int n = 0;
        double s = 0, mean = 0, confidenceLevel;
        
        String heading = "Hypothesis Test - Matched Pairs:";
        String text = "";
        
        if (ConfRadioButton.isSelected()) {
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
        }
        else {
            // get confidence level from dialog
            try {
                confidenceLevel = 1 - Double.parseDouble(SigTextField.getText());
            } catch (NumberFormatException e) {
                app.showErrorDialog("Enter a number between 0 and 1 for the significance level.");
                return;
            }
            if (confidenceLevel <= 0 || confidenceLevel >= 1) {
                app.showErrorDialog("Enter a number between 0 and 1 for the significance level.");
                return;
            }
        }
        
        heading += "  confidence level = " + 
                String.format("%."+
                HelperFunctions.getNumDecimalPlaces(ConfidenceTextField.getText())+"f", 
                confidenceLevel);
        
        String columnLabel1 = "", columnLabel2 = "";
        
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
            
            n = BasicStatistics.Nnonmissing(DiffVector);
            mean = BasicStatistics.mean(DiffVector).doubleValue();
            s = BasicStatistics.stdev(DiffVector).doubleValue();
        }
        // summary sample data provided
        else {
            try {
                n = Integer.parseInt(SizeTextField.getText());
                if (n < 1)
                    throw new NumberFormatException();
                mean = Double.parseDouble(MeanTextField.getText());
                s = Double.parseDouble(StdevTextField.getText());
            } catch (NumberFormatException e) {
                app.showErrorDialog("Invalid summary data.");
                return;
            }
            text += "Input: Summary data" + "<br>";
        }
        
        double mu = 0;
        
        // get hypothesized mean
        try {
            mu = Double.parseDouble(HyMeanTextField.getText());            
        }
        catch (NumberFormatException e) {
            app.showErrorDialog("Enter a valid number for the hypothesized mean.");
            return;
        }
        // get type of test
        int typeTest = AltComboBox.getSelectedIndex();
        
        HypothesisTestMatchedPairs ht = new 
                    HypothesisTestMatchedPairs(n, mu, s, 
                    confidenceLevel, typeTest);
                text += "Null hypothesis: &mu; = " + mu + "<br>";
                text += "Alternative hypothesis: &mu; ";
                if (typeTest == HypothesisTest.LEFT_TAIL)
                    text += "&lt;";
                else if (typeTest == HypothesisTest.RIGHT_TAIL)
                    text += "&gt;";
                else
                    text += "&ne;";
                text += " " + mu + "<br>";
                
                text += "<br><table border='1'>";
                text += "<tr><td>N</td><td>Sample Mean</td><td>Stdev</td>";
                text += "<td>Significance Level</td></td><td>Critical Value</td>" +
                        "<td>Test Statistic t</td>" + "<td>p-Value</td></tr>";
                text += "<tr><td>" + n + "</td><td>" +
                    HelperFunctions.formatFloat(mean, 3) + "</td><td>" +
                    HelperFunctions.formatFloat(s, 3) + "</td><td>" +
                    HelperFunctions.formatFloat(1-confidenceLevel, 2)  + 
                    "</td><td>" + ht.criticalValue()
                    + "</td><td>" + HelperFunctions.formatFloat(ht.testStatistics(mean), 3)
                    + "</td><td>" + HelperFunctions.formatFloat(ht.pValue(mean), 4)
                    + "</td></tr></table>";
        
        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ConfidenceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConfidenceTextFieldFocusLost
        try {
            String confString = ConfidenceTextField.getText();
            double conf = Double.parseDouble(confString);
            double sig = 1.0 - conf;
            SigTextField.setText(
                    String.format("%."+HelperFunctions.getNumDecimalPlaces(confString)+"f", sig));
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_ConfidenceTextFieldFocusLost

    private void ConfRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ConfRadioButtonStateChanged
        if (ConfRadioButton.isSelected()) {
            ConfidenceTextField.setEnabled(true);
            ConfLabel.setEnabled(true);
        } else {
            ConfidenceTextField.setEnabled(false);
            ConfLabel.setEnabled(false);
        }
    }//GEN-LAST:event_ConfRadioButtonStateChanged

    private void SigRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SigRadioButtonStateChanged
        if (SigRadioButton.isSelected()) {
            SigTextField.setEnabled(true);
            SigLabel.setEnabled(true);
        } else {
            SigTextField.setEnabled(false);
            SigLabel.setEnabled(false);
        }
    }//GEN-LAST:event_SigRadioButtonStateChanged

    private void SigTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SigTextFieldFocusLost
        try {
            String sigString = SigTextField.getText();
            double sig = Double.parseDouble(sigString);
            double conf = 1 - sig;
            ConfidenceTextField.setText(
                    String.format("%."+HelperFunctions.getNumDecimalPlaces(sigString)+"f", conf));
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_SigTextFieldFocusLost
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AltComboBox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel ConfLabel;
    private javax.swing.JRadioButton ConfRadioButton;
    private javax.swing.JTextField ConfidenceTextField;
    private javax.swing.JTextField HyMeanTextField;
    private javax.swing.JTextField MeanTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox Sample1ComboBox;
    private javax.swing.JComboBox Sample2ComboBox;
    private javax.swing.JRadioButton SampleRadioButton;
    private javax.swing.JLabel SigLabel;
    private javax.swing.JPanel SigPanel;
    private javax.swing.JRadioButton SigRadioButton;
    private javax.swing.JTextField SigTextField;
    private javax.swing.JTextField SizeTextField;
    private javax.swing.JTextField StdevTextField;
    private javax.swing.JRadioButton SummaryRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    
}
