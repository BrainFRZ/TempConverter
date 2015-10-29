/**************************************************************************************************
 *  Program Name:     Temperature Converter
 *  Class Name:       tempconverter.TempConverterGUI
 *  Author:           Terry Weiss
 *  Date Written:     October 24, 2015
 *  Program Description:
 *     This contains the graphical interface of the temperature converter. The user is able to
 *  convert temperatures between Celsius and Fahrenheit. The user can switch between Celsius to
 *  Fahrenheit and Fahrenheit to Celsius by using a drop-down box, and then types the temperature
 *  they want to convert into a text field.
 **************************************************************************************************/
package tempconverter;

import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *  This contains the graphical interface of the temperature converter. The user is able to
 *  convert temperatures between Celsius and Fahrenheit. The user can switch between Celsius to
 *  Fahrenheit and Fahrenheit to Celsius by using a drop-down box, and then types the temperature
 *  they want to convert into a text field.
 *
 * @author Terry Weiss
 * @see tempconverter.TempConverter
 */
public class TempConverterGUI extends javax.swing.JFrame {
    private TempConverter converter;

    /**
     * Creates new Netbeans form for TempConverterGUI. The initial conversion type is also specified
     * here. Currently it is set to start with converting from Fahrenheit to Celsius.
     */
    public TempConverterGUI() {
        converter = new TempConverter(TempConverter.Temp_Type.FAHRENHEIT);

        initComponents();
        try {
            this.setIconImage(javax.imageio.ImageIO.read(this.getClass()
                                                                .getResource("Thermometer.png")));
        } catch (java.io.IOException e) { }
    }

    /*
     * This method is called from within the constructor to initialize the Netbeans form. This also
     * initializes all the GUI components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        convertFromLabel = new javax.swing.JLabel();
        convertToLabel = new javax.swing.JLabel();
        convertButton = new javax.swing.JButton();
        tempTextField = new javax.swing.JTextField();
        tempsComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(converter.toString());

        convertFromLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        convertFromLabel.setLabelFor(convertFromLabel);
        convertFromLabel.setText(converter.fromTempTypeStr());

        convertToLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        convertToLabel.setText(converter.toTempTypeStr());

        convertButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        convertButton.setText("Convert");
        convertButton.setToolTipText("Convert temperature to degrees " + converter.toTempTypeStr());
        convertButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        convertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                convertButtonMouseReleased(evt);
            }
        });
        convertButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                convertButtonKeyReleased(evt);
            }
        });

        tempTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tempTextField.setText("Temperature");
        tempTextField.setToolTipText("Enter a temperature in degrees " + converter.fromTempTypeStr());
        tempTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tempTextFieldMouseReleased(evt);
            }
        });
        tempTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tempTextFieldKeyReleased(evt);
            }
        });

        tempsComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tempsComboBox.setMaximumRowCount(2);
        tempsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new TempConverter.Temp_Type[] { TempConverter.Temp_Type.CELSIUS, TempConverter.Temp_Type.FAHRENHEIT }));
        tempsComboBox.setSelectedIndex(converter.fromTempType().ordinal());
        tempsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tempsComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(convertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convertToLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(convertFromLabel))
                            .addComponent(tempsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {convertButton, tempTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tempsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convertFromLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertButton)
                    .addComponent(convertToLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /*
     * If the user hits Enter in the text field, the temperature is converted and the output is
     * reset to show the new converted temperature.
     *
     * @param evt Event trigger
     */
    private void tempTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempTextFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            redrawConvertedTemp();
        }
    }//GEN-LAST:event_tempTextFieldKeyReleased

    /*
     * If the user hits enter on the Convert button, the temperature is converted and the output is
     * reset to show the new converted temperature.
     *
     * @param evt Event trigger
     */
    private void convertButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_convertButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            redrawConvertedTemp();
        }
    }//GEN-LAST:event_convertButtonKeyReleased

    private void tempsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tempsComboBoxItemStateChanged
        tempTextField.setText("Temperature");
        converter = new TempConverter((TempConverter.Temp_Type)tempsComboBox.getSelectedItem());

        convertFromLabel.setText(converter.fromTempTypeStr());
        convertToLabel.setText(converter.toTempTypeStr());
        tempTextField.setToolTipText("Enter a temperature in degrees " + converter.fromTempTypeStr());
        setTitle(converter.toString());

        pack();
    }//GEN-LAST:event_tempsComboBoxItemStateChanged

    /*
     * If the user hits enter on the Convert button, the temperature is converted and the output is
     * reset to show the new converted temperature.
     *
     * @param evt Event trigger
     */
    private void convertButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertButtonMouseReleased
        redrawConvertedTemp();
    }//GEN-LAST:event_convertButtonMouseReleased

    /*
     * If the user clicks the Convert button, the temperature is converted and the output is reset
     * to show the new converted temperature.
     *
     * @param evt Event trigger
     */
    private void tempTextFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tempTextFieldMouseReleased
        tempTextField.setText("");
    }//GEN-LAST:event_tempTextFieldMouseReleased

    /*
     * Parses the degrees from the text field and converts it, then redraws the output with the
     * converted temperature. If an invalid temperature is entered (such as a letter), an error
     * window appears.
     */
    private void redrawConvertedTemp() {
        double fromTemp = 0.0;
        long toTemp = 0;
        boolean validInput = false;

        try {
            String tempText = tempTextField.getText();
            if (tempText.length() != 0) {
                fromTemp = new Scanner(tempText).nextDouble();
                validInput = true;
            }
        }
        catch (java.util.InputMismatchException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid temperature.",
                                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }


        if (validInput) {
            toTemp = Math.round(converter.convertTemp(fromTemp));
            convertToLabel.setText(toTemp + " " + converter.toTempTypeStr());
        }
        else { // If an invalid temperature is given, redraw to default state
            convertToLabel.setText(converter.toTempTypeStr());
            tempTextField.setText("Temperature");
        }

        pack();
    }


    /**
     * Launches the temperature converter GUI
     *
     * @param args Command-line arguments aren't currently supported
     */
    public static void main(String args[]) throws java.io.IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TempConverterGUI.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TempConverterGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertButton;
    private javax.swing.JLabel convertFromLabel;
    private javax.swing.JLabel convertToLabel;
    private javax.swing.JTextField tempTextField;
    private javax.swing.JComboBox tempsComboBox;
    // End of variables declaration//GEN-END:variables
}
