import javax.swing.*;
import java.awt.event.*;

public class Dashboard {
    private JFrame frame;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField amountField;
    private JTextField resultField;
    private JButton convertButton;
    private JTextArea logArea;

    public Dashboard() {
        frame = new JFrame("Currency Converter");
        frame.setSize(500, 400);
        frame.setLayout(null);

        comboBox1 = new JComboBox<>(new String[]{"USD", "PHP", "EUR"});
        comboBox1.setBounds(50, 30, 100, 25);
        frame.add(comboBox1);

        comboBox2 = new JComboBox<>(new String[]{"USD", "PHP", "EUR"});
        comboBox2.setBounds(200, 30, 100, 25);
        frame.add(comboBox2);

        amountField = new JTextField();
        amountField.setBounds(50, 70, 250, 25);
        frame.add(amountField);

        resultField = new JTextField();
        resultField.setBounds(50, 110, 250, 25);
        resultField.setEditable(false);
        frame.add(resultField);

        convertButton = new JButton("Convert");
        convertButton.setBounds(320, 70, 100, 30);
        frame.add(convertButton);

        logArea = new JTextArea();
        logArea.setBounds(50, 160, 370, 180);
        logArea.setEditable(false);
        frame.add(logArea);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = comboBox1.getSelectedItem().toString();
                    String to = comboBox2.getSelectedItem().toString();
                    double rate = getRate(from, to);
                    double converted = amount * rate;

                    String log = amount + " " + from + " = " + converted + " " + to;
                    TransactionLogger.log(log);
                    resultField.setText("" + converted);
                    logArea.setText(TransactionLogger.getAllLogs());
                } catch (Exception ex) {
                    resultField.setText("Invalid input!");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private double getRate(String from, String to) {
        if (from.equals(to)) return 1.0;
        if (from.equals("USD") && to.equals("PHP")) return 56.0;
        if (from.equals("PHP") && to.equals("USD")) return 0.018;
        if (from.equals("EUR") && to.equals("USD")) return 1.1;
        if (from.equals("USD") && to.equals("EUR")) return 0.91;
        return 1.0;
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
