import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

public class UserPanel extends JFrame {
	 static final long serialVersionUID = 1;
	 JPanel contentPane;
	 JPanel panel4;
	 JPanel panel3;
	 JPanel panel1;
	 JLayeredPane layeredPane;

	 JTextField marca_t;
	 JTextField model_t;
	 JTextField anulFabricatiei_t;
	 JTextField distantaParcursa_t;
	 JTextField culoare_t;
	 JTextField normaDePoluare_t;
	 JTextField cutieDeViteze_t;
	 JTextField combustibil_t;
	 JTextField caroserie_t;
	 JTextField capacitateCilindrica_t;
	 JTextField pret_t;
	 
	 JComboBox<String> marca_comboBox;
	 JComboBox<String> model_comboBox;

	 JTextField caroserieCB_t;
	 JTextField capacitateCilindricaCB_t;
	 JTextField pretCB_t;
	 JTextField anulFabricatieiCB_t;
	 JTextField normaDePoluareCB_t;
	 JTextField combustibilCB_t;
	 JTextField cutieDeVitezeCB_t;
	 JTextField marcaCB_t;
	 JTextField modelCB_t;
	 JTextField distantaParcursaCB_t;
	 JTextField culoareCB_t;
	 
	 static List<Car> arr = new ArrayList<>();
	 int pozitie;
	 int poz;
	 List<Car> CBList = new ArrayList<>();

