/*
 * NormalQuantilePlotDialog.java
 *
 * Created on July 21, 2008, 1:35 PM
 */

package org.statcato.dialogs.graph;
import org.statcato.graph.StatcatoChartFrame;
import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import org.statcato.statistics.NormalityTest;
import org.statcato.graph.GraphFactory;

import java.util.*;
import javax.swing.ButtonGroup;
import org.jfree.chart.*;

/**
 * A dialog for creating normal quantile (probability) plot.  
 * Allows the user to specify the
 * data values to be graphed, axis labels, title,
 * and whether a regression line is displayed.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.jfree.chart
 * @since 1.0
 */
public class NormalQuantilePlotDialog extends StatcatoDialog {

    /** Creates new form NormalQuantilePlotDialog */
    public NormalQuantilePlotDialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        this.app = app;
        ParentSpreadsheet = app.getSpreadsheet();
        initComponents();
        customInitComponents();
        setHelpFile("graph-nqp");
        name = "Normal Quantile Plot";
        description = "For creating normal quantile (probability) plots.";
        helpStrings.add("Select the column containing the data values.");
        helpStrings.add("Enter the plot title and " +
        "labels for the x and y axes in the corresponding text fields.");
        helpStrings.add("Select the Show regression line check box " +
                "to show a best-fit line to the points on the plot.");
        helpStrings.add("Select the significance level used in the " +
                "Ryan-Joiner normality test.");
        pack();
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
        updateComboBox(ColComboBox);       
    }
    
    private void customInitComponents() {
        ParentSpreadsheet.populateComboBox(ColComboBox);
        ButtonGroup group = new ButtonGroup();
        group.add(DataRadioButton);
        group.add(ZscoresRadioButton);
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
        ColComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        yTextField = new javax.swing.JTextField();
        TitleTextField = new javax.swing.JTextField();
        xTextField = new javax.swing.JTextField();
        LineCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DataRadioButton = new javax.swing.JRadioButton();
        ZscoresRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        SigComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Normal Quantile Plot");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph Variable"));

        ColComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ColComboBoxItemStateChanged(evt);
            }
        });

        jLabel1.setText("Select the column for which the plot will be created:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ColComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ColComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph Options"));

        jLabel2.setText("Plot Title:");

        TitleTextField.setText("Normal Quantile Plot");

        LineCheckBox.setSelected(true);
        LineCheckBox.setText("Show regression line");

        jLabel4.setText("Y-axis Label:");

        jLabel3.setText("X-axis Label:");

        jLabel5.setText("X-axis values represent:");

        DataRadioButton.setSelected(true);
        DataRadioButton.setText("data");

        ZscoresRadioButton.setText("z-scores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(xTextField))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(yTextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LineCheckBox)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DataRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZscoresRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LineCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ZscoresRadioButton)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(DataRadioButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Normality Test (Ryan-Joiner)"));

        SigComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0.01", "0.05", "0.10" }));

        jLabel6.setText("Significance Level:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SigComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SigComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("normal quantile plot");
        
        String heading = "Normal Quartile Plot";    
        
        if (ColComboBox.getSelectedIndex() == 0) {
            app.showErrorDialog("Select the column containing the " +
                    "values to be plotted.");
            return;
        }

        String yCol = (String)ColComboBox.getSelectedItem();
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
        String text = "Input variable: " + yCol + "<br>";
        
        // normality test results
        double significance = Double.parseDouble((String)SigComboBox.getSelectedItem());
        
        NormalityTest normalityTest = new NormalityTest(YColumnVector, significance);
        text += normalityTest;
        
        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        CreatePlot(YColumnVector);
       
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CreatePlot(Vector<Double> YColumnVector) {
        JFreeChart plot = GraphFactory.createNormalQuantilePlot(YColumnVector,
            TitleTextField.getText(), xTextField.getText(), yTextField.getText(),
            DataRadioButton.isSelected(), LineCheckBox.isSelected());
 
        StatcatoChartFrame frame = 
                new StatcatoChartFrame(TitleTextField.getText(), plot, app);
        frame.pack();
        frame.setVisible(true);    
                
    }
    
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ColComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ColComboBoxItemStateChanged
        if (ColComboBox.getSelectedIndex() != 0) {
            if (xTextField.getText().equals("")) {
                String yCol = (String)ColComboBox.getSelectedItem();
                xTextField.setText(yCol);           
            }
        }
    }//GEN-LAST:event_ColComboBoxItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox ColComboBox;
    private javax.swing.JRadioButton DataRadioButton;
    private javax.swing.JCheckBox LineCheckBox;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox SigComboBox;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JRadioButton ZscoresRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField xTextField;
    private javax.swing.JTextField yTextField;
    // End of variables declaration//GEN-END:variables
    
}
