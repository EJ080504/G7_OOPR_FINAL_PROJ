import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Timer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.json.JSONObject;


public class DashboardPage_G7{
	private JPanel loadingPanel;
    private JTextField Panel1_AmountField, Panel1_FinalAmountField;
    private JComboBox<String> fromCurrency, toCurrency;
	private JPanel Dashboard_Panel2;
	private JScrollPane Db_Panel2_ScrollPane;
	private static List<String> currencyList = new ArrayList<>();

	public DashboardPage_G7() {
		

		//GUI___________________________________________________________________________________

		//FRAME
		JFrame Dashboard_Frame = new JFrame("Dashboard");
		Dashboard_Frame.setSize(800, 600);
		Dashboard_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dashboard_Frame.setResizable(false);
		Dashboard_Frame.setLocationRelativeTo(null);
		Dashboard_Frame.setVisible(true);
		
		//PANEL
		JPanel Dashboard_Horizontal = new JPanel();

		JPanel Dashboard_Panel1 = new JPanel();
		JPanel Dashboard_subPanel1 = new JPanel();
		JPanel Dashboard_subPanel2 = new JPanel();

		Dashboard_Panel2 = new JPanel();

		//COMBO BOX
        String[] currencies = {};
        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);

		//SCROLLPANE
		Db_Panel2_ScrollPane = new JScrollPane(Dashboard_Panel2);

		//LABEL
		JLabel Dashboard_Logo = new JLabel("ByteXChange");
		JLabel Dashboard_Header = new JLabel("Dashboard");

		JLabel Panel1_To = new JLabel("To");
		JLabel Panel1_Amount = new JLabel("Amount");
		JLabel Panel1_FinalAmount = new JLabel("Final Amount");

		JLabel Panel2_ExRate = new JLabel("Exchange Rate");

		//TEXTFIELD
		Panel1_AmountField = new JTextField("Enter Amount");
		Panel1_FinalAmountField = new JTextField();

		//IMAGE
		ImageIcon Db_ExitButton = new ImageIcon("images/exit-icon 1.png");
		ImageIcon Db_TransactionHistory = new ImageIcon("images/TransactionHistory.png");
		ImageIcon Db_ProfileSettings = new ImageIcon("images/ProfileSettings.png");

		//BUTTON
		JButton Dashboard_ExitButton = new JButton(Db_ExitButton);
		JButton Panel1_ConvertButton = new JButton("Convert Currency");

		JButton Dashboard_TranHistory = new JButton(Db_TransactionHistory);
		JButton Dashboard_ProfileSettings = new JButton(Db_ProfileSettings);

		//ADD
		Dashboard_Frame.setLayout(null);

		Dashboard_Frame.add(Dashboard_Logo);
		Dashboard_Frame.add(Dashboard_ExitButton);
		Dashboard_Frame.add(Dashboard_Header);
		Dashboard_Frame.add(Dashboard_Horizontal);
		Dashboard_Frame.add(Dashboard_Panel1);

		Dashboard_Panel2.setLayout(new BoxLayout(Dashboard_Panel2, BoxLayout.Y_AXIS));
		Dashboard_Frame.add(Db_Panel2_ScrollPane);

		Dashboard_Frame.add(Dashboard_TranHistory);
		Dashboard_Frame.add(Dashboard_ProfileSettings);

		Dashboard_Panel1.setLayout(null);
		Dashboard_Panel1.add(Panel1_To);

		Dashboard_Panel1.add(Dashboard_subPanel1);
		Dashboard_subPanel1.setLayout(null);
		Dashboard_subPanel1.add(fromCurrency);

		Dashboard_Panel1.add(Dashboard_subPanel2);
		Dashboard_subPanel2.setLayout(null);
		Dashboard_subPanel2.add(toCurrency);

		Dashboard_Panel1.add(Panel1_Amount);
		Dashboard_Panel1.add(Panel1_AmountField);
		Dashboard_Panel1.add(Panel1_FinalAmount);
		Dashboard_Panel1.add(Panel1_FinalAmountField);
		Dashboard_Panel1.add(Panel1_ConvertButton);


		Dashboard_Panel2.add(Panel2_ExRate);

		//SET BOUNDS
		Dashboard_Logo.setBounds(55, 35, 150, 40);
		Dashboard_ExitButton.setBounds(727, 23, 32, 32);

		Dashboard_Header.setBounds(300, 90, 200, 50);

		Dashboard_Horizontal.setBounds(65, 154, 670, 1);

