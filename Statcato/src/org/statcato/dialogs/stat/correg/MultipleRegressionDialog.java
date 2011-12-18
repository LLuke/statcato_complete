/*
 * MultipleRegressionDialog.java
 *
 * Created on July 10, 2008, 9:22 AM
 */

package org.statcato.dialogs.stat.correg;

import org.statcato.statistics.inferential.MultipleRegression;
import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import java.util.*;
import javax.swing.*;
import Jama.Matrix;

/**
 * A dialog for multiple regression between multiple variables.
 * Allows the user to provide the values for at least one 
 * independent/predictor variables and a dependent/response in separate columns
 * of the Datasheet.
 * Computes and displays in the log window the regression equation,
 * explained, unexplained, and total variations, coefficient of 
 * determination, standard error of estimate, test statistic, and p-Value.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.MultipleRegression
 * @since 1.0
 */
public class MultipleRegressionDialog extends StatcatoDialog {

    /** Creates new form MultipleRegressionDialog */
    public MultipleRegressionDialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        this.app = app;
        ParentSpreadsheet = app.getSpreadsheet();
        initComponents();
        customInitComponents();
    }
    
    private void customInitComponents() {
        ParentSpreadsheet.populateMutableColumnsList(ColList);
        ColList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ParentSpreadsheet.populateComboBox(YComboBox);
        VarList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        getRootPane().setDefaultButton(OKButton);
        setHelpFile("stat-reg-multiple-regression");
        name = "Multiple Regression";
        description = "For performing computations that determine the linear " +
                "regression between multiple variables. ";
        helpStrings.add("Select an independent variable under the Select " +
                "the column containing an independent variable list." +
                " Click the Add to list button to add the column to " +
                "the list of independent variables.");
        helpStrings.add("Select the dependent variable under the " +
                "Select the column containing the dependent variable drop-down menu.");
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
        // update column list
        clearMutableColumnsList(ColList);
        clearMutableColumnsList(VarList);
        
        ParentSpreadsheet.populateMutableColumnsList(ColList);

        updateComboBox(YComboBox);
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
        RemoveButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        YComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        ColList = new JList(new DefaultListModel());
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        VarList = new JList(new DefaultListModel());
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Multiple Regression");

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

        RemoveButton.setText("Remove from list >>");
        RemoveButton.setEnabled(false);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Select the column variable containing the dependent variable:");

        ColList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ColListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ColList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Independent Variables:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Dependent Variable:");

        jLabel2.setText("<html>Select the column containing<br> \nan independent variable<br>\n(Ctrl-click or Shift-click to <br>\nselect multiple columns):");

        AddButton.setText("<< Add to list");
        AddButton.setEnabled(false);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        VarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                VarListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(VarList);

        ClearButton.setText("Clear Input List");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RemoveButton)
                                            .addComponent(AddButton)))
                                    .addComponent(jLabel1))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3)
                            .addComponent(ClearButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(YComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddButton, RemoveButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(28, 28, 28)
                        .addComponent(RemoveButton)
                        .addGap(22, 22, 22))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

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
                        .addGap(159, 159, 159)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VarListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_VarListValueChanged
        if (VarList.getSelectedIndex() != -1)
            RemoveButton.setEnabled(true);
        else
            RemoveButton.setEnabled(false);
}//GEN-LAST:event_VarListValueChanged

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        Object[] list = VarList.getSelectedValues();
        for (int i = 0; i < list.length; ++i) {
            String x = (String)list[i];
            ((DefaultListModel)ColList.getModel()).addElement(x);
            ((DefaultListModel)VarList.getModel()).removeElement(x);
        }
        OKButton.requestFocusInWindow();
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        Object[] list = ColList.getSelectedValues();
        for (int i = 0; i < list.length; ++i) {
            String x = (String)list[i];
            ((DefaultListModel)VarList.getModel()).addElement(x);
            ((DefaultListModel)ColList.getModel()).removeElement(x);
        }
        OKButton.requestFocusInWindow();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("multiple regression");
        
        String heading = "Multiple Regression";
        String text = "";
        Vector<Vector<Double>> vectors = new Vector<Vector<Double>>();
        
        if (YComboBox.getSelectedIndex() == 0) {
            app.showErrorDialog("Select the column containing the " +
                    "dependent variable.");
            return;
        }
        
        if (VarList.getModel().getSize() == 0) {
            app.showErrorDialog("Select at least one column containing the " +
                    "independent variables.");
            return;
        }
        String yCol = (String)YComboBox.getSelectedItem();
        int yColumn = ParentSpreadsheet.parseColumnNumber(yCol);
        
        Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(yColumn);
        Vector<Double> YColumnVector =
                    HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
        if (YColumnVector == null) {
                app.showErrorDialog("Invalid input column " + yCol +
                        ": all data must be numbers.");
                return;
            }
        YColumnVector = HelperFunctions.removeNullValues(YColumnVector);
        int n = YColumnVector.size();
        text += "Dependent variable y = " + yCol + "<br>";
        text += "Independent variables:<br>";
        
        for (int i = 0; i < VarList.getModel().getSize(); ++i) {
            String x = (String) VarList.getModel().getElementAt(i);
            int selectedXColumn = ParentSpreadsheet.parseColumnNumber(x);
            
            StrColumnVector = ParentSpreadsheet.getColumn(selectedXColumn);
            // get x input column of doubles
            Vector<Double> XColumnVector =
                    HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (XColumnVector == null) {
                app.showErrorDialog("Invalid input column " + x +
                        ": all data must be numbers.");
                return;
            }
            
            XColumnVector = HelperFunctions.removeNullValues(XColumnVector);
            if (n != XColumnVector.size()) {
                app.showErrorDialog("All variables must have the same" +
                            " number of values.");
                return;
            }
            vectors.addElement(XColumnVector);
            text += "&nbsp;&nbsp;x<sub>" + (i+1) + "</sub> = " + x + "<br>"; 
        }
        
        int k = vectors.size();
        try {
            MultipleRegression mr = new MultipleRegression(vectors, YColumnVector,
                    true);

            Matrix RegCoeff = mr.RegressionEqCoefficients(); // k+1 by 1

            text += "Sample size = " + mr.SampleSize() + "<br>";
            text += "Number of independent variables = " + mr.NumIndepVar() + "<br><br>";

            text += "<u>Regression Equation</u>: Y = b<sub>0</sub> ";
            for (int i = 1; i <= k; ++i) {
                text += " + b<sub>" + i + "</sub>x<sub>" + i + "</sub>";
            }
            text += "<br>";
            for (int i = 0; i <= k; ++i) {
                text += "b<sub>" + i + "</sub> = " + 
                        HelperFunctions.formatFloat(RegCoeff.get(i, 0), 5) + "<br>";
            }

            text += "<br>";
            text += "<u>Variation</u>:<br>";
            text += "Explained variation = " +
                    HelperFunctions.formatFloat(mr.ExplainedVariation(), 4) + "<br>";
            text += "Unexplained variation = " +
                    HelperFunctions.formatFloat(mr.UnexplainedVariation(), 4) + "<br>";
            text += "Total variation = " + 
                    HelperFunctions.formatFloat(mr.TotalVariation(), 4) + "<br>";
            text += "Coefficient of determination r<sup>2</sup> = " + 
                    HelperFunctions.formatFloat(mr.CoefficientOfDetermination(), 4)
                    + "<br>";
            text += "Adjusted Coefficient of determination r<sup>2</sup> = " + 
                    HelperFunctions.formatFloat(mr.AdjustedCoefficientOfDetermination(), 4)
                    + "<br>";
            text += "Standard error of estimate = " + 
                    HelperFunctions.formatFloat(mr.StandardError(), 4) + "<br>";
            text += "Test statistics F = " + 
                    HelperFunctions.formatFloat(mr.TestStatistics(), 4) + "<br>";
            text += "p-Value = " + 
                    HelperFunctions.formatFloat(mr.PValue(), 5) + "<br><br>";
        }
        catch (RuntimeException e) {
            app.showErrorDialog(e.getMessage());
            return;
        }
        
        
        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ColListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ColListValueChanged
        if (ColList.getSelectedIndex() != -1)
            AddButton.setEnabled(true);
        else
            AddButton.setEnabled(false);
    }//GEN-LAST:event_ColListValueChanged

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clearMutableColumnsList(ColList);
        clearMutableColumnsList(VarList);
        ParentSpreadsheet.populateMutableColumnsList(ColList);
}//GEN-LAST:event_ClearButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JList ColList;
    private javax.swing.JButton OKButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JList VarList;
    private javax.swing.JComboBox YComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
}
