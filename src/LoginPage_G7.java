import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage_G7 {
	public LoginPage_G7() {

		//FRAME
		JFrame LoginFrame = new JFrame("Login Page");
		LoginFrame.setSize(800, 600);
		LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		LoginFrame.setResizable(false);
		LoginFrame.setLocationRelativeTo(null);
		LoginFrame.setVisible(true);

		//IMAGE
		ImageIcon LoginRight_background = new ImageIcon("images/right_image.png");

		//PANEL
		JPanel Login_RightPanel = new JPanel(null);

		//LABEL
		JLabel Login_Logo = new JLabel("ByteXChange");
		JLabel Login_Header = new JLabel("Login");

		JLabel LoginRight_bg = new JLabel(LoginRight_background);

		JLabel User_Label = new JLabel("Username");
		JLabel Pass_Label = new JLabel("Password");

		JLabel Or_Label = new JLabel("Or");

		//TEXTFIELD
		JTextField User_TextField = new JTextField("Enter username");
		JTextField Pass_TextField = new JTextField("Enter password");

		//BUTTON
		JButton LoginButton = new JButton("Login");
		JButton CreateNewAccButton = new JButton("Create New Account");

		//ADD
		LoginFrame.setLayout(null);

		LoginFrame.add(Login_Logo);
		LoginFrame.add(Login_Header);

		LoginFrame.add(User_Label);
		LoginFrame.add(User_TextField);

		LoginFrame.add(Pass_Label);
		LoginFrame.add(Pass_TextField);

		LoginFrame.add(LoginButton);
		LoginFrame.add(Or_Label);
		LoginFrame.add(CreateNewAccButton);

		LoginFrame.add(Login_RightPanel);


		Login_RightPanel.add(LoginRight_bg);

		//SET BOUNDS
		Login_Logo.setBounds(55, 35, 150, 35);

		Login_Header.setBounds(177, 140, 150, 35);

		User_Label.setBounds(102, 221, 100, 15);
		User_TextField.setBounds(102, 240, 200, 25);

		Pass_Label.setBounds(102, 276, 100, 15);
		Pass_TextField.setBounds(102, 295, 200, 25);

		LoginButton.setBounds(102, 344, 200, 25);
		Or_Label.setBounds(195, 370, 50, 25);
		CreateNewAccButton.setBounds(102, 399, 200, 25);

		LoginRight_bg.setBounds(0, 0, 400, 600);
		Login_RightPanel.setBounds(400, 0, 400, 600);

		//BG COLOR
		LoginFrame.getContentPane().setBackground(new Color(0x06283D));



		LoginButton.setBackground(new Color(0x47B5FF));
		CreateNewAccButton.setBackground(new Color(0x47B5FF));

		//FONT CUSTOMIZATION
		Login_Logo.setFont(new Font("Lato", Font.BOLD, 20));
		Login_Logo.setForeground(new Color(0xDFF6FF));

		Login_Header.setFont(new Font("Lato", Font.BOLD, 20));
		Login_Header.setForeground(new Color(0xDFF6FF));

		User_Label.setFont(new Font("Lato", Font.BOLD, 11));
		User_Label.setForeground(new Color(0xDFF6FF));

		Pass_Label.setFont(new Font("Lato", Font.BOLD, 11));
		Pass_Label.setForeground(new Color(0xDFF6FF));

		LoginButton.setFont(new Font("Lato", Font.BOLD, 14));
		LoginButton.setForeground(new Color(0xDFF6FF));

		Or_Label.setFont(new Font("Lato", Font.BOLD, 11));
		Or_Label.setForeground(new Color(0xDFF6FF));

		CreateNewAccButton.setFont(new Font("Lato", Font.BOLD, 14));
		CreateNewAccButton.setForeground(new Color(0xDFF6FF));

		//REMOVE BORDER SOLID
		LoginButton.setBorderPainted(false);
		CreateNewAccButton.setBorderPainted(false);
		
		
		//CLICK TO PROCEED TO CREATE NEW ACC
		CreateNewAccButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.dispose();
				new CreateNewAcc_G7();
			}
		});

	}
	public static void main(String[] args) {
		new LoginPage_G7();
	}
}