		Dashboard_Panel1.setBounds(57, 189, 360, 350);

		Dashboard_subPanel1.setBounds(30, 20, 300, 80);
		fromCurrency.setBounds(15, 10, 270, 60);

		Panel1_To.setBounds(170, 95, 50, 30);

		Dashboard_subPanel2.setBounds(30, 120, 300, 80);
		toCurrency.setBounds(15, 10, 270, 60);

		Panel1_Amount.setBounds(30, 220, 45, 15);
		Panel1_AmountField.setBounds(115, 215, 215, 25);
		Panel1_FinalAmount.setBounds(30, 260, 95, 15);
		Panel1_FinalAmountField.setBounds(115, 255, 215, 25);
		Panel1_ConvertButton.setBounds(30, 295, 300, 40);

		Db_Panel2_ScrollPane.setBounds(428, 189, 315, 230);
		Panel2_ExRate.setBounds(10, 10, 100, 20);

		Dashboard_TranHistory.setBounds(428, 430, 180, 110);
		Dashboard_ProfileSettings.setBounds(619, 430, 125, 110);

		//BG COLOR
		Dashboard_Frame.getContentPane().setBackground(new Color(0x06283D));
		Dashboard_ExitButton.setBackground(new Color(0x06283D));

		Dashboard_Horizontal.setBackground(new Color(0xDFF6FF));

		Dashboard_Panel1.setBackground(new Color(0x1363DF));
		Dashboard_subPanel1.setBackground(new Color(0x47B5FF));
		fromCurrency.setBackground(new Color(0x1363DF));
		Dashboard_subPanel2.setBackground(new Color(0x47B5FF));
		toCurrency.setBackground(new Color(0x1363DF));
		Panel1_ConvertButton.setBackground(new Color(0x47B5FF));


		Dashboard_Panel2.setBackground(new Color(0x1363DF));

		//FONT CUSTOMIZATION
		Dashboard_Logo.setFont(new Font("Lato", Font.BOLD, 20));
		Dashboard_Logo.setForeground(new Color(0xDFF6FF));

		Dashboard_Header.setFont(new Font("Lato", Font.BOLD, 36));
		Dashboard_Header.setForeground(new Color(0xDFF6FF));

		Panel1_Amount.setFont(new Font("Lato", Font.BOLD, 12));
		Panel1_Amount.setForeground(new Color(0xDFF6FF));

		Panel1_FinalAmount.setFont(new Font("Lato", Font.BOLD, 12));
		Panel1_FinalAmount.setForeground(new Color(0xDFF6FF));

		Panel1_ConvertButton.setFont(new Font("Lato", Font.BOLD, 18));
		Panel1_ConvertButton.setForeground(new Color(0XDFF6FF));

		Panel2_ExRate.setFont(new Font("Lato", Font.BOLD, 12));
		Panel2_ExRate.setForeground(new Color(0XDFF6FF));

		Panel1_To.setFont(new Font("Lato", Font.BOLD, 12));
		Panel1_To.setForeground(new Color(0XDFF6FF));

		fromCurrency.setFont(new Font("Lato", Font.BOLD, 20));
		fromCurrency.setForeground(new Color(0xDFF6FF));

		toCurrency.setFont(new Font("Lato", Font.BOLD, 20));
		toCurrency.setForeground(new Color(0xDFF6FF));
		
		
		//BUTTON CUSTOMIZATION
		Dashboard_ExitButton.setToolTipText("Sign Out");
		Dashboard_ExitButton.setBorderPainted(false);
		


		//BORDER REMOVER IN BUTTONS
		Panel1_ConvertButton.setBorderPainted(false);



		fetchAndDisplayExchangeRates("USD");

		

		//EVENT HANDLING_________________________________________________________________________


		//ALL BUTTONS FUNCTIONS IN DASHBOARD
		
