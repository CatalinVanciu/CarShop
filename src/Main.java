import java.awt.EventQueue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Main {
	
	public static void main(String[] args) {
	
		try {
			EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Welcome frame = new Welcome();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	
		
}
