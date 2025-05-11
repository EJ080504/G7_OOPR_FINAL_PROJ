import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

public class CurrencyComboBoxExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency ComboBox");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(100, 50, 200, 30);
        frame.add(comboBox);

        frame.setVisible(true);

        // Call API and populate ComboBox
        new Thread(() -> {
            try {
                // API Endpoint (you can use your own)
                URL url = new URL("https://api.exchangerate-api.com/v4/latest/USD");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                // Parse JSON response
                JSONObject json = new JSONObject(content.toString());
                JSONObject rates = json.getJSONObject("rates");

                // Add items to ComboBox on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> {
                    Iterator<String> keys = rates.keys();
                    while (keys.hasNext()) {
                        String currency = keys.next();
                        comboBox.addItem(currency);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
