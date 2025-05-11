import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.json.JSONObject;


public class CurrencyConverter {
    private JTextField amountField;
    private JComboBox<String> fromCurrency, toCurrency;
    private JLabel resultLabel;

    public CurrencyConverter() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        amountField = new JTextField();
        frame.add(new JLabel("Enter Amount:"));
        frame.add(amountField);

        String[] currencies = {"USD", "PHP", "EUR", "JPY", "GBP", "CAD"};
        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);
        frame.add(new JLabel("From:"));
        frame.add(fromCurrency);
        frame.add(new JLabel("To:"));
        frame.add(toCurrency);

        JButton convertButton = new JButton("Convert");
        frame.add(convertButton);

        resultLabel = new JLabel("Converted Amount: ");
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        frame.setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getSelectedItem().toString();
            String to = toCurrency.getSelectedItem().toString();
            double rate = getExchangeRate(from, to);

            if (rate != -1) {
                double convertedAmount = amount * rate;
                resultLabel.setText("Converted Amount: " + convertedAmount);
            } else {
                resultLabel.setText("Error fetching exchange rate.");
            }
        } catch (Exception ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private double getExchangeRate(String base, String target) {
        try {
            String apiKey = "1bc4e3a3d3473315db3525d7"; // Replace with your actual API key
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;

            URI uri = URI.create(urlStr);
            URL url = uri.toURL(); // Convert URI to URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("conversion_rates").getDouble(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
