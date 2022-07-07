import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class delete_account extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	int chq_bal=0;
    int inv_bal=0;

	/**
	 * Launch the application.
	 */
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
					delete_account frame = new delete_account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public delete_account() {
		
		setTitle("Delete Account");
		
        setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Savings A/c");
		lblNewLabel.setBounds(136, 80, 70, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(281, 80, 303, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(136, 103, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(281, 103, 303, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setBounds(136, 126, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(281, 126, 303, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Delete Account", SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(0, 44, 476, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Account Type");
		lblNewLabel_7.setBounds(136, 173, 122, 13);
		contentPane.add(lblNewLabel_7);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chequing A/c");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(281, 169, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Investment A/c");
		rdbtnNewRadioButton_1.setBounds(281, 192, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    
	    
	    
	    JButton btnNewButton = new JButton("Delete Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String new_account = "";
                String chequing_balance="0";
                String investment_balance="0";
                
                String account= lblNewLabel_1.getText();
                
                if (rdbtnNewRadioButton.isSelected()) {
                	
                	
                	  
                	try {
                	   
                	   chq_transfer();
                	   
                	   Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
      		           String sql = "UPDATE CUSTOMER SET balance = '"+ chq_bal +"',chequing_no='" + new_account + "',chequing_balance='"+ chequing_balance+"' WHERE Account_no='" + account + "'";
                       PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
      		      		        
      		           st.execute(sql);
      		            
      		           JOptionPane.showMessageDialog(btnNewButton, "Chequing account "+new_account+" deleted successfully !!!");
      		           dispose();
      		            
      		           } catch (SQLException sqlException) {
      		            sqlException.printStackTrace();
      		        } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
                	
                  }
                
                else if (rdbtnNewRadioButton_1.isSelected()) {
  
                	try {
                		
                		inv_transfer();
                		
                        Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
      		           
      		           String sql = "UPDATE CUSTOMER SET balance = '"+ inv_bal +"',investment_no='" + new_account +  "',investment_balance='"+ investment_balance +"' WHERE Account_no='" + account + "'";
                         PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
      		      		        
      		           st.execute(sql);
      		            
      		           JOptionPane.showMessageDialog(btnNewButton, "Investment account "+new_account+" deleted successfully !!!");
      		           dispose();
      		            
      		          } catch (SQLException sqlException) {
      		            sqlException.printStackTrace();
      		        } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
             }
		});
		btnNewButton.setBounds(136, 270, 103, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(270, 270, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("Balance");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setBounds(403, 149, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setEnabled(false);
		lblNewLabel_9.setBounds(403, 173, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setEnabled(false);
		lblNewLabel_10.setBounds(403, 196, 45, 13);
		contentPane.add(lblNewLabel_10);
		
	}
	
	
	public String getupAccount() {
		return this.lblNewLabel_3.getText();
		} 


	public void setupAccount(String acc, String name, String lname) {
		// TODO Auto-generated method stub
		 String sub = acc.substring(17);
		 this.lblNewLabel_1.setText(sub);
		 this.lblNewLabel_3.setText(name);
		 this.lblNewLabel_5.setText(lname);
		 getDetails();
	}
	
        public void getDetails() {
		
		String acc_no = lblNewLabel_1.getText();

        try {
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	
            Connection connection = (Connection) DriverManager.getConnection(  
            		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
            
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select chequing_balance, investment_balance from CUSTOMER where Account_no=?");

            st.setString(1, acc_no);
           
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String chq_bal = rs.getString("chequing_balance");
                String env_bal = rs.getString("investment_balance");
                lblNewLabel_9.setText("$ "+chq_bal);
                lblNewLabel_10.setText("$ "+env_bal);
            } 
            else {
                JOptionPane.showMessageDialog(btnNewButton_1, "Invalid Account Number !!!");
                System.out.println("Invalid credentials!!!.....Login unsuccessfull");
            }
            } catch (SQLException sqlException) {
            sqlException.printStackTrace();
           } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
	   }
        
       public void chq_transfer() {
           
           String account= lblNewLabel_1.getText();
           
           try {
        	   
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
           	
               Connection connection = (Connection) DriverManager.getConnection(  
               		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
               
               PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select balance, chequing_balance, investment_balance from CUSTOMER where Account_no=?");

               st.setString(1, account);
              
               ResultSet rs = st.executeQuery();                    
               
               if (rs.next()) 
               {
               	   String chq_amt = rs.getString("chequing_balance");
                   chq_bal =  Integer.parseInt(rs.getString("balance")) + Integer.parseInt(rs.getString("chequing_balance"));
                   JOptionPane.showMessageDialog(btnNewButton_1, "Balance chequing amount $ "+chq_amt+" transferred to savings amount !!!");
               } 
               else {
                   JOptionPane.showMessageDialog(btnNewButton_1, " Balance not transferred  !!!");
                   System.out.println("Invalid credentials!!!.....Login unsuccessfull");
               }
              } catch (SQLException sqlException) {
               sqlException.printStackTrace();
           } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
       
           public void inv_transfer() {
           
           String account= lblNewLabel_1.getText();
           
           try {
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
           	
               Connection connection = (Connection) DriverManager.getConnection(  
               		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
               
               PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select balance, chequing_balance, investment_balance from CUSTOMER where Account_no=?");

               st.setString(1, account);
              
               ResultSet rs = st.executeQuery();                    
               
               if (rs.next()) 
               {
               	   String inv_amt = rs.getString("investment_balance");
                   inv_bal =  Integer.parseInt(rs.getString("balance")) + Integer.parseInt(rs.getString("investment_balance"));
                   JOptionPane.showMessageDialog(btnNewButton_1, "Balance Investment amount $ "+inv_amt+" transferred to savings amount !!!");
               } 
               else {
                   JOptionPane.showMessageDialog(btnNewButton_1, " Balance not transferred  !!!");
                   System.out.println("Invalid credentials!!!.....Login unsuccessfull");
               }
              } catch (SQLException sqlException) {
               sqlException.printStackTrace();
           } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
	
}

