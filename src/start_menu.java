import java.awt.BorderLayout;

import oracle.jdbc.driver.OracleDriver;
import java.awt.Toolkit;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class start_menu extends JFrame {

	   private JPanel contentPane;
	   private JPasswordField passwordField;
	   
	   

	   public static void main(String[] args) {
		
		 try {
	        // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	        } 
	    catch (UnsupportedLookAndFeelException e) { }
	    catch (ClassNotFoundException e) { }
	    catch (InstantiationException e) { }
	    catch (IllegalAccessException e) { }
		 
		
		 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start_menu frame1 = new start_menu();
					frame1.setVisible(true);
					frame1.setTitle("CSAM Banking Group");
				  } catch (Exception e) {
					e.printStackTrace();
				 }
			   }
		    });
         }
	  

	    public start_menu() {
	    	
	    	
	    	
	    setResizable(false);
	    setTitle("CSAM Banking Group");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("CSAM BANKING GROUP", SwingConstants.CENTER);
		label1.setBounds(165, 28, 159, 19);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label1);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String acc_no = passwordField.getText();

	                try {
	                	

	                	Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select Account_no, firstname from CUSTOMER where Account_no=?");

	                    st.setString(1, acc_no);
	                   
	                    ResultSet rs = st.executeQuery();
	                    
	                    if (rs.next()) {
	                        
	                        String name = rs.getString("firstname");
	                        System.out.println("Login Successfull");
	                        System.out.println("Account Number : "+acc_no);
	                        System.out.println("Firstname : "+name);
	                        JOptionPane.showMessageDialog(btnNewButton, "Login successfull !!!");
	                        
	                    	String acc = passwordField.getText().toString();
	        				homepage homepage = new homepage();
	        				homepage.setAccount(acc);
	        				homepage.setName(name);
	        				
	        				homepage.setVisible(true);
	        				dispose();
		
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
	                        System.out.println("Invalid credentials!!!.....Login unsuccessfull");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(165, 156, 159, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new signup().setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(165, 219, 159, 30);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 127, 159, 19);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your Account Number");
		lblNewLabel.setBounds(177, 104, 132, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Not registered yet?", SwingConstants.CENTER);
		lblNewLabel_1.setBounds(165, 196, 159, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bhupinder | Babalpreet | Garima | Gagandeep | Gurpreet | Ishmanpreet", SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 320, 496, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Developed By", SwingConstants.CENTER);
		lblNewLabel_3.setBounds(165, 297, 159, 13);
		contentPane.add(lblNewLabel_3);
	}    
}
