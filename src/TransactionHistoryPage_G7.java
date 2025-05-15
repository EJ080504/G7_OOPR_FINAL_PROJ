import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryPage_G7 extends JFrame {
	public TransactionHistoryPage_G7() {

		//FRAME
		JFrame TranHistory_Frame = new JFrame("Transaction History");
		TranHistory_Frame.setSize(800, 600);
		TranHistory_Frame.setResizable(false);
		TranHistory_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		TranHistory_Frame.setLocationRelativeTo(null);
		TranHistory_Frame.setVisible(true);
		
		JTextArea transactionTextArea = new JTextArea();
		transactionTextArea.setEditable(false);
		transactionTextArea.setFont(new Font("Lato", Font.BOLD, 18));
		transactionTextArea.setBackground(new Color(0x1363DF));
		transactionTextArea.setForeground(new Color(0xDFF6FF));

		// Add scroll pane in case the text overflows
		JScrollPane scrollPane = new JScrollPane(transactionTextArea);
		scrollPane.setBounds(0, 0, 662, 339);
		scrollPane.setBorder(null);


		//PANEL
		JPanel TranHistory_Horizontal = new JPanel();
		JPanel TranHistory_BoardPanel = new JPanel();

		//LABEL

		JLabel TranHistory_Header = new JLabel("Transaction History");

		//IMAGE
		ImageIcon TransactionHistory_Exit = new ImageIcon("images/exit-icon 1.png");

		//BUTTON
		JButton TranHistory_Logo = new JButton("ByteXChange");
		JButton TranHistory_ExitButton = new JButton(TransactionHistory_Exit);
		JButton TranHistory_ExportButton = new JButton("Export Transaction");
		JButton Transaction_ClearAllButton = new JButton("Clear all");

		//ADD
		TranHistory_Frame.setLayout(null);

		TranHistory_Frame.add(TranHistory_Logo);
	
		TranHistory_Frame.add(TranHistory_Header);
		TranHistory_Frame.add(TranHistory_Horizontal);
		TranHistory_Frame.add(TranHistory_ExportButton);
		TranHistory_Frame.add(TranHistory_BoardPanel);
		
		TranHistory_BoardPanel.add(Transaction_ClearAllButton);
		
		//SET BOUNDS
		TranHistory_Logo.setBounds(55, 35, 180, 25);

		TranHistory_Header.setBounds(242, 90, 350, 40);
		TranHistory_Horizontal.setBounds(55, 154, 670, 1);

		TranHistory_ExportButton.setBounds(550, 162, 170, 30);
		TranHistory_BoardPanel.setBounds(60, 200, 662, 339);
		
		Transaction_ClearAllButton.setBounds(540, 300, 110, 30);

		//BG COLOR
		TranHistory_Logo.setBackground(new Color(0x06283D));

		TranHistory_Frame.getContentPane().setBackground(new Color(0x06283D));
		

		TranHistory_Horizontal.setBackground(new Color(0xDFF6FF));
		TranHistory_ExportButton.setBackground(new Color(0x1363DF));

		TranHistory_BoardPanel.setBackground(new Color(0x1363DF));
		
		Transaction_ClearAllButton.setBackground(new Color(0x47B5FF));

		//FONT CUSTOMIZATION
		TranHistory_Logo.setFont(new Font("Lato", Font.BOLD, 20));
		TranHistory_Logo.setForeground(new Color(0xDFF6FF));

		TranHistory_Header.setFont(new Font("Lato", Font.BOLD, 36));
		TranHistory_Header.setForeground(new Color(0xDFF6FF));

		TranHistory_ExportButton.setFont(new Font("Lato", Font.BOLD, 13));
		TranHistory_ExportButton.setForeground(new Color(0xDFF6FF));
		
		Transaction_ClearAllButton.setFont(new Font ("Lato", Font.BOLD, 14));
		Transaction_ClearAllButton.setForeground(new Color(0xDFF6FF));
		
		
		//REMOVE BORDER
		TranHistory_Logo.setBorderPainted(false);
		Transaction_ClearAllButton.setBorderPainted(false);
		
		// Add to the board panel
		TranHistory_BoardPanel.setLayout(null);
		TranHistory_BoardPanel.add(scrollPane);
		
		

		// Load saved transactions from TransactionHistory class
		StringBuilder logBuilder = new StringBuilder();
		for (String log : TransactionHistoryPage_G7.getLogs()) {
		    logBuilder.append(log).append("\n");
		}
		transactionTextArea.setText(logBuilder.toString());
		
		
		//POINTER HOVER
		TranHistory_Logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	TranHistory_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	TranHistory_Logo.setCursor(Cursor.getDefaultCursor());
            }
        });
		
		Transaction_ClearAllButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Transaction_ClearAllButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				TranHistory_Logo.setCursor(Cursor.getDefaultCursor());
			}
		});


		//CLICK THE LOGO AND BACK TO DASHBOARD
		TranHistory_Logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TranHistory_Frame.dispose();
				new DashboardPage_G7();
			}
		});
		
		
		Transaction_ClearAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logs.clear(); // clear the list
				transactionTextArea.setText(""); // clear the display
				JOptionPane.showMessageDialog(null, "All transactions cleared.");
			}
		});
		
		TranHistory_ExportButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Save Transactions");

		        int userSelection = fileChooser.showSaveDialog(null);
		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            try {
		                java.io.File fileToSave = fileChooser.getSelectedFile();
		                // Ensure the file ends with .txt
		                if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
		                    fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".txt");
		                }

		                FileWriter writer = new FileWriter(fileToSave);
		                for (String log : logs) {
		                    writer.write(log + "\n");
		                }
		                writer.close();

		                JOptionPane.showMessageDialog(null, "Transactions exported successfully!");
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error exporting transactions: " + ex.getMessage());
		            }
		        }
		    }
		});

	}
	
	    private static final List<String> logs = new ArrayList<>();

	    public static void addLog(String log) {
	        logs.add(log);
	    }

	    public static List<String> getLogs() {
	        return logs;
	    }
	    

	

	
    
	public static void main(String[] args) {
		new TransactionHistoryPage_G7();
	}
}
