import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Welcome extends JFrame {
	
	public Welcome() {
		getContentPane().setBackground(Color.BLACK);
		this.setBounds(100, 100, 904, 595);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
	
		JButton login = new JButton("Login");
		login.setForeground(Color.GREEN);
		login.setBackground(Color.BLACK);
		login.setFont(new Font("Tahoma", Font.BOLD, 20));

		login.setBounds(341, 477, 156, 29);
		this.getContentPane().add(login);
		
		JLabel carShop = new JLabel("CarShop");
		carShop.setForeground(Color.GREEN);
		carShop.setBackground(Color.BLACK);
		carShop.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 99));
		carShop.setHorizontalAlignment(SwingConstants.CENTER);
		carShop.setBounds(110, 265, 628, 103);
		getContentPane().add(carShop);
		
		JLabel welcome = new JLabel("BINE ATI VENIT!");
		welcome.setForeground(Color.GREEN);
		welcome.setBackground(Color.BLACK);
		welcome.setFont(new Font("Tahoma", Font.ITALIC, 35));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBounds(192, 364, 459, 103);
		getContentPane().add(welcome);
		
		JLabel masina1 = new JLabel();
		masina1.setBounds(10, 10, 870, 221);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/stop.jpg"));
        masina1.setIcon(img);
		getContentPane().add(masina1);
		
		
		login.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                // JOptionPane.setRootFrame(null);
				dispose();
                Login obj = new Login();
                obj.setTitle("Login");
                obj.setVisible(true);
				
			}
			
		});
	}
}
