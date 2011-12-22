/*
 * CI2PopVarDialog.java
 *
 * Created on June 12, 2008, 3:49 PM
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
 * A dialog for creating confidence intervals for two population variances, 
 * given the confidence level.
 * Allows the user to specify the data values in the Datasheet or provide
 * summary data.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.CI2PopVar
 * @since 1.0
 */
public class CI2PopVarDialog extends StatcatoDialog {

    /** Creates new form CI2PopVarDialog */
    public CI2PopVarDialog(java.awt.Frame parent, boolean modal,
            Statcato mTab) {
        super(parent, modal);
        initComponents();
        
        app = mTab;
        ParentSpreadsheet = app.getSpreadsheet(); 
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(Sample1ColRadioButton);
        group1.add(Sample2ColRadioButton);
        group1.add(SummaryRadioButton);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(VarRadioButton);
        group2.add(StdevRadioButton);
        
        ParentSpreadsheet.populateComboBox(LabelsComboBox);
        ParentSpreadsheet.populateComboBox(ValuesComboBox);
        ParentSpreadsheet.populateComboBox(Pop1ComboBox);
        ParentSpreadsheet.populateComboBox(Pop2ComboBox);
        
        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-ci-2var");
        name = "Confidence Interval: Two Population Variances";
        description = "For computing the confidence intervals for the ratio of " +
                "two population variances.";
        helpStrings.add("The sample data can be inputted in one of three ways...");
        helpStrings.add("Samples in one column: The population labels of " +
                "samples are in one column of the datasheet, and the " +
                "individual samples are in another column.");
        helpStrings.add("Samples in two columns: The samples of the two " +
                "population are in two separate columns.");
        helpStrings.add("Summarized sample data: The sample size and standard " +
                "deviation/variance of each sample are provided " +
                "(instead of individual sample values).");
        helpStrings.add("The confidence level must be between 0 and 1. ");
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
        updateComboBox(LabelsComboBox);
        updateComboBox(ValuesComboBox);
        updateComboBox(Pop1ComboBox);
        updateComboBox(Pop2ComboBox);    
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
        ConfidenceTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Pop2ComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ValuesComboBox = new javax.swing.JComboBox();
        Sample2ColRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        LabelsComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Pop1ComboBox = new javax.swing.JComboBox();
        Sample1ColRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        n1TextField = new javax.swing.JTextField();
        n2TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SummaryRadioButton = new javax.swing.JRadioButton();
        StdevRadioButton = new javax.swing.JRadioButton();
        VarRadioButton = new javax.swing.JRadioButton();
        Var1TextField = new javax.swing.JTextField();
        Stdev1TextField = new javax.swing.JTextField();
        Stdev2TextField = new javax.swing.JTextField();
        Var2TextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confidence Interval: 2-Population Variances");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Confidence"));

        ConfidenceTextField.setText("0.95");

        jLabel13.setText("0 - 1.00 (e.g. 0.95)");

        jLabel12.setText("Confidence Level:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ConfidenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        Pop2ComboBox.setEnabled(false);

        jLabel3.setText("Population 1:");

        jLabel1.setText("Labels in column:");

        Sample2ColRadioButton.setText("Samples in two columns");
        Sample2ColRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Sample2ColRadioButtonStateChanged(evt);
            }
        });

        jLabel4.setText("Population 2:");

        jLabel2.setText("Values in column:");

        Pop1ComboBox.setEnabled(false);

        Sample1ColRadioButton.setSelected(true);
        Sample1ColRadioButton.setText("Samples in one column");
        Sample1ColRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Sample1ColRadioButtonStateChanged(evt);
            }
        });

        jLabel6.setText("Population 2:");

        jLabel5.setText("Population 1:");

        n1TextField.setEnabled(false);

        n2TextField.setEnabled(false);

        jLabel7.setText("Sample Size");

        SummaryRadioButton.setText("Summarized sample data");
        SummaryRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SummaryRadioButtonStateChanged(evt);
            }
        });

        StdevRadioButton.setSelected(true);
        StdevRadioButton.setText("Standard Deviation");
        StdevRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StdevRadioButtonStateChanged(evt);
            }
        });

        VarRadioButton.setText("Variance");
        VarRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VarRadioButtonStateChanged(evt);
            }
        });

        Var1TextField.setEnabled(false);

        Stdev1TextField.setEnabled(false);

        Stdev2TextField.setEnabled(false);

        Var2TextField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(n1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(n2TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(SummaryRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stdev2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Stdev1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StdevRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Var2TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(VarRadioButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Var1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                    .addComponent(Sample1ColRadioButton)
                    .addComponent(Sample2ColRadioButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ValuesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Pop2ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Pop1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Stdev1TextField, Stdev2TextField});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Var1TextField, Var2TextField});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sample1ColRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ValuesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(Sample2ColRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Pop1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pop2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(SummaryRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StdevRadioButton)
                            .addComponent(VarRadioButton)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Var1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Stdev2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Var2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(n1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Stdev1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(n2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SummaryRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SummaryRadioButtonStateChanged
        if (SummaryRadioButton.isSelected()) {
            n1TextField.setEnabled(true);
            n2TextField.setEnabled(true);
            if (StdevRadioButton.isSelected()) {
                Stdev1TextField.setEnabled(true);
                Stdev2TextField.setEnabled(true);
                Var1TextField.setEnabled(false);
                Var2TextField.setEnabled(false);
            }
            else {
                Stdev1TextField.setEnabled(false);
                Stdev2TextField.setEnabled(false);
                Var1TextField.setEnabled(true);
                Var2TextField.setEnabled(true);
            }     
        } else {
            n1TextField.setEnabled(false);
            n2TextField.setEnabled(false);
            Stdev1TextField.setEnabled(false);
            Stdev2TextField.setEnabled(false);
            Var1TextField.setEnabled(false);
            Var2TextField.setEnabled(false);
        }
    }//GEN-LAST:event_SummaryRadioButtonStateChanged

    private void Sample1ColRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Sample1ColRadioButtonStateChanged
        if (Sample1ColRadioButton.isSelected()) {
            LabelsComboBox.setEnabled(true);
            ValuesComboBox.setEnabled(true);
        } else {
            LabelsComboBox.setEnabled(false);
            ValuesComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_Sample1ColRadioButtonStateChanged

    private void Sample2ColRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Sample2ColRadioButtonStateChanged
        if (Sample2ColRadioButton.isSelected()) {
            Pop1ComboBox.setEnabled(true);
            Pop2ComboBox.setEnabled(true);
        } else {
            Pop1ComboBox.setEnabled(false);
            Pop2ComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_Sample2ColRadioButtonStateChanged

    @SuppressWarnings("unchecked") 
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("CI 2 variance");
        
        int n1 = 0, n2 = 0;   // sample sizes
        double var1 = 0, var2 = 0;    // sample variances
        double stdev1 = 0, stdev2 = 0;  // sample standard deviations
        double confidenceLevel;
        
        String heading = "Confidence Intervals - Two population variances:";
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
        
        // summary values
        if (SummaryRadioButton.isSelected()) {
            try {
                n1 = Integer.parseInt(n1TextField.getText());
                n2 = Integer.parseInt(n2TextField.getText());
                if (n1 < 1 || n2 < 1)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.showErrorDialog("Enter a positive integer for the sample sizes.");
                return;
            }

            if (StdevRadioButton.isSelected()) {
                try {
                    stdev1 = Double.parseDouble(Stdev1TextField.getText());
                    stdev2 = Double.parseDouble(Stdev2TextField.getText());
                    if (stdev1 < 0 || stdev2 < 0)
                        throw new NumberFormatException();
                    var1 = stdev1 * stdev1;
                    var2 = stdev2 * stdev2;
                } catch (NumberFormatException e) {
                    app.showErrorDialog("Enter valid sample standard deviations.");
                    return;
                }
            }
            else {
                try {
                    var1 = Double.parseDouble(Var1TextField.getText());
                    var2 = Double.parseDouble(Var2TextField.getText());
                    if (var1 < 0 || var2 < 0)
                        throw new NumberFormatException();
                    stdev1 = Math.sqrt(var1);
                    stdev2 = Math.sqrt(var2);
                }
                catch (NumberFormatException e) {
                    app.showErrorDialog("Enter valid sample variances.");
                    return;
                }
            }
        } else {
            Vector<Cell> Vector1 = null, Vector2 = null;
            Vector<Double> InputVector1 = null, InputVector2 = null;
            
            // sample values in one column, labels in another
            if (Sample1ColRadioButton.isSelected()) {
                // get data for the labels column
                String columnLabel = LabelsComboBox.getSelectedItem().toString();
                text += "Population labels in " + columnLabel + "<br>";
                if (columnLabel.equals("")) { // no labels column
                    app.showErrorDialog("Select the column containing category labels.");
                    return;
                }
                int column = ParentSpreadsheet.parseColumnNumber(columnLabel);
                Vector<Cell> LabelsVector = ParentSpreadsheet.getColumn(column);
                
                //get data for the sample values column
                columnLabel = ValuesComboBox.getSelectedItem().toString();
                text += "Samples values in " + columnLabel + "<br>";
                if (columnLabel.equals("")) {   // no values column
                    app.showErrorDialog("Select the column containing sample values.");
                    return;
                }
                column = ParentSpreadsheet.parseColumnNumber(columnLabel);
                Vector<Cell> ValuesVector = ParentSpreadsheet.getColumn(column);
                
                // split values into two vectors corresponding to the two categories
                try {
                    Object returnValues[] =
                            HelperFunctions.splitValuesVectorByLabels(LabelsVector, ValuesVector);
                    
                    text += "Population 1 = " + returnValues[0] + "<br>";
                    text += "Population 2 = " + returnValues[2] + "<br>";
                    
                    Vector1 = (Vector<Cell>) returnValues[1];
                    Vector2 = (Vector<Cell>) returnValues[3];
                    
                    InputVector1 =
                            HelperFunctions.ConvertInputVectorToDoubles(Vector1);
                    if (InputVector1 == null) {
                        app.showErrorDialog("Invalid input column " + returnValues[0] +
                                ": all data must be numbers.");
                        return;
                    }
                    InputVector2 =
                            HelperFunctions.ConvertInputVectorToDoubles(Vector2);
                    if (InputVector2 == null) {
                        app.showErrorDialog("Invalid input column " + returnValues[2] +
                                ": all data must be numbers.");
                        return;
                    }
                } catch (Exception e) {
                    app.showErrorDialog(e.getMessage());
                    return;
                }
            }
            // sample values of two populations in separate columns
            else if (Sample2ColRadioButton.isSelected()) {
                //get data for the two columns of sample values
                String columnLabel = Pop1ComboBox.getSelectedItem().toString();
                text += "Samples of population 1 in " + columnLabel + "<br>";
                if (columnLabel.equals("")) {   // no values column
                    app.showErrorDialog("Select the column containing sample " +
                            "values for the first population.");
                    return;
                }
                int column = ParentSpreadsheet.parseColumnNumber(columnLabel);
                Vector1 = ParentSpreadsheet.getColumn(column);
                InputVector1 =
                        HelperFunctions.ConvertInputVectorToDoubles(Vector1);
                if (InputVector1 == null) {
                    app.showErrorDialog("Invalid input column " + columnLabel +
                            ": all data must be numbers.");
                    return;
                }
                
                columnLabel = Pop2ComboBox.getSelectedItem().toString();
                text += "Samples of population 2 in " + columnLabel + "<br>";
                if (columnLabel.equals("")) {   // no values column
                    app.showErrorDialog("Select the column containing sample " +
                            "values for the second population.");
                    return;
                }
                column = ParentSpreadsheet.parseColumnNumber(columnLabel);
                Vector2 = ParentSpreadsheet.getColumn(column);
                InputVector2 =
                        HelperFunctions.ConvertInputVectorToDoubles(Vector2);
                if (InputVector2 == null) {
                    app.showErrorDialog("Invalid input column " + columnLabel +
                            ": all data must be numbers.");
                    return;
                }
            }
            
            // compute statistics of input vectors
            n1 = BasicStatistics.Nnonmissing(InputVector1);
            var1 = BasicStatistics.variance(InputVector1).doubleValue();
            stdev1 = BasicStatistics.stdev(InputVector1).doubleValue();
            n2 = BasicStatistics.Nnonmissing(InputVector2);
            var2 = BasicStatistics.variance(InputVector2).doubleValue();
            stdev2 = BasicStatistics.stdev(InputVector2).doubleValue();
        }
        
        text += "<br><table border='1'>";
        text += "<tr><td>&nbsp;</td><td>N</td>";
        text += "<td>Stdev</td><td>Variance</td>";
        text += "</tr>";
        text += "<tr><td>Population 1</td><td>" + n1 + "</td><td>" +
                HelperFunctions.formatFloat(stdev1, 5) + "</td>" +
                "<td>" + HelperFunctions.formatFloat(var1, 5) + "</td>";
        text += "</tr>";
        text += "<tr><td>Population 2</td><td>" + n2 + "</td><td>" +
                HelperFunctions.formatFloat(stdev2, 5) + "</td>"+
                "<td>" + HelperFunctions.formatFloat(var2, 5) + "</td>";
        text += "</tr></table><br>";
        
        CI2PopVar CI = new CI2PopVar(confidenceLevel, n1, n2, var1, var2);

        text += "Left critical value F<sub>L</sub> = " + 
                HelperFunctions.formatFloat(CI.criticalValueLeft(), 4) + "<br>";
        text += "Right critical value F<sub>R</sub> = " + 
                HelperFunctions.formatFloat(CI.criticalValueRight(), 4) + "<br>";
         text += HelperFunctions.formatFloat(confidenceLevel * 100, 2) + 
                "%CI Variance Ratio (&sigma;<sub>1</sub><sup>2</sup> / " +
                "&sigma;<sub>2</sub><sup>2</sup>) = "
                + CI.CIVar() + "<br>";
        text += HelperFunctions.formatFloat(confidenceLevel * 100, 2) + 
                "%CI Standard Deviation Ratio (&sigma;<sub>1</sub> / " +
                "&sigma;<sub>2</sub>) = "
                + CI.CIStdev();
        
        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void VarRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VarRadioButtonStateChanged
        if (VarRadioButton.isSelected()) {
            if (SummaryRadioButton.isSelected()) {
                Var1TextField.setEnabled(true);
                Var2TextField.setEnabled(true);
            }
            else {
                Var1TextField.setEnabled(false);
                Var2TextField.setEnabled(false);
            }
        }
        else {
            Var1TextField.setEnabled(false);
            Var2TextField.setEnabled(false);
        }
    }//GEN-LAST:event_VarRadioButtonStateChanged

    private void StdevRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StdevRadioButtonStateChanged
        if (StdevRadioButton.isSelected()) {
            if (SummaryRadioButton.isSelected()) {
                Stdev1TextField.setEnabled(true);
                Stdev2TextField.setEnabled(true);
            }
            else {
                Stdev1TextField.setEnabled(false);
                Stdev2TextField.setEnabled(false);
            }
        }
        else {
            Stdev1TextField.setEnabled(false);
            Stdev2TextField.setEnabled(false);
        }
    }//GEN-LAST:event_StdevRadioButtonStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField ConfidenceTextField;
    private javax.swing.JComboBox LabelsComboBox;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox Pop1ComboBox;
    private javax.swing.JComboBox Pop2ComboBox;
    private javax.swing.JRadioButton Sample1ColRadioButton;
    private javax.swing.JRadioButton Sample2ColRadioButton;
    private javax.swing.JTextField Stdev1TextField;
    private javax.swing.JTextField Stdev2TextField;
    private javax.swing.JRadioButton StdevRadioButton;
    private javax.swing.JRadioButton SummaryRadioButton;
    private javax.swing.JComboBox ValuesComboBox;
    private javax.swing.JTextField Var1TextField;
    private javax.swing.JTextField Var2TextField;
    private javax.swing.JRadioButton VarRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField n1TextField;
    private javax.swing.JTextField n2TextField;
    // End of variables declaration//GEN-END:variables
    
}