	 public UserPanel() {
		pozitie = 0;
		poz = 0;
		 
		 this.setResizable(false);

		
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(268, 58, 1014, 597);
	     
	        contentPane = new JPanel();
	        contentPane.setBackground(Color.BLACK);
	        contentPane.setForeground(Color.BLACK);
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        JButton logout = new JButton("Logout");
	        logout.setBounds(890, 15, 101, 22);
	        logout.setForeground(Color.GREEN);
	        logout.setBackground(Color.BLACK);
	        logout.setFont(new Font("Tahoma", Font.BOLD, 18));
	        logout.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int a = JOptionPane.showConfirmDialog(logout, "Esti sigur?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    Welcome obj = new Welcome();
	                    obj.setTitle("Login");
	                    obj.setVisible(true);

	                }

	            }
	        });
	        contentPane.setLayout(null);
	        contentPane.add(logout);
	        
	        try {
	        	Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
				
				Statement myStmt = myConn.createStatement();
				
				ResultSet myRs = myStmt.executeQuery("select * from cars");
				
				int nrMasini = 0;
				while(myRs.next())
					nrMasini++;
				
				ResultSet myRs2 = myStmt.executeQuery("select DISTINCT(Marca) from cars");
				
				int nrProducatori = 0;
				while(myRs2.next())
					nrProducatori++;
				
				int countVechime = 0;
				int sumaVechime = 0;
				ResultSet myRs3 = myStmt.executeQuery("select DISTINCT(Anul_fabricatiei) from cars");
				while(myRs3.next()) {
					countVechime++;
					sumaVechime += myRs3.getInt("Anul_fabricatiei");
				}
				
				ResultSet myRs4 = myStmt.executeQuery("SELECT Pret FROM cars");
				int countPret = 0;
				int sumaPret = 0;
				while(myRs4.next()) {
					countPret++;
					sumaPret += myRs4.getInt("Pret");
				}
				
				ResultSet myRs5 = myStmt.executeQuery("SELECT Km FROM cars");
				int countDistanta = 0;
				int sumaDistanta = 0;
				while(myRs5.next()) {
					countDistanta++;
					sumaDistanta += myRs5.getInt("Km");
				}

				
				layeredPane = new JLayeredPane();
		        layeredPane.setBounds(10, 252, 980, 286);
		        contentPane.add(layeredPane);
		        layeredPane.setLayout(new CardLayout(0, 0));
		        
		        panel1 = new JPanel();
		        panel1.setBackground(Color.BLACK);
		        layeredPane.add(panel1);
		        panel1.setLayout(null); //pozitionare absoluta - ajuta "componentele"
		        
		        JLabel totalMasini = new JLabel("Numarul total de masini: " + nrMasini);
		        totalMasini.setForeground(Color.GREEN);
		        totalMasini.setBackground(Color.BLACK);
		        totalMasini.setFont(new Font("Tahoma", Font.BOLD, 17));
		        totalMasini.setBounds(10, 28, 461, 38);
		        panel1.add(totalMasini);
		        
		        JLabel totalProducatori = new JLabel("Numarul total de producatori: " + nrProducatori);
		        totalProducatori.setBackground(Color.BLACK);
		        totalProducatori.setForeground(Color.GREEN);
		        totalProducatori.setFont(new Font("Tahoma", Font.BOLD, 17));
		        totalProducatori.setBounds(10, 76, 461, 38);
		        panel1.add(totalProducatori);
		        
		        JLabel pretMediu = new JLabel("Pretul mediu al unei masini: " + sumaPret/countPret + " $");
		        pretMediu.setForeground(Color.GREEN);
		        pretMediu.setBackground(Color.BLACK);
		        pretMediu.setFont(new Font("Tahoma", Font.BOLD, 17));
		        pretMediu.setBounds(10, 124, 461, 31);
		        panel1.add(pretMediu);
		        
		        JLabel distantaMedie = new JLabel("Distanta medie parcursa de o masina: " + sumaDistanta/countDistanta + " km");
		        distantaMedie.setForeground(Color.GREEN);
		        distantaMedie.setBackground(Color.BLACK);
		        distantaMedie.setFont(new Font("Tahoma", Font.BOLD, 17));
		        distantaMedie.setBounds(10, 165, 461, 31);
		        panel1.add(distantaMedie);
		        
		        JLabel vechime = new JLabel("Vechimea medie: " + sumaVechime/countVechime);
		        vechime.setForeground(Color.GREEN);
		        vechime.setBackground(Color.BLACK);
		        vechime.setFont(new Font("Tahoma", Font.BOLD, 17));
		        vechime.setBounds(10, 206, 461, 31);
		        panel1.add(vechime);
		        
		        panel3 = new JPanel();
		        panel3.setBackground(Color.BLACK);
		        layeredPane.add(panel3);
		        panel3.setLayout(null);
		        
		        marca_comboBox = new JComboBox<String>();
		        marca_comboBox.setBackground(Color.BLACK);
		        marca_comboBox.setForeground(Color.GREEN);
		        ComboBox1(); //umplere primul comboBox ( Marca )
		        marca_comboBox.addItemListener(new ItemListener() {
		        	
		        	public void itemStateChanged(ItemEvent e) {
		        	
		        		if(marca_comboBox.getSelectedItem().equals("Model"))
		        			model_comboBox.setEnabled(false);
		        		else {
		        			model_comboBox.setEnabled(true);
		        			
		        			Set<String> set_model = new HashSet<>();
				        	
			        		model_comboBox.removeAllItems();
			        		for(int i = 0; i < arr.size(); i++) {
			        			
			        			if(marca_comboBox.getSelectedItem().equals(arr.get(i).getMarca()))
			        				set_model.add(arr.get(i).getModel()); //pregatirea setului pentru adaugarea elementelor in cel de-al doilea comboBox ( Model )
			        		}
			        	
			        		List<String> list_model = new ArrayList<String>(set_model);
			        		Collections.sort(list_model);
			        		
			        		model_comboBox.addItem("Model");
			        		for(String s: list_model)
			        			model_comboBox.addItem(s); //umplerea celui de-al doilea comboBox ( Model )
		        		}
		        	
		        	}
		        
		        });
		        
		        model_comboBox = new JComboBox<String>();
		        model_comboBox.setForeground(Color.GREEN);
		        model_comboBox.setBackground(Color.BLACK);
		        marca_comboBox.setBounds(10, 48, 141, 21);
		        model_comboBox.setBounds(161, 48, 141, 21);
		        
		        panel3.add(marca_comboBox);
		        panel3.add(model_comboBox);
		        
		        JButton cauta = new JButton("EFECTUATI CAUTAREA");
		        cauta.setForeground(Color.GREEN);
		        cauta.setBackground(Color.BLACK);
		        cauta.setFont(new Font("Tahoma", Font.BOLD, 17));
		        cauta.setBounds(344, 76, 234, 21);
		        panel3.add(cauta);
		        cauta.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		//String s = marca_comboBox.getSelectedItem().toString();
		        		addInArray();
		        		
		        		if(arr.isEmpty())
		        			JOptionPane.showMessageDialog(null, "Nu sunt masini in lista!");
		        		else {
		        			if(pozitie == arr.size()-1)
		        				pozitie = -1;
		        			
		        			for(int i = 0; i < arr.size(); i++)
		        				if(arr.get(i).getMarca().equals(marca_comboBox.getSelectedItem().toString()) && arr.get(i).getModel().equals(model_comboBox.getSelectedItem().toString())) {
		        					marcaCB_t.setText(arr.get(i).getMarca());
				        			modelCB_t.setText(arr.get(i).getModel());
				        			distantaParcursaCB_t.setText(String.valueOf(arr.get(i).getKm()));
				        			culoareCB_t.setText(arr.get(i).getCuloare());
				        			anulFabricatieiCB_t.setText(String.valueOf(arr.get(i).getAnul_fabricatiei()));
				        			normaDePoluareCB_t.setText(arr.get(i).getNorme_de_poluare());
				        			combustibilCB_t.setText(arr.get(i).getCombustibil());
				        			cutieDeVitezeCB_t.setText(arr.get(i).getCutie_de_viteze());
				        			caroserieCB_t.setText(arr.get(i).getCaroserie());
				        			capacitateCilindricaCB_t.setText(String.valueOf(arr.get(i).getCapacitate_cilindrica()));
				        			pretCB_t.setText(String.valueOf(arr.get(i).getPret()));
				        			
				        			CBList.add(arr.get(i));
				        			
				        			pozitie = i; //pastram pozitia primei masini gasite
				        			
				        			break;
		        				}
		        		}
		        	}
		        });
		        
		        JLabel marcaCB_l = new JLabel("Marca:");
		        marcaCB_l.setForeground(Color.GREEN);
		        marcaCB_l.setBackground(Color.BLACK);
		        marcaCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        marcaCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        marcaCB_l.setBounds(87, 117, 87, 21);
		        panel3.add(marcaCB_l);
		        
		        JLabel modelCB_l = new JLabel("Model:");
		        modelCB_l.setBackground(Color.BLACK);
		        modelCB_l.setForeground(Color.GREEN);
		        modelCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        modelCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        modelCB_l.setBounds(87, 148, 87, 21);
		        panel3.add(modelCB_l);
		        
		        JLabel distantaParcursaCB_l = new JLabel("Distanta parcursa:");
		        distantaParcursaCB_l.setForeground(Color.GREEN);
		        distantaParcursaCB_l.setBackground(Color.BLACK);
		        distantaParcursaCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        distantaParcursaCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        distantaParcursaCB_l.setBounds(10, 179, 164, 21);
		        panel3.add(distantaParcursaCB_l);
		        
		        JLabel culoareCB_l = new JLabel("Culoare:");
		        culoareCB_l.setForeground(Color.GREEN);
		        culoareCB_l.setBackground(Color.BLACK);
		        culoareCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        culoareCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        culoareCB_l.setBounds(87, 210, 87, 21);
		        panel3.add(culoareCB_l);
		        
		        JLabel anulFabricatieiCB_l = new JLabel("Anul fabricatiei:");
		        anulFabricatieiCB_l.setBackground(Color.BLACK);
		        anulFabricatieiCB_l.setForeground(Color.GREEN);
		        anulFabricatieiCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        anulFabricatieiCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        anulFabricatieiCB_l.setBounds(331, 117, 141, 21);
		        panel3.add(anulFabricatieiCB_l);
		        
		        JLabel normaDePoluareCB_l = new JLabel("Norma de poluare:");
		        normaDePoluareCB_l.setForeground(Color.GREEN);
		        normaDePoluareCB_l.setBackground(Color.BLACK);
		        normaDePoluareCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        normaDePoluareCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        normaDePoluareCB_l.setBounds(316, 153, 156, 17);
		        panel3.add(normaDePoluareCB_l);
		        
		        JLabel combustibilCB_l = new JLabel("Combustibil:");
		        combustibilCB_l.setForeground(Color.GREEN);
		        combustibilCB_l.setBackground(Color.BLACK);
		        combustibilCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        combustibilCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        combustibilCB_l.setBounds(366, 181, 106, 17);
		        panel3.add(combustibilCB_l);
		        
		        JLabel cutieDeVitezeCB_l = new JLabel("Cutie de viteze:");
		        cutieDeVitezeCB_l.setForeground(Color.GREEN);
		        cutieDeVitezeCB_l.setBackground(Color.BLACK);
		        cutieDeVitezeCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        cutieDeVitezeCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        cutieDeVitezeCB_l.setBounds(331, 212, 141, 17);
		        panel3.add(cutieDeVitezeCB_l);
		        
		        JLabel caroserieCB_l = new JLabel("Caroserie:");
		        caroserieCB_l.setForeground(Color.GREEN);
		        caroserieCB_l.setBackground(Color.BLACK);
		        caroserieCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        caroserieCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        caroserieCB_l.setBounds(669, 119, 120, 17);
		        panel3.add(caroserieCB_l);
		        
		        JLabel capacitateCilindricaCB_l = new JLabel("Capacitate cilindrica:");
		        capacitateCilindricaCB_l.setForeground(Color.GREEN);
		        capacitateCilindricaCB_l.setBackground(Color.BLACK);
		        capacitateCilindricaCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        capacitateCilindricaCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        capacitateCilindricaCB_l.setBounds(605, 149, 184, 19);
		        panel3.add(capacitateCilindricaCB_l);
		        
		        JLabel pretCB_l = new JLabel("Pret:");
		        pretCB_l.setForeground(Color.GREEN);
		        pretCB_l.setBackground(Color.BLACK);
		        pretCB_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        pretCB_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        pretCB_l.setBounds(669, 181, 120, 17);
		        panel3.add(pretCB_l);
		        
		        caroserieCB_t = new JTextField();
		        caroserieCB_t.setBounds(799, 121, 96, 19);
		        panel3.add(caroserieCB_t);
		        caroserieCB_t.setColumns(10);
		        caroserieCB_t.setEditable(false);
		        
		        capacitateCilindricaCB_t = new JTextField();
		        capacitateCilindricaCB_t.setBounds(799, 152, 96, 19);
		        panel3.add(capacitateCilindricaCB_t);
		        capacitateCilindricaCB_t.setColumns(10);
		        capacitateCilindricaCB_t.setEditable(false);
		        
		        pretCB_t = new JTextField();
		        pretCB_t.setBounds(799, 183, 96, 19);
		        panel3.add(pretCB_t);
		        pretCB_t.setColumns(10);
		        pretCB_t.setEditable(false);
		        
		        anulFabricatieiCB_t = new JTextField();
		        anulFabricatieiCB_t.setBounds(482, 121, 96, 19);
		        panel3.add(anulFabricatieiCB_t);
		        anulFabricatieiCB_t.setColumns(10);
		        anulFabricatieiCB_t.setEditable(false);
		        
		        normaDePoluareCB_t = new JTextField();
		        normaDePoluareCB_t.setBounds(482, 152, 96, 19);
		        panel3.add(normaDePoluareCB_t);
		        normaDePoluareCB_t.setColumns(10);
		        normaDePoluareCB_t.setEditable(false);
		        
		        combustibilCB_t = new JTextField();
		        combustibilCB_t.setBounds(482, 183, 96, 19);
		        panel3.add(combustibilCB_t);
		        combustibilCB_t.setColumns(10);
		        combustibilCB_t.setEditable(false);
		        
		        cutieDeVitezeCB_t = new JTextField();
		        cutieDeVitezeCB_t.setBounds(482, 214, 96, 19);
		        panel3.add(cutieDeVitezeCB_t);
		        cutieDeVitezeCB_t.setColumns(10);
		        cutieDeVitezeCB_t.setEditable(false);
		        
		        marcaCB_t = new JTextField();
		        marcaCB_t.setBounds(184, 121, 96, 19);
		        panel3.add(marcaCB_t);
		        marcaCB_t.setColumns(10);
		        marcaCB_t.setEditable(false);
		        
		        modelCB_t = new JTextField();
		        modelCB_t.setBounds(184, 152, 96, 19);
		        panel3.add(modelCB_t);
		        modelCB_t.setColumns(10);
		        modelCB_t.setEditable(false);
		        
		        distantaParcursaCB_t = new JTextField();
		        distantaParcursaCB_t.setBounds(184, 183, 96, 19);
		        panel3.add(distantaParcursaCB_t);
		        distantaParcursaCB_t.setColumns(10);
		        distantaParcursaCB_t.setEditable(false);
		        
		        culoareCB_t = new JTextField();
		        culoareCB_t.setBounds(184, 214, 96, 19);
		        panel3.add(culoareCB_t);
		        culoareCB_t.setColumns(10);
		        culoareCB_t.setEditable(false);
		        
		        JButton nextCB_b = new JButton("NEXT");
		        nextCB_b.setForeground(Color.GREEN);
		        nextCB_b.setBackground(Color.BLACK);
		        nextCB_b.setFont(new Font("Tahoma", Font.BOLD, 17));
		        nextCB_b.setBounds(540, 255, 142, 21);

		        nextCB_b.addActionListener(new ActionListener() {
		        	
					public void actionPerformed(ActionEvent e) {
						
						if(CBList.isEmpty())
							JOptionPane.showMessageDialog(null, "Nu exista nicio masina de acest tip!");
						else {
						
							if(poz == CBList.size()-1) {
								poz = -1; //pentru a nu se opri cand ajungem la ultima masina, facem sa se roteasca
								//JOptionPane.showMessageDialog(null, "S-a ajuns la ultima masina din lista");
							}
							else {
								
								CBList.clear();
								list_ComboBox(); //adauga elementele in lista
								poz += 1;
							
								marcaCB_t.setText(CBList.get(poz).getMarca());
			        			modelCB_t.setText(CBList.get(poz).getModel());
			        			distantaParcursaCB_t.setText(String.valueOf(CBList.get(poz).getKm()));
			        			culoareCB_t.setText(CBList.get(poz).getCuloare());
			        			anulFabricatieiCB_t.setText(String.valueOf(CBList.get(poz).getAnul_fabricatiei()));
			        			normaDePoluareCB_t.setText(CBList.get(poz).getNorme_de_poluare());
			        			combustibilCB_t.setText(CBList.get(poz).getCombustibil());
			        			cutieDeVitezeCB_t.setText(CBList.get(poz).getCutie_de_viteze());
			        			caroserieCB_t.setText(CBList.get(poz).getCaroserie());
			        			capacitateCilindricaCB_t.setText(String.valueOf(CBList.get(poz).getCapacitate_cilindrica()));
			        			pretCB_t.setText(String.valueOf(CBList.get(poz).getPret()));

							}

						}
						
					}
		        	
		        });	        
		        panel3.add(nextCB_b);
		        
		        JButton cumparaCB_b = new JButton("CUMPARA");
		        cumparaCB_b.setForeground(Color.CYAN);
		        cumparaCB_b.setBackground(Color.BLACK);
		        cumparaCB_b.setFont(new Font("Tahoma", Font.BOLD, 17));
		        cumparaCB_b.setBounds(388, 255, 142, 21);
		        panel3.add(cumparaCB_b);
		        cumparaCB_b.addActionListener(new ActionListener() {
		        
		        	public void actionPerformed(ActionEvent e) {
		        		String marcaCB = marcaCB_t.getText();
		        		String modelCB = modelCB_t.getText();
		        		int distantaParcursaCB = Integer.parseInt(distantaParcursaCB_t.getText());
		        		String culoareCB = culoareCB_t.getText();
		        		int anulFabricatieiCB = Integer.parseInt(anulFabricatieiCB_t.getText());
		        		String normaDePoluareCB = normaDePoluareCB_t.getText();
		        		String combustibilCB = combustibilCB_t.getText();
		        		String cutieDeVitezeCB = cutieDeVitezeCB_t.getText();
		        		String caroserieCB = caroserieCB_t.getText();
		        		int capacitateCilindricaCB = Integer.parseInt(capacitateCilindricaCB_t.getText());
		        		int pretCB = Integer.parseInt(pretCB_t.getText());
		        	
		        		for(int i = 0; i < arr.size(); i++) {
		        			
		        			if( marcaCB.equals("") || modelCB.equals("") || anulFabricatieiCB_t.getText().equals("")
									|| distantaParcursaCB_t.equals("") || culoareCB.equals("")
									|| normaDePoluareCB.equals("") || combustibilCB.equals("")
									|| cutieDeVitezeCB.equals("") || caroserieCB.equals("")
									|| capacitateCilindricaCB_t.getText().equals("") || pretCB_t.getText().equals("") ) {
									
									JOptionPane.showMessageDialog(null, "Trebuie completate toate campurile!");
									break;
		        			}
		        			else if(arr.get(i).getMarca().equalsIgnoreCase(marcaCB) && arr.get(i).getModel().equalsIgnoreCase(modelCB) && arr.get(i).getKm() == distantaParcursaCB 
		        			&& arr.get(i).getCuloare().equalsIgnoreCase(culoareCB) && arr.get(i).getAnul_fabricatiei() == anulFabricatieiCB && arr.get(i).getNorme_de_poluare().equalsIgnoreCase(normaDePoluareCB)
		        			&& arr.get(i).getCombustibil().equalsIgnoreCase(combustibilCB) && arr.get(i).getCutie_de_viteze().equalsIgnoreCase(cutieDeVitezeCB)
		        			&& arr.get(i).getCaroserie().equalsIgnoreCase(caroserieCB) && arr.get(i).getCapacitate_cilindrica() == capacitateCilindricaCB && arr.get(i).getPret() == pretCB) {
		        				
		        				int ok = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa cumperi aceasta masina?");
								 
					             if (ok == JOptionPane.YES_OPTION) {
					            		 try {
						            		 Class.forName("com.mysql.cj.jdbc.Driver");
						            		 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
						            		 
						            		 PreparedStatement st = myConn.prepareStatement("DELETE FROM cars WHERE Marca = ? AND Model = ? AND Km = ? AND Culoare = ? AND Anul_fabricatiei = ? "
						            				 + "AND Norme_de_poluare = ? AND Combustibil = ? AND Cutie_de_viteze = ? AND Caroserie = ? AND Capacitate_cilindrica = ? AND Pret = ?");
										
						            		 st.setString(1, arr.get(i).getMarca());
						            		 st.setString(2, arr.get(i).getModel());
						            		 st.setInt(3, arr.get(i).getKm());
											 st.setString(4, arr.get(i).getCuloare());
											 st.setInt(5, arr.get(i).getAnul_fabricatiei());
										   	 st.setString(6, arr.get(i).getNorme_de_poluare());
											 st.setString(7, arr.get(i).getCombustibil());
											 st.setString(8, arr.get(i).getCutie_de_viteze());
											 st.setString(9, arr.get(i).getCaroserie());
											 st.setInt(10, arr.get(i).getCapacitate_cilindrica());
											 st.setInt(11, arr.get(i).getPret());
										
											 st.executeUpdate();
										
											 JOptionPane.showMessageDialog(null, "Va multumim pentru achizitia facuta!");
											 update();
											 break;
										
										
						            	 } catch (ClassNotFoundException e1) {
						            		 e1.printStackTrace();
						            	 } catch (SQLException e1) {
						            		 e1.printStackTrace();
						            	 }

					             }
					             else
					            	 break;

		        			}
		        	}
		        		
		        	}
		        });
		        
		        
		        JButton previousCB_b = new JButton("PREVIOUS");
		        previousCB_b.setForeground(Color.GREEN);
		        previousCB_b.setBackground(Color.BLACK);
		        previousCB_b.setFont(new Font("Tahoma", Font.BOLD, 17));
		        previousCB_b.setBounds(236, 255, 142, 21);
		        panel3.add(previousCB_b);
		        previousCB_b.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
		        		
						if(CBList.isEmpty())
							JOptionPane.showMessageDialog(null, "Nu exista nicio masina de acest tip!");
						else {
							
							if(poz == 0 || poz < 0)
								poz = CBList.size();
							poz -= 1;
				
							marcaCB_t.setText(CBList.get(poz).getMarca());
		        			modelCB_t.setText(CBList.get(poz).getModel());
		        			distantaParcursaCB_t.setText(String.valueOf(CBList.get(poz).getKm()));
		        			culoareCB_t.setText(CBList.get(poz).getCuloare());
		        			anulFabricatieiCB_t.setText(String.valueOf(CBList.get(poz).getAnul_fabricatiei()));
		        			normaDePoluareCB_t.setText(CBList.get(poz).getNorme_de_poluare());
		        			combustibilCB_t.setText(CBList.get(poz).getCombustibil());
		        			cutieDeVitezeCB_t.setText(CBList.get(poz).getCutie_de_viteze());
		        			caroserieCB_t.setText(CBList.get(poz).getCaroserie());
		        			capacitateCilindricaCB_t.setText(String.valueOf(CBList.get(poz).getCapacitate_cilindrica()));
		        			pretCB_t.setText(String.valueOf(CBList.get(poz).getPret()));
						}
						
					}
		        	
		        });
		        
		        panel4 = new JPanel();
		        panel4.setBackground(Color.BLACK);
		        layeredPane.add(panel4);
		        panel4.setLayout(null); //pozitionare absoluta - ajuta "componentele"
		        
		        
		        
		        JLabel marca_l = new JLabel("Marca:");
		        marca_l.setForeground(Color.GREEN);
		        marca_l.setBackground(Color.BLACK);
		        marca_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        marca_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        marca_l.setBounds(10, 10, 184, 22);
		        panel4.add(marca_l);
		        
		        JLabel model_l = new JLabel("Model:");
		        model_l.setForeground(Color.GREEN);
		        model_l.setBackground(Color.BLACK);
		        model_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        model_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        model_l.setBounds(10, 42, 184, 22);
		        panel4.add(model_l);
		        
		        JLabel distantaParcursa_l = new JLabel("Distanta parcursa:");
		        distantaParcursa_l.setBackground(Color.BLACK);
		        distantaParcursa_l.setForeground(Color.GREEN);
		        distantaParcursa_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        distantaParcursa_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        distantaParcursa_l.setBounds(10, 106, 184, 22);
		        panel4.add(distantaParcursa_l);
		        
		        JLabel culoare_l = new JLabel("Culoare:");
		        culoare_l.setBackground(Color.BLACK);
		        culoare_l.setForeground(Color.GREEN);
		        culoare_l.setHorizontalAlignment(SwingConstants.TRAILING);
		        culoare_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        culoare_l.setBounds(10, 138, 152, 22);
		        panel4.add(culoare_l);
		        
		        JLabel anulFabricatiei_l = new JLabel("Anul fabricatiei:");
		        anulFabricatiei_l.setForeground(Color.GREEN);
		        anulFabricatiei_l.setBackground(Color.BLACK);
		        anulFabricatiei_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        anulFabricatiei_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        anulFabricatiei_l.setBounds(0, 74, 194, 22);
		        panel4.add(anulFabricatiei_l);
		        
		        JLabel normaDePoluare_l = new JLabel("Norma de poluare:");
		        normaDePoluare_l.setForeground(Color.GREEN);
		        normaDePoluare_l.setBackground(Color.BLACK);
		        normaDePoluare_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        normaDePoluare_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        normaDePoluare_l.setBounds(10, 170, 184, 22);
		        panel4.add(normaDePoluare_l);
		        
		        JLabel combustibil_l = new JLabel("Combustibil:");
		        combustibil_l.setForeground(Color.GREEN);
		        combustibil_l.setBackground(Color.BLACK);
		        combustibil_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        combustibil_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        combustibil_l.setBounds(422, 42, 206, 22);
		        panel4.add(combustibil_l);
		        
		        JLabel cutieDeViteze_l = new JLabel("Cutie de viteze:");
		        cutieDeViteze_l.setForeground(Color.GREEN);
		        cutieDeViteze_l.setBackground(Color.BLACK);
		        cutieDeViteze_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        cutieDeViteze_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        cutieDeViteze_l.setBounds(422, 10, 206, 22);
		        panel4.add(cutieDeViteze_l);
		        
		        JLabel caroserie_l = new JLabel("Caroserie:");
		        caroserie_l.setForeground(Color.GREEN);
		        caroserie_l.setBackground(Color.BLACK);
		        caroserie_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        caroserie_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        caroserie_l.setBounds(422, 74, 206, 22);
		        panel4.add(caroserie_l);
		        
		        JLabel capacitateCilindrica_l = new JLabel("Capacitate cilindrica:");
		        capacitateCilindrica_l.setForeground(Color.GREEN);
		        capacitateCilindrica_l.setBackground(Color.BLACK);
		        capacitateCilindrica_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        capacitateCilindrica_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        capacitateCilindrica_l.setBounds(422, 106, 206, 22);
		        panel4.add(capacitateCilindrica_l);
		        
		        JLabel pret_l = new JLabel("Pret:");
		        pret_l.setForeground(Color.GREEN);
		        pret_l.setBackground(Color.BLACK);
		        pret_l.setFont(new Font("Tahoma", Font.BOLD, 17));
		        pret_l.setHorizontalAlignment(SwingConstants.RIGHT);
		        pret_l.setBounds(422, 138, 206, 22);
		        panel4.add(pret_l);
		        
		        marca_t = new JTextField();
		        marca_t.setBounds(204, 15, 96, 19);
		        panel4.add(marca_t);
		        marca_t.setColumns(10);
		        
		        model_t = new JTextField();
		        model_t.setBounds(204, 47, 96, 19);
		        panel4.add(model_t);
		        model_t.setColumns(10);
		        
		        anulFabricatiei_t = new JTextField();
		        anulFabricatiei_t.setBounds(204, 79, 96, 19);
		        panel4.add(anulFabricatiei_t);
		        anulFabricatiei_t.setColumns(10);
		        
		        distantaParcursa_t = new JTextField();
		        distantaParcursa_t.setBounds(204, 111, 96, 19);
		        panel4.add(distantaParcursa_t);
		        distantaParcursa_t.setColumns(10);
		        
		        culoare_t = new JTextField();
		        culoare_t.setBounds(204, 143, 96, 19);
		        panel4.add(culoare_t);
		        culoare_t.setColumns(10);
		        
		        normaDePoluare_t = new JTextField();
		        normaDePoluare_t.setBounds(204, 175, 96, 19);
		        panel4.add(normaDePoluare_t);
		        normaDePoluare_t.setColumns(10);
		        
		        cutieDeViteze_t = new JTextField();
		        cutieDeViteze_t.setBounds(638, 15, 96, 19);
		        panel4.add(cutieDeViteze_t);
		        cutieDeViteze_t.setColumns(10);
		        
		        combustibil_t = new JTextField();
		        combustibil_t.setBounds(638, 47, 96, 19);
		        panel4.add(combustibil_t);
		        combustibil_t.setColumns(10);
		        
		        caroserie_t = new JTextField();
		        caroserie_t.setBounds(638, 79, 96, 19);
		        panel4.add(caroserie_t);
		        caroserie_t.setColumns(10);
		        
		        capacitateCilindrica_t = new JTextField();
		        capacitateCilindrica_t.setBounds(638, 111, 96, 19);
		        panel4.add(capacitateCilindrica_t);
		        capacitateCilindrica_t.setColumns(10);
		        
		        pret_t = new JTextField();
		        pret_t.setBounds(638, 143, 96, 19);
		        panel4.add(pret_t);
		        pret_t.setColumns(10);
		        
		        JButton adauga_masina = new JButton("ADAUGA MASINA");
		        adauga_masina.setForeground(Color.GREEN);
		        adauga_masina.setBackground(Color.BLACK);
		        adauga_masina.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		        adauga_masina.setBounds(312, 210, 214, 33);
		        panel4.add(adauga_masina);
		        adauga_masina.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
							int ok = JOptionPane.showConfirmDialog(null, "Esti sigur?");
							
				             if (ok == JOptionPane.YES_OPTION) {
				            	
				            	 if( marca_t.getText().equals("") || model_t.getText().equals("") || anulFabricatiei_t.getText().equals("")
											|| distantaParcursa_t.getText().equals("") || culoare_t.getText().equals("")
											|| normaDePoluare_t.getText().equals("") || combustibil_t.getText().equals("")
											|| cutieDeViteze_t.getText().equals("") || caroserie_t.getText().equals("")
											|| capacitateCilindrica_t.getText().equals("") || pret_t.getText().equals("") ) {
				            		 
				            		 JOptionPane.showMessageDialog(null, "Trebuie completate toate campurile!");
				            		 
				            	 }
				            	 else if( Integer.parseInt(anulFabricatiei_t.getText()) < 0 || Integer.parseInt(capacitateCilindrica_t.getText()) < 0 || Integer.parseInt(pret_t.getText()) < 0 ) {
				            		 JOptionPane.showMessageDialog(null, "Nu pot exista valori negative!");
				            	 }
								  else {
									  Connection myConn;
										try {
											myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
											String query = "insert into cars(Marca, Model, Anul_fabricatiei, Km, Culoare, Norme_de_poluare, Combustibil, Cutie_de_viteze, Caroserie, Capacitate_cilindrica, Pret)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							         		PreparedStatement pst = myConn.prepareStatement(query);
							         		
							         		pst.setString(1,  marca_t.getText());
							         		pst.setString(2,  model_t.getText());
							         		pst.setInt(3, Integer.parseInt(anulFabricatiei_t.getText()));
							         		pst.setInt(4,  Integer.parseInt(distantaParcursa_t.getText()));
							         		pst.setString(5, culoare_t.getText());
							         		pst.setString(6,  normaDePoluare_t.getText());
							         		pst.setString(7, combustibil_t.getText());
							         		pst.setString(8, cutieDeViteze_t.getText());
							         		pst.setString(9, caroserie_t.getText());
							         		pst.setInt(10, Integer.parseInt(capacitateCilindrica_t.getText()));
							         		pst.setInt(11, Integer.parseInt(pret_t.getText()));
							         		
							         		pst.executeUpdate();
							         		JOptionPane.showMessageDialog(null, "Masina a fost adaugata cu succes!");
							         	
							         		update();
							         	
										} catch (SQLException e1) {
											e1.printStackTrace();
										}
								  }
				             }

						
			        	}
		        });
		        
		        JButton welcome = new JButton("WELCOME");
		        welcome.setBackground(Color.BLACK);
		        welcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		        welcome.setForeground(Color.GREEN);
		        welcome.setBounds(309, 210, 106, 32);
		        contentPane.add(welcome);
		        welcome.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						switchPanels(panel1);
						
					}
		        	
		        });
		        
		        
		        JButton buy = new JButton("CUMPARA");
		        buy.setForeground(Color.GREEN);
		        buy.setBackground(Color.BLACK);
		        buy.setFont(new Font("Tahoma", Font.BOLD, 12));
		        buy.setBounds(425, 210, 101, 32);
		        contentPane.add(buy);
		        buy.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						switchPanels(panel3);
						
					}
		        	
		        });
		        
		        JButton sell = new JButton("VINDE");
		        sell.setForeground(Color.GREEN);
		        sell.setBackground(Color.BLACK);
		        sell.setFont(new Font("Tahoma", Font.BOLD, 12));
		        sell.setBounds(536, 210, 85, 32);
		        contentPane.add(sell);
		        sell.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						switchPanels(panel4);
						
					}
		        	
		        });
		       
		        JLabel label = new JLabel();
		        ImageIcon img = new ImageIcon(this.getClass().getResource("/Background.jpg"));
		        label.setIcon(img);
		        label.setBounds(106, 15, 747, 149);
		        contentPane.add(label);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	   
	 }
	 
	 public void switchPanels(JPanel panel) {
		 layeredPane.removeAll();
		 layeredPane.add(panel);
		 layeredPane.repaint();
		 layeredPane.revalidate();
	 }
	 
	 public void addInArray(){
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/new_tabel", "root", "112322123");
				
				Statement myStmt = myConn.createStatement();
				
				ResultSet myRs = myStmt.executeQuery("select * from cars");
			
				while(myRs.next()) {
					String Marca = myRs.getString("Marca");
					String Model = myRs.getString("Model");
					int Anul_fabricatiei = myRs.getInt("Anul_fabricatiei");
					int Km = myRs.getInt("Km");
					String Culoare = myRs.getString("Culoare");
					String Norme_de_poluare = myRs.getString("Norme_de_poluare");
					String Combustibil = myRs.getString("Combustibil");
					String Cutie_de_viteze = myRs.getString("Cutie_de_viteze");
					String Caroserie = myRs.getString("Caroserie");
					int Capacitate_cilindrica = myRs.getInt("Capacitate_cilindrica");
					int pret = myRs.getInt("Pret");
					arr.add(new Car(Marca, Model, Anul_fabricatiei, Km, Culoare, Norme_de_poluare, Combustibil, Cutie_de_viteze, 
							Caroserie, Capacitate_cilindrica, pret));
					
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				}
	 }
	 
	 public void ComboBox1() {//comboBox pentru Marca  JComboBox<String> CB
		 addInArray();
		
		 Set<String> set_marca = new HashSet<>();
		 
		 for(int i = 0; i < arr.size(); i++)
			 set_marca.add(arr.get(i).getMarca());

		 
		 List<String> list_marca = new ArrayList<>(set_marca);
		 Collections.sort(list_marca);
		 
		 marca_comboBox.addItem("Marca");
		 for(String s: list_marca)
			 marca_comboBox.addItem(s);

		
	 }
	 
	 public void update() {
         UserPanel obj = new UserPanel();
         obj.setVisible(true);
         dispose();

	 }
	 
	 public void list_ComboBox() {//lista de masini de un anumit tip
		 	
 			for(int i = pozitie + 1; i < arr.size(); i++) {
 				if(arr.get(i).getMarca().equalsIgnoreCase(marca_comboBox.getSelectedItem().toString()) && arr.get(i).getModel().equalsIgnoreCase(model_comboBox.getSelectedItem().toString())) {
 					CBList.add(arr.get(i));
 					//ok1 = true;
 				}

 			}

 	

	 }

	 
	 
	 public List<Car> getList() {
		 list_ComboBox();
		 return CBList;
	 }
}