		Dashboard_ExitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	Dashboard_ExitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	Dashboard_ExitButton.setCursor(Cursor.getDefaultCursor());
            }
        });
		
		Dashboard_ExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dashboard_Frame.dispose();
				new LoginPage_G7();
			}
		});

		Dashboard_TranHistory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dashboard_Frame.dispose();
				new TransactionHistoryPage_G7();
			}
		});

		Dashboard_ProfileSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dashboard_Frame.dispose();
				new ProfileSettings_G7();
			}
		});

		Panel1_ConvertButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            convertCurrency();
	        }
	    });
		
		Panel1_ConvertButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	Panel1_ConvertButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	Panel1_ConvertButton.setCursor(Cursor.getDefaultCursor());
            }
        });
	
	
	//ALL CURRENCY IN THE COMBOBOX
        new Thread(() -> {
            try {
                URL url = new URL("https://api.exchangerate-api.com/v4/latest/USD");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                JSONObject json = new JSONObject(content.toString());
                JSONObject rates = json.getJSONObject("rates");

                Iterator<String> keys = rates.keys();
                while (keys.hasNext()) {
                    currencyList.add(keys.next());
                }

                // Populate combo box (on UI thread)
                SwingUtilities.invokeLater(() -> {
                    fromCurrency.removeAllItems();
                    for (String currency : currencyList) {
                        fromCurrency.addItem(currency);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // Search as you type
        JTextField editor = (JTextField) fromCurrency.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = editor.getText();
                List<String> filtered = currencyList.stream()
                        .filter(code -> code.toLowerCase().startsWith(input.toLowerCase()))
                        .collect(Collectors.toList());

                // Update dropdown
                fromCurrency.hidePopup();
                fromCurrency.removeAllItems();
                for (String code : filtered) {
                    fromCurrency.addItem(code);
                }
                editor.setText(input); // keep typed text
                fromCurrency.showPopup();
            }
        });
    

	
	// Call API and populate ComboBox
    new Thread(() -> {
        try {
            
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
                    toCurrency.addItem(currency);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
    
	}



	//CONVERT CURRENCY__________________________________________________________________



    /*private void convertCurrency() {
        try {
            double amount = Double.parseDouble(Panel1_AmountField.getText());
            String from = fromCurrency.getSelectedItem().toString();
            String to = toCurrency.getSelectedItem().toString();
            double rate = getExchangeRate(from, to);

            if (rate != -1) {
                double convertedAmount = amount * rate;
                Panel1_FinalAmountField.setText("" + convertedAmount);
            } else {
            	Panel1_FinalAmountField.setText("Error fetching exchange rate.");
            }
        } catch (Exception ex) {
        	Panel1_FinalAmountField.setText("Invalid input!");
        }
    }*/
	
	private void convertCurrency() {
	    try {
	        double amount = Double.parseDouble(Panel1_AmountField.getText());
	        String from = fromCurrency.getSelectedItem().toString();
	        String to = toCurrency.getSelectedItem().toString();
	        double rate = getExchangeRate(from, to);

	        if (rate != -1) {
	            double convertedAmount = amount * rate;
	            String result = String.format("%.2f", convertedAmount);
	            Panel1_FinalAmountField.setText(result);

	            // Save transaction to the TransactionHistory class (not the UI class)
	            String logEntry ="  " + amount + " " + from + " = " + result + " " + to;
	            TransactionHistoryPage_G7.addLog(logEntry);

	        } else {
	            Panel1_FinalAmountField.setText("Error fetching exchange rate.");
	        }
	    } catch (Exception ex) {
	        Panel1_FinalAmountField.setText("Invalid input!");
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




	    // FETCH AND DISPLAY ALL EXCHANGE RATES______________________________________________

	    private void fetchAndDisplayExchangeRates(String baseCurrency) {
	        try {
	            String apiKey = "1bc4e3a3d3473315db3525d7"; //API KEY

	            String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

	            URI uri = URI.create(apiUrl);
	            URL url = uri.toURL();
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");

	            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder response = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	            reader.close();

	            // PARSE JSON RESPONSE
	            JSONObject jsonResponse = new JSONObject(response.toString());
	            JSONObject rates = jsonResponse.getJSONObject("conversion_rates");


	            // ITERATE THROUGH ALL CURRENCIES AND ADD THEM AS LABELS
	            Iterator<String> keys = rates.keys();
	            while (keys.hasNext()) {
	                String currency = keys.next();
	                double rate = rates.getDouble(currency);
	                JLabel rateLabel = new JLabel(" "+ currency + ":                              " + rate);
	                Dashboard_Panel2.add(rateLabel);
	                rateLabel.setFont(new Font("Lato", Font.BOLD, 16));
	                rateLabel.setForeground(new Color(0xDFF6FF));
	            }

	            Dashboard_Panel2.revalidate();

	        } catch (Exception e) {
	            e.printStackTrace();
	            JLabel errorLabel = new JLabel("Failed to fetch exchange rates!");

	            Dashboard_Panel2.add(errorLabel);
	        }





	}
	public static void main(String[] args) {
		new DashboardPage_G7();
	}
}
