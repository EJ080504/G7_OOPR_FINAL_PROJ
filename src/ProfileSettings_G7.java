import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ProfileSettings_G7 {
	public ProfileSettings_G7() {

		//FRAME
		JFrame ProfileSettings_Frame = new JFrame("Profile Settings");
		ProfileSettings_Frame.setSize(800, 600);
		ProfileSettings_Frame.setResizable(false);
		ProfileSettings_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ProfileSettings_Frame.setLocationRelativeTo(null);
		ProfileSettings_Frame.setVisible(true);

		//PANEL
		JPanel ProfileSettings_Horizontal = new JPanel();
		JPanel ProfileSettings_Panel = new JPanel();

		//LABEL

		JLabel ProfileSettings_Header = new JLabel("Profile Settings");

		JLabel Panel_EditUserLabel = new JLabel("Edit Username");
		JLabel Panel_ChangePassLabel = new JLabel("Change Password");
		JLabel Panel_SelectDefaultCurrencyLabel = new JLabel("Select Default Currency");

		//TEXTFIELD
		JTextField Panel_EditUserField = new JTextField("Enter new username");
		JTextField Panel_NewPassField = new JTextField("Enter new password");
		JTextField Panel_ConfirmNewPassField = new JTextField("Confirm new password");

		//IMAGE
		ImageIcon ProfileSettings_Exit = new ImageIcon("images/exit-icon 1.png");

		//BUTTON
		JButton ProfileSettings_Logo = new JButton("ByteXChange");
		JButton ProfileSettings_ExitButton = new JButton(ProfileSettings_Exit);

		JButton Panel_DelAcc = new JButton("Delete Account");
		JButton Panel_Save = new JButton("Save");

		//ADD
		ProfileSettings_Frame.setLayout(null);

		ProfileSettings_Frame.add(ProfileSettings_Logo);
		ProfileSettings_Frame.add(ProfileSettings_Header);
		ProfileSettings_Frame.add(ProfileSettings_ExitButton);
		ProfileSettings_Frame.add(ProfileSettings_Horizontal);
		ProfileSettings_Frame.add(ProfileSettings_Panel);

		ProfileSettings_Panel.setLayout(null);
		ProfileSettings_Panel.add(Panel_EditUserLabel);
		ProfileSettings_Panel.add(Panel_ChangePassLabel);
		ProfileSettings_Panel.add(Panel_SelectDefaultCurrencyLabel);
		ProfileSettings_Panel.add(Panel_EditUserField);
		ProfileSettings_Panel.add(Panel_NewPassField);
		ProfileSettings_Panel.add(Panel_ConfirmNewPassField);
		ProfileSettings_Panel.add(Panel_DelAcc);
		ProfileSettings_Panel.add(Panel_Save);

		//SET BOUNDS
		ProfileSettings_Logo.setBounds(55, 35, 180, 30);
		ProfileSettings_ExitButton.setBounds(727, 23, 32, 32);

		ProfileSettings_Header.setBounds(270, 90, 270, 43);
		ProfileSettings_Horizontal.setBounds(65, 154, 670, 1);

		ProfileSettings_Panel.setBounds(69, 186, 665, 353);
		Panel_EditUserLabel.setBounds(30, 30, 120, 20);
		Panel_EditUserField.setBounds(30, 60, 260, 40);

		Panel_ChangePassLabel.setBounds(30, 130, 150, 20);
		Panel_NewPassField.setBounds(30, 160, 260, 40);
		Panel_ConfirmNewPassField.setBounds(30, 220, 260, 40);

		Panel_DelAcc.setBounds(30, 300, 160, 30);

		Panel_SelectDefaultCurrencyLabel.setBounds(380, 30, 200, 20);

		Panel_Save.setBounds(535, 300, 100, 30);

		//BG COLOR
		ProfileSettings_Frame.getContentPane().setBackground(new Color(0x06283D));
		ProfileSettings_Logo.setBackground(new Color(0x06283D));

		ProfileSettings_ExitButton.setBackground(new Color(0x06283D));

		ProfileSettings_Horizontal.setBackground(new Color(0xDFF6FF));

		ProfileSettings_Panel.setBackground(new Color(0x1363DF));

		Panel_DelAcc.setBackground(new Color(0x47B5FF));
		Panel_Save.setBackground(new Color(0x47B5FF));

		//FONT CUSTOMIZATION
		ProfileSettings_Logo.setFont(new Font("Lato", Font.BOLD, 20));
		ProfileSettings_Logo.setForeground(new Color(0xDFF6FF));

		ProfileSettings_Header.setFont(new Font("Lato", Font.BOLD, 36));
		ProfileSettings_Header.setForeground(new Color(0xDFF6FF));

		Panel_EditUserLabel.setFont(new Font("Lato", Font.BOLD, 16));
		Panel_EditUserLabel.setForeground(new Color(0xDFF6FF));

		Panel_ChangePassLabel.setFont(new Font("Lato", Font.BOLD, 16));
		Panel_ChangePassLabel.setForeground(new Color(0xDFF6FF));

		Panel_DelAcc.setFont(new Font("Lato", Font.BOLD, 16));
		Panel_DelAcc.setForeground(new Color(0xDFF6FF));

		Panel_SelectDefaultCurrencyLabel.setFont(new Font("Lato", Font.BOLD, 16));
		Panel_SelectDefaultCurrencyLabel.setForeground(new Color(0xDFF6FF));

		Panel_Save.setFont(new Font("Lato", Font.BOLD, 16));
		Panel_Save.setForeground(new Color(0xDFF6FF));

		//REMOVE BORDER
		ProfileSettings_Logo.setBorderPainted(false);
		Panel_DelAcc.setBorderPainted(false);
		Panel_Save.setBorderPainted(false);
		
	
		//POINTER HOVER
		ProfileSettings_Logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	ProfileSettings_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	ProfileSettings_Logo.setCursor(Cursor.getDefaultCursor());
            }
        });


		//CLICK THE LOGO AND BACK TO DASHBOARD
		ProfileSettings_Logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfileSettings_Frame.dispose();
				new DashboardPage_G7();
			}
		});
	}
	public static void main(String[] args) {
		new ProfileSettings_G7();
	}
}
