import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Register extends JFrame {
	private JTextField nume_t;
	private JTextField prenume_t;
	private JTextField email_t;
	private JTextField username_t;
	private JPasswordField password_t;
	private JPasswordField confirmPassword_t;
	
	public Register() {
		getContentPane().setBackground(Color.BLACK);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 904, 595);
		getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel register_l = new JLabel("INREGISTRARE");
		register_l.setBackground(Color.BLACK);
		register_l.setForeground(Color.GREEN);
		register_l.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		register_l.setHorizontalAlignment(SwingConstants.CENTER);
		register_l.setBounds(260, 46, 524, 63);
		getContentPane().add(register_l);
		
		JLabel nume_l = new JLabel("Nume:");
		nume_l.setBackground(Color.BLACK);
		nume_l.setForeground(Color.GREEN);
		nume_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		nume_l.setHorizontalAlignment(SwingConstants.RIGHT);
		nume_l.setBounds(42, 165, 137, 28);
		getContentPane().add(nume_l);
		
		JLabel prenume_l = new JLabel("Prenume:");
		prenume_l.setForeground(Color.GREEN);
		prenume_l.setBackground(Color.BLACK);
		prenume_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		prenume_l.setHorizontalAlignment(SwingConstants.RIGHT);
		prenume_l.setBounds(42, 246, 137, 28);
		getContentPane().add(prenume_l);
		
		JLabel email_l = new JLabel("Email:");
		email_l.setBackground(Color.BLACK);
		email_l.setForeground(Color.GREEN);
		email_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		email_l.setHorizontalAlignment(SwingConstants.RIGHT);
		email_l.setBounds(42, 317, 137, 28);
		getContentPane().add(email_l);
		
		JLabel username_l = new JLabel("Username:");
		username_l.setBackground(Color.BLACK);
		username_l.setForeground(Color.GREEN);
		username_l.setHorizontalAlignment(SwingConstants.RIGHT);
		username_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		username_l.setBounds(567, 165, 174, 28);
		getContentPane().add(username_l);
		
		JLabel password_l = new JLabel("Password:");
		password_l.setBackground(Color.BLACK);
		password_l.setForeground(Color.GREEN);
		password_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		password_l.setHorizontalAlignment(SwingConstants.RIGHT);
		password_l.setBounds(567, 246, 174, 28);
		getContentPane().add(password_l);
		
		JLabel confimPassword_l = new JLabel("Confirm password:");
		confimPassword_l.setBackground(Color.BLACK);
		confimPassword_l.setForeground(Color.GREEN);
		confimPassword_l.setFont(new Font("Tahoma", Font.BOLD, 18));
		confimPassword_l.setBounds(567, 317, 174, 28);
		getContentPane().add(confimPassword_l);
	
		nume_t = new JTextField();
		nume_t.setBounds(189, 173, 96, 19);
		getContentPane().add(nume_t);
		nume_t.setColumns(10);
	
		prenume_t = new JTextField();
		prenume_t.setBounds(189, 254, 96, 19);
		getContentPane().add(prenume_t);
		prenume_t.setColumns(10);
		
		email_t = new JTextField();
		email_t.setBounds(189, 325, 96, 19);
		getContentPane().add(email_t);
		email_t.setColumns(10);
		
		username_t = new JTextField();
		username_t.setBounds(751, 173, 96, 19);
		getContentPane().add(username_t);
		username_t.setColumns(10);
		
		password_t = new JPasswordField();
		password_t.setBounds(751, 254, 96, 19);
		getContentPane().add(password_t);
		
		confirmPassword_t = new JPasswordField();
		confirmPassword_t.setBounds(751, 325, 96, 19);
		getContentPane().add(confirmPassword_t);
		
		JButton register_b = new JButton("Inregistrare");
		register_b.setBackground(Color.BLACK);
		register_b.setForeground(Color.GREEN);
		register_b.setFont(new Font("Tahoma", Font.BOLD, 18));
		register_b.setBounds(346, 405, 190, 46);
		getContentPane().add(register_b);
		register_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int ok = JOptionPane.showConfirmDialog(null, "Esti sigur ca doresti sa te inregistrezi?");
				
				if(ok == JOptionPane.YES_OPTION) {
					
					Connection myConn;
					try {
						myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
						String query = "insert into account(Nume, Prenume, Email, Username, Password, Confirm_Password)values(?, ?, ?, ?, ?, ?)";
		         		PreparedStatement pst = myConn.prepareStatement(query);
		         		
		         		if(password_t.getText().equals(confirmPassword_t.getText())) {
		         			pst.setString(1,  nume_t.getText());
			         		pst.setString(2,  prenume_t.getText());
			         		pst.setString(3, email_t.getText());
			         		pst.setString(4,  username_t.getText());
			         		pst.setString(5, password_t.getText());
			         		pst.setString(6,  confirmPassword_t.getText());
			         		
			         		pst.executeUpdate();
			         		Login login = new Login();
			         		dispose();
			         		login.setVisible(true);
			         		JOptionPane.showMessageDialog(null, "Contul a fost creat cu succes!");
		         		}
		         		else {
		         			JOptionPane.showMessageDialog(null, "A intervenit o problema!");
		         			password_t.setText(null);
		         			confirmPassword_t.setText(null);
		         		}
		         		
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
			
		});
		
		JButton anuleaza_b = new JButton("Anuleaza");
		anuleaza_b.setFont(new Font("Tahoma", Font.BOLD, 14));
		anuleaza_b.setBackground(Color.BLACK);
		anuleaza_b.setForeground(Color.GREEN);
		anuleaza_b.setBounds(382, 461, 110, 21);
		getContentPane().add(anuleaza_b);
		anuleaza_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ok = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa te intorci?");
				if(ok ==JOptionPane.YES_OPTION) {
					Login login = new Login();
	         		dispose();
	         		login.setVisible(true);
				}
			}
		});
		
		
		
		
	}
}
