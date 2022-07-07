import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class open_account extends JFrame {

	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
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
					open_account frame = new open_account();
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
	public open_account() {
		setTitle("Open Account");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Savings A/c");
		lblNewLabel.setBounds(111, 83, 54, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(244, 83, 148, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(111, 106, 50, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(244, 106, 148, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setBounds(111, 129, 48, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(244, 129, 148, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Open new account", SwingConstants.CENTER);
		lblNewLabel_6.setBounds(198, 39, 109, 15);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Account Type");
		lblNewLabel_7.setBounds(111, 164, 62, 13);
		contentPane.add(lblNewLabel_7);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chequing A/c");
		rdbtnNewRadioButton.setBounds(238, 160, 87, 21);
		rdbtnNewRadioButton.setSelected(true);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Investment A/c");
		rdbtnNewRadioButton_1.setBounds(238, 188, 95, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Open Account");
		btnNewButton.setBounds(111, 243, 95, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
                int rand_int = rand.nextInt(999999999);
                String new_account = Integer.toString(rand_int);
                
                String account= lblNewLabel_1.getText();
                String chq="";
                String inv="";
                
                if (rdbtnNewRadioButton.isSelected()) {
                	  
                	try {
      		           
                        Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection1 = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
         		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
         		         System.out.println("inside 4 "+account);
         		         st1.setString(1, account);
         		           
                       ResultSet rs = st1.executeQuery();
                       
                       if (rs.next()) {
   		            	
   		                chq = rs.getString("chequing_no");
 
   		                } 
                       
                       if(chq == null || chq.equals("")) {
                           
                    	   Class.forName("oracle.jdbc.driver.OracleDriver");
   	                	
   	                    Connection connection = (Connection) DriverManager.getConnection(  
   	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
   	                    
          		           String sql = "UPDATE CUSTOMER SET chequing_no='" + new_account + "' WHERE Account_no='" + account + "'";
                           PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                           
		                  st.execute(sql);
		            
		                 JOptionPane.showMessageDialog(btnNewButton, "Chequing account "+new_account+" created successfully !!!");
		                 dispose();
                       }
      		      	   
                       else {
      		              JOptionPane.showMessageDialog(btnNewButton, "Chequing account "+chq+" already created !!!");
    		              
                       }
      		            
      		        } catch (SQLException sqlException) {
      		            sqlException.printStackTrace();
      		        } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                  }
                
                else if (rdbtnNewRadioButton_1.isSelected()) {
  
                	try {
       		           
                        Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection1 = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
        		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
        		       
        		         st1.setString(1, account);
        		           
                      ResultSet rs = st1.executeQuery();
                      
                      if (rs.next()) {
  		            	
  		                inv = rs.getString("investment_no");

  		                } 
                      
                      if(inv == null || inv.equals("")) {
                          
                    	  Class.forName("oracle.jdbc.driver.OracleDriver");
  	                	
  	                      Connection connection = (Connection) DriverManager.getConnection(  
  	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
  	                    
         		          String sql = "UPDATE CUSTOMER SET investment_no ='" + new_account + "' WHERE Account_no='" + account + "'";
                          PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                          
		                 st.execute(sql);
		            
		                 JOptionPane.showMessageDialog(btnNewButton, "Investment account "+new_account+" created successfully !!!");
		                 dispose();
                      }
     		  
                   else {
     		       JOptionPane.showMessageDialog(btnNewButton, "Investment account "+inv+" already created !!!");
   		         
                      }
     		            
     		        } catch (SQLException sqlException) {
     		            sqlException.printStackTrace();
     		        } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
             }
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(244, 243, 95, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
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
		 
	}
}
