import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateNewAcc_G7 {
	public CreateNewAcc_G7() {

		//FRAME
		JFrame CreateNewAcc_Frame = new JFrame("Create New Account");
		CreateNewAcc_Frame.setSize(800, 600);
		CreateNewAcc_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		CreateNewAcc_Frame.setResizable(false);
		CreateNewAcc_Frame.setVisible(true);
		CreateNewAcc_Frame.setLocationRelativeTo(null);

		//IMAGE
		ImageIcon CNA_RightImage = new ImageIcon("images/cna_right_image.png");

		//PANEL
		JPanel CNA_RightPanel = new JPanel(null);

		//LABEL
		JLabel CNARight_bg = new JLabel(CNA_RightImage);

		JLabel CreateNewAcc_Logo = new JLabel("ByteXChange");
		JLabel CreateNewAcc_Header = new JLabel("Create New Account");
		

		JLabel CNA_UserLabel = new JLabel("Username");
		JLabel CNA_PassLabel = new JLabel("Password");
		JLabel CNA_ConPassLabel = new JLabel("Confirm Password");

		//TEXTFIELD
		JTextField CNA_UserField = new JTextField("Enter username");
		JTextField CNA_PassField = new JTextField("Enter password");
		JTextField CNA_ConPassField = new JTextField("Confirm Password");

		//BUTTON
		JButton CNA_CreateNewAccButton = new JButton("Create New Account");

		//ADD
		CreateNewAcc_Frame.setLayout(null);
		CreateNewAcc_Frame.add(CreateNewAcc_Logo);
		CreateNewAcc_Frame.add(CreateNewAcc_Header);

		CreateNewAcc_Frame.add(CNA_UserLabel);
		CreateNewAcc_Frame.add(CNA_UserField);

		CreateNewAcc_Frame.add(CNA_PassLabel);
		CreateNewAcc_Frame.add(CNA_PassField);

		CreateNewAcc_Frame.add(CNA_ConPassLabel);
		CreateNewAcc_Frame.add(CNA_ConPassField);

		CreateNewAcc_Frame.add(CNA_CreateNewAccButton);

		CreateNewAcc_Frame.add(CNA_RightPanel);
		CNA_RightPanel.add(CNARight_bg);

		//SET BOUNDS
		CreateNewAcc_Logo.setBounds(55, 35, 150, 35);

		CreateNewAcc_Header.setBounds(110, 140, 200, 35);

		CNA_UserLabel.setBounds(102, 221, 100, 15);
		CNA_UserField.setBounds(102, 240, 200, 25);

		CNA_PassLabel.setBounds(102, 276, 100, 15);
		CNA_PassField.setBounds(102, 295, 200, 25);

		CNA_ConPassLabel.setBounds(102, 326, 150, 15);
		CNA_ConPassField.setBounds(102, 345, 200, 25);

		CNA_CreateNewAccButton.setBounds(102, 399, 200, 25);

		CNA_RightPanel.setBounds(400, 0, 400, 600);
		CNARight_bg.setBounds(0, 0, 400, 600);

		//BG COLOR
		CreateNewAcc_Frame.getContentPane().setBackground(new Color(0x06283D));


		CNA_CreateNewAccButton.setBackground(new Color(0x47B5FF));

		//FONT CUSTOMIZATION
		CreateNewAcc_Logo.setFont(new Font("Lato", Font.BOLD, 20));
		CreateNewAcc_Logo.setForeground(new Color(0xDFF6FF));

		CreateNewAcc_Header.setFont(new Font("Lato", Font.BOLD, 20));
		CreateNewAcc_Header.setForeground(new Color(0xDFF6FF));

		CNA_UserLabel.setFont(new Font("Lato", Font.BOLD, 11));
		CNA_UserLabel.setForeground(new Color(0xDFF6FF));

		CNA_PassLabel.setFont(new Font("Lato", Font.BOLD, 11));
		CNA_PassLabel.setForeground(new Color(0xDFF6FF));

		CNA_ConPassLabel.setFont(new Font("Lato", Font.BOLD, 11));
		CNA_ConPassLabel.setForeground(new Color(0xDFF6FF));

		CNA_CreateNewAccButton.setFont(new Font("Lato", Font.BOLD, 14));
		CNA_CreateNewAccButton.setForeground(new Color(0xDFF6FF));

		//REMOVE BORDER BUTTON
		CNA_CreateNewAccButton.setBorderPainted(false);
		
		
		CNA_CreateNewAccButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = CNA_UserField.getText();
				String password = CNA_PassField.getText();
				String confirmPassword = CNA_ConPassField.getText();

				if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(CreateNewAcc_Frame, "Passwords do not match.");
					return;
				}

				try {
					// Connect to MySQL
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db", "root", "");

					// Insert the user into the users table
					String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, username);
					stmt.setString(2, PasswordUtil.hashPassword(password));

					int rowsInserted = stmt.executeUpdate();

					if (rowsInserted > 0) {
						JOptionPane.showMessageDialog(CreateNewAcc_Frame, "Account created successfully!");
						CreateNewAcc_Frame.dispose();
						new LoginPage_G7(); // Go back to login
					}

					conn.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(CreateNewAcc_Frame, "Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		
	

	}
	public static void main(String[] args) {
		new CreateNewAcc_G7();
	}
}
