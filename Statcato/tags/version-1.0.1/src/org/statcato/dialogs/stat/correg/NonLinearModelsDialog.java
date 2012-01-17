/*
 * NonLinearModelsDialog.java
 *
 * Created on July 28, 2008, 8:29 AM
 */

package org.statcato.dialogs.stat.correg;

import org.statcato.graph.StatcatoChartFrame;
import org.statcato.statistics.inferential.MultipleRegression2;
import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import org.statcato.graph.GraphFactory;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.*;
import java.util.*;
import javax.swing.*;
import Jama.Matrix;

/**
 * A dialog that allows the user to fit a non-linear mathematical 
 * regression model to two variables. The user must provides
 * the values for an independent/predictor variables 
 * and a dependent/response in separate columns.  Types of regression models
 * include quadratic, cubic, polynomial, logarithmic, power, and exponential.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @since 1.0
 * @see org.statcato.statistics.inferential.MultipleRegression
 */
public class NonLinearModelsDialog extends StatcatoDialog {
 
    /** Creates new form NonLinearModelsDialog */
    public NonLinearModelsDialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        this.app = app;
        ParentSpreadsheet = app.getSpreadsheet();
        
        initComponents();
        customInitComponents();
        setHelpFile("stat-reg-nonlinear");
        name = "Non-Linear Regression Models";
        description = "For performing computations that fit a non-linear " +
                "mathematical regression model to two variables. ";
        helpStrings.add("Select x (independent/predictor variable): " +
                "Select the column containing the x values.");
        helpStrings.add("Select y (dependent/response variable): Select the " +
                "column containing the y values (the number of x and y " +
                "values must be the same).");
        helpStrings.add("Type of Model: Select desired model type.");
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
        updateComboBox(xComboBox);
        updateComboBox(yComboBox);
    }
    
    public void customInitComponents() {  
        ParentSpreadsheet.populateComboBox(xComboBox);
        ParentSpreadsheet.populateComboBox(yComboBox);        
        getRootPane().setDefaultButton(OKButton);
        ButtonGroup group = new ButtonGroup();
        group.add(QuadRadioButton);
        group.add(CubicRadioButton);
        group.add(LogRadioButton);
        group.add(PolyRadioButton);
        group.add(PowerRadioButton);
        group.add(ExpRadioButton);
        group.add(FixedPowRadioButton);
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
        yComboBox = new javax.swing.JComboBox();
        xComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LogRadioButton = new javax.swing.JRadioButton();
        PolyRadioButton = new javax.swing.JRadioButton();
        QuadRadioButton = new javax.swing.JRadioButton();
        PowerRadioButton = new javax.swing.JRadioButton();
        nTextField = new javax.swing.JTextField();
        ExpRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CubicRadioButton = new javax.swing.JRadioButton();
        FixedPowRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        powTextField = new javax.swing.JTextField();
        GraphCheckBox = new javax.swing.JCheckBox();
        GraphPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LegendCheckBox = new javax.swing.JCheckBox();
        YTextField = new javax.swing.JTextField();
        TitleTextField = new javax.swing.JTextField();
        XTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Non-Linear Regression Models");

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

        jLabel3.setText("<html>Select <i>x</i> (independent/predictor variable):</html>");

        jLabel1.setText("<html>Select <i>y</i> (dependent/response variable):</html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(xComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(yComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Models"));

        LogRadioButton.setText("<html>Logarithmic: y = a lnx + b</html>");

        PolyRadioButton.setText("<html>Polynomial: y = ax<sup>n</sup> + bx<sup>n-1</sup> + cx<sup>n-2</sup> + ...</html>");
        PolyRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PolyRadioButtonStateChanged(evt);
            }
        });

        QuadRadioButton.setSelected(true);
        QuadRadioButton.setText("<html>Quadratic: y = ax<sup>2</sup> + bx + c</html>");

        PowerRadioButton.setText("<html>Power: y = a x<sup>b</sup></html>");

        nTextField.setText("4");
        nTextField.setEnabled(false);

        ExpRadioButton.setText("<html>Exponential: y = a b<sup>x</sup></html>");

        jLabel2.setText("Type of Model:");

        jLabel4.setText("n = ");

        CubicRadioButton.setText("<html>Cubic: y = ax<sup>3</sup> + bx<sup>2</sup> + cx + d</html>\n");

        FixedPowRadioButton.setText("<html>Fixed Power: y = a x<sup>n</sup></html>");
        FixedPowRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                FixedPowRadioButtonStateChanged(evt);
            }
        });

        jLabel5.setText("n = ");

        powTextField.setText("-1");
        powTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PolyRadioButton)
                            .addComponent(CubicRadioButton)
                            .addComponent(QuadRadioButton)
                            .addComponent(jLabel2)
                            .addComponent(LogRadioButton)
                            .addComponent(PowerRadioButton)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(powTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(FixedPowRadioButton)
                            .addComponent(ExpRadioButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuadRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CubicRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PolyRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PowerRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FixedPowRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(powTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExpRadioButton)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        GraphCheckBox.setSelected(true);
        GraphCheckBox.setText("Show a scatterplot for data values with the regression curve");
        GraphCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GraphCheckBoxStateChanged(evt);
            }
        });

        GraphPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph Options"));

        jLabel7.setText("Plot Title:");

        jLabel8.setText("X-axis Label:");

        LegendCheckBox.setSelected(true);
        LegendCheckBox.setText("Show legend");

        YTextField.setText("y");

        TitleTextField.setText("Plot");

        XTextField.setText("x");

        jLabel6.setText("Y-axis Label:");

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GraphPanelLayout.createSequentialGroup()
                        .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitleTextField)
                            .addComponent(XTextField)
                            .addComponent(YTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                    .addComponent(jLabel8)
                    .addComponent(LegendCheckBox))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(XTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(YTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LegendCheckBox)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GraphCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GraphCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("non linear models");

        Vector<Double> xVector = null, yVector = null;
        String heading = "Non-Linear Modeling:";
        String text = "";
        
        // get the x variable
        String xColumnLabel = xComboBox.getSelectedItem().toString();
        if (xColumnLabel.equals("")) { // no input variable
            app.showErrorDialog("Select the input column.");
            return;
        }
        int column = ParentSpreadsheet.parseColumnNumber(xColumnLabel);
        Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(column);
        xVector = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
        if (xVector == null) {
            app.showErrorDialog("Invalid input column " + xColumnLabel +
                    ": all data must be numbers.");
            return;
        }
        text += "x (independent/predictor variable): " + xColumnLabel + "<br>";
        
        // get the y variable
        String yColumnLabel = yComboBox.getSelectedItem().toString();
        if (yColumnLabel.equals("")) { // no input variable
            app.showErrorDialog("Select the input column.");
            return;
        }
        column = ParentSpreadsheet.parseColumnNumber(yColumnLabel);
        StrColumnVector = ParentSpreadsheet.getColumn(column);
        yVector = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
        if (yVector == null) {
            app.showErrorDialog("Invalid input column " + yColumnLabel +
                    ": all data must be numbers.");
            return;
        }
        text += "y (dependent/response variable): " + yColumnLabel + "<br>";
        
        xVector = HelperFunctions.removeNullValues(xVector);
        yVector = HelperFunctions.removeNullValues(yVector);
        if (xVector.size() != yVector.size()) {
            app.showErrorDialog("The x and y variables must have the same " +
                    "number of values.");
            return;
        }

        XYSeriesCollection seriesCollection = new XYSeriesCollection();
        double min = 0, max = 0;
        // create new series for graphing
        XYSeries series = new XYSeries(xColumnLabel.trim()
                + ", " + yColumnLabel.trim());
        for (int j = 0; j < xVector.size(); ++j) {
            double x = xVector.elementAt(j).doubleValue();
            if (x < min)
                min = x;
            if (x > max)
                max = x;
            series.add(x,
                    yVector.elementAt(j).doubleValue());
        }
        seriesCollection.addSeries(series);

        // determine type of model
        int regressionType = GraphFactory.REG_NONE;
        double regressionArg = 0;

        Vector<Vector<Double>> vectors = new Vector<Vector<Double>>();
        int k = 0;  // number of coefficients
        boolean logTransform = false;
        if (QuadRadioButton.isSelected()) {
            text += "<b>Quadratic Model: y = b<sub>0</sub> + b<sub>1</sub>x + b<sub>2</sub>x<sup>2</sup></b><br>";
            // Construct matrix for multiple regression [x x^2]
            vectors.addElement(xVector);
            vectors.addElement(HelperFunctions.powerVector(xVector, 2));
            k = 3;
            regressionType = GraphFactory.REG_QUAD;
        } else if (CubicRadioButton.isSelected()) {
            text += "<b>Cubic Model: y = b<sub>0</sub> + b<sub>1</sub>x + " +
                    "b<sub>2</sub>x<sup>2</sup> + b<sub>3</sub>x<sup>3</sup></b><br>";
            // Construct matrix for multiple regression [x x^2 x^3]
            vectors.addElement(xVector);
            vectors.addElement(HelperFunctions.powerVector(xVector, 2));
            vectors.addElement(HelperFunctions.powerVector(xVector, 3));
            k = 4;
            regressionType = GraphFactory.REG_CUBIC;
        } else if (PolyRadioButton.isSelected()) {
            text += "<b>Polynomial  Model: y = b<sub>0</sub> + b<sub>1</sub>x + " +
                    "b<sub>2</sub>x<sup>2</sup> + ... " +
                    "+ b<sub>n</sub>x<sup>n</sup></b><br>";
            try {
                int n = Integer.parseInt(nTextField.getText());
                if (n <= 0)
                    throw new NumberFormatException();
                regressionArg = n;
                text += "Degree = " + n + "<br>";
                vectors.addElement(xVector);
                for (int i = 2; i <= n; ++i) 
                    vectors.addElement(HelperFunctions.powerVector(xVector, i));
                k = n + 1;
            } catch (NumberFormatException e) {
                app.showErrorDialog("Enter a positive integer for the degree" +
                        " of the polynomial model");
                return;
            }
           regressionType = GraphFactory.REG_POLY;
        } else if (LogRadioButton.isSelected()) {
            text += "<b>Logarithmic Model: y = b<sub>0</sub> + b<sub>1</sub>ln x</b><br>";
            // Construct matrix for multiple regression [ln(x)]
            vectors.addElement(HelperFunctions.logVector(xVector));
            k = 2;
            regressionType = GraphFactory.REG_LOG;
        } else if (PowerRadioButton.isSelected()) {
            text += "<b>Power Model: y = a x<sup>b</sup></b><br>";
            vectors.addElement(HelperFunctions.logVector(xVector));
            yVector = HelperFunctions.logVector(yVector);
            k = 2;
            logTransform = true;
            regressionType = GraphFactory.REG_POW;
        } else if (ExpRadioButton.isSelected()) {
            text += "<b>Exponential Model: y = a b<sup>x</sup></b><br>";
            vectors.addElement(xVector);
            yVector = HelperFunctions.logVector(yVector);
            k = 2;
            logTransform = true;
            regressionType = GraphFactory.REG_EXP;
        } else if (FixedPowRadioButton.isSelected()) {
            text += "<b>Fixed Power Model: y = a x<sup>n</sup></b><br>";
            try {
                double n = Double.parseDouble(powTextField.getText());
                regressionArg = n;
                vectors.addElement(HelperFunctions.powerVector(xVector, n));
                text += "n = " + n + "<br>";
            } catch (NumberFormatException e) {
                app.showErrorDialog("Enter a real number for the degree" +
                        " of the fixed power model");
                return;
            }
            k = 1;
            regressionType = GraphFactory.REG_FIXEDPOW;
        }

        // compute regression
        try {
            MultipleRegression2 mr = new MultipleRegression2(vectors, yVector,
                    !FixedPowRadioButton.isSelected());
            Matrix RegCoeff = mr.RegressionEqCoefficients();

            if (FixedPowRadioButton.isSelected()) {
                text += "a = " +
                        HelperFunctions.formatFloat(RegCoeff.get(0,0), 5) + "<br>";
            }
            else {
                if (!logTransform) {
                        for (int i = 0; i < k; ++i) {
                            text += "b<sub>" + i + "</sub> = " +
                                    HelperFunctions.formatFloat(RegCoeff.get(i, 0), 5) + "<br>";
                        }
                } else {
                    if (PowerRadioButton.isSelected()) {
                        text += "a = " +
                                HelperFunctions.formatFloat(
                                Math.exp(RegCoeff.get(0,0)), 5) + "<br>";
                        text += "b = " +
                               HelperFunctions.formatFloat(
                               RegCoeff.get(1, 0), 5) + "<br>";
                    }
                    else if (ExpRadioButton.isSelected()) {
                        text += "a = " +
                              HelperFunctions.formatFloat(
                                Math.exp(RegCoeff.get(0,0)), 5) + "<br>";
                        text += "b = " +
                                HelperFunctions.formatFloat(
                                Math.exp(RegCoeff.get(1,0)), 5) + "<br>";
                    }
                }
            }

            // create scatterplot if option is selected
            if (GraphCheckBox.isSelected()) {
                JFreeChart chart = GraphFactory.createScatterplot(
                        seriesCollection,
                        TitleTextField.getText(),
                        XTextField.getText(),
                        YTextField.getText(),
                        LegendCheckBox.isSelected(),
                        regressionType,
                        regressionArg,
                        min,
                        max);
            StatcatoChartFrame frame =
                    new StatcatoChartFrame(TitleTextField.getText(), chart, app);
            frame.pack();
            frame.setVisible(true);
        }

            text += mr;
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

    private void FixedPowRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_FixedPowRadioButtonStateChanged
        if (FixedPowRadioButton.isSelected())
            powTextField.setEnabled(true);
        else
            powTextField.setEnabled(false);
    }//GEN-LAST:event_FixedPowRadioButtonStateChanged

    private void PolyRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PolyRadioButtonStateChanged
        if (PolyRadioButton.isSelected())
            nTextField.setEnabled(true);
        else
            nTextField.setEnabled(false);
    }//GEN-LAST:event_PolyRadioButtonStateChanged

    private void GraphCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GraphCheckBoxStateChanged
        if (GraphCheckBox.isSelected()) {
            GraphPanel.setVisible(true);
            pack();
        } else {
            GraphPanel.setVisible(false);
            pack();
        }
}//GEN-LAST:event_GraphCheckBoxStateChanged
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JRadioButton CubicRadioButton;
    private javax.swing.JRadioButton ExpRadioButton;
    private javax.swing.JRadioButton FixedPowRadioButton;
    private javax.swing.JCheckBox GraphCheckBox;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JCheckBox LegendCheckBox;
    private javax.swing.JRadioButton LogRadioButton;
    private javax.swing.JButton OKButton;
    private javax.swing.JRadioButton PolyRadioButton;
    private javax.swing.JRadioButton PowerRadioButton;
    private javax.swing.JRadioButton QuadRadioButton;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JTextField XTextField;
    private javax.swing.JTextField YTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nTextField;
    private javax.swing.JTextField powTextField;
    private javax.swing.JComboBox xComboBox;
    private javax.swing.JComboBox yComboBox;
    // End of variables declaration//GEN-END:variables
    
}
