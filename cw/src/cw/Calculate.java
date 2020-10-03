package cw;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public final class Calculate extends JFrame implements ActionListener, KeyListener {

    Cw cw = new Cw();
    FileReading fr = new FileReading();
    RegressionFormula ref = new RegressionFormula();
    JComboBox combo1 = new JComboBox();

    public void Display() {
        setTitle("Calculate");
        setSize(300, 100);
        setResizable(false);

        JPanel layoutPanel = new JPanel(new GridLayout(2, 1));

        JPanel panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
        JTextField txtField = new JTextField(12);
        txtField.addKeyListener(this);

        combo1.addItem("Select independant variable");
        combo1.addActionListener(this);
        combo1.setActionCommand("Chosen");

        panel_1.add(combo1);
        panel_2.add(txtField);

        layoutPanel.add(panel_1);
        layoutPanel.add(panel_2);

        add(BorderLayout.NORTH, layoutPanel);

        setVisible(true);
    }

    Calculate() {
        Display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Chosen".equals(e.getActionCommand())) {
            String selectedItem = "";
            selectedItem = combo1.getSelectedItem().toString();
            fr.getTextFile().clear();
            fr.readTextFile(selectedItem);
            cw.setXMean(ref.calculateXMean(fr.getTextFile()));
            cw.setXInput(fr.getTextFile());
            cw.DisplayTable();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char testChar = e.getKeyChar();
        if (!(Character.isDigit(testChar) || testChar == '.' || (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) && (e.getKeyCode() == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
