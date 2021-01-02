import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Login extends JFrame { //interfata de login
	
	private static final long serialVersionUID = 1L;
	JTextField usr_text;
	JPasswordField pass_text;
	JLabel login;
	JLabel user;
	JLabel password;
	JButton sign;
	private JLabel label__acc;
	
	public Login() {
		
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		this.setBounds(100, 100, 904, 595);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		login = new JLabel("LOGIN");
		login.setForeground(Color.GREEN);
		login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(268, 58, 274, 70);
		getContentPane().add(login);
		
		user = new JLabel("Username:");
		user.setForeground(Color.GREEN);
		user.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		user.setBounds(247, 230, 124, 44);
		getContentPane().add(user);
		
		password = new JLabel("Password:");
		password.setForeground(Color.GREEN);
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		password.setBounds(247, 284, 118, 26);
		getContentPane().add(password);
		
		usr_text = new JTextField();
		usr_text.setBounds(381, 240, 149, 26);
		getContentPane().add(usr_text);
		usr_text.setColumns(10);
		
		pass_text = new JPasswordField();
		pass_text.setBounds(381, 284, 149, 26);
		getContentPane().add(pass_text);
		pass_text.setColumns(10);
		
		sign = new JButton("Sign in");
		sign.setBackground(Color.BLACK);
		sign.setForeground(Color.GREEN);
		sign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		sign.setBounds(330, 360, 141, 53);
		getContentPane().add(sign);
		
		label__acc = new JLabel("Nu ai un cont? Inregistreaza-te");
		label__acc.setFont(new Font("Tahoma", Font.BOLD, 13));
		label__acc.setForeground(Color.GREEN);
		label__acc.setBounds(247, 452, 216, 21);
		getContentPane().add(label__acc);
		
		JButton prepareRegister = new JButton("AICI");
		prepareRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		prepareRegister.setBackground(Color.BLACK);
		prepareRegister.setForeground(Color.GREEN);
		prepareRegister.setBounds(461, 452, 85, 21);
		getContentPane().add(prepareRegister);
		prepareRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		sign.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(usr_text.getText().trim().equalsIgnoreCase("admin") && pass_text.getText().trim().equals("admin")) {
					AdminPanel ah = new AdminPanel();
					ah.setTitle("Welcome");
					ah.setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(login, "Te-ai conectat cu succes! Bun venit!");
				}
				else {
					try {
			        	Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
						
						Statement myStmt = myConn.createStatement();
						Statement myStmt2 = myConn.createStatement();
						
						ResultSet myRs = myStmt.executeQuery("SELECT Username FROM account");
						ResultSet myRs2 = myStmt2.executeQuery("SELECT Password FROM account");
						
						boolean isValidUser = false;
					
						while(myRs.next() && myRs2.next()) {
							String savedPassword = myRs2.getString("Password");
							//System.out.println(savedPassword);
							if(usr_text.getText().trim().equalsIgnoreCase(myRs.getString("Username")) && pass_text.getText().trim().equals(savedPassword)){
								isValidUser = true;
								break;
							
							}
						}
					
						if(isValidUser == false)
							JOptionPane.showMessageDialog(null, "Nume sau parola gresita!");
						else {
							UserPanel ah = new UserPanel();
							ah.setTitle("Welcome");
							ah.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(login, "Te-ai conectat cu succes! Bun venit!");
						}
				
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				/*else if(usr_text.getText().trim().equalsIgnoreCase("user") && pass_text.getText().trim().equals("user")) {
					UserPanel ah = new UserPanel();
					ah.setTitle("Welcome");
					ah.setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(login, "Te-ai conectat cu succes! Bun venit!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Nume sau parola gresita!");
					usr_text.setText(null);
					pass_text.setText(null);
				}*/
				
            }
		});
	}
}
