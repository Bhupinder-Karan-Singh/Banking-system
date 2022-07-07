import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class transfers extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JLabel lblNewLabel_7;
	private JTextField textField;
	private JLabel lblNewLabel_8;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblNewLabel_9;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_10;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfers frame = new transfers();
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
	public transfers() {
		setTitle("Transfer Money");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Transfer ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(204, 29, 72, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Savings A/c");
		lblNewLabel_1.setBounds(118, 74, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(118, 98, 79, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(118, 121, 79, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(290, 74, 186, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(290, 98, 186, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(290, 121, 186, 13);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Transfer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String account= lblNewLabel_4.getText();
				 int acc_1 = Integer.parseInt(account);
				 String account2 = textField.getText();
				 int acc_2 = Integer.parseInt(account2);
				 
	               
	                String sav="";
	                String sav_acc="";
	                int sav_bal= 0;
	                
	                String chq="";
	                String chq_acc="";
	                int chq_bal= 0;
	               
	           
				
				 if(rdbtnNewRadioButton.isSelected()) {    //savings
                	 
                	 try {
         		           
                		 Class.forName("oracle.jdbc.driver.OracleDriver");
 	                	
 	                    Connection connection1 = (Connection) DriverManager.getConnection(  
 	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
 	                    
            		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
            		       
            		         st1.setString(1, account);
            		     
                             ResultSet rs = st1.executeQuery();
                          
                             if (rs.next()) {
                        	  sav_acc = rs.getString("Account_no");
                        	  sav = rs.getString("balance");
                              sav_bal = Integer.parseInt(sav); 
                            
      		                } 
                          
                         if (sav_acc == null || sav_acc.equals("")) {
                        	  
                        	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                          }
                         
                         
                     
                       else   {
                    	
                    		   int cash = Integer.parseInt(textField_1.getText());
                    		   
                    		   if (sav_bal <= 0 || sav_bal < cash) {
                              	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                }
                    		   
                    		   else if(acc_1 == acc_2) {
                            	   JOptionPane.showMessageDialog(btnNewButton, " Transaction in same account not allowed !!!");
                            	   lblNewLabel_10.setText("");
                            	   textField.setText("");
                            	   textField_1.setText("");
                               }
                    		   
                    		   else {
                    			 
                    			   Class.forName("oracle.jdbc.driver.OracleDriver");
           	                	
           	                    Connection connection2 = (Connection) DriverManager.getConnection(  
           	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
           	                    
                          		         PreparedStatement st2 = (PreparedStatement) connection2.prepareStatement("Select * from CUSTOMER where Account_no=?");
                          		       
                          		         st2.setString(1, account2);
                          		      
                                           ResultSet rs2 = st2.executeQuery();
                                        
                                           if (rs2.next()) {
                                      	    chq_acc = rs2.getString("Account_no");
                                      	    chq = rs2.getString("balance");
                                            chq_bal = Integer.parseInt(chq); 
                    		                } 
                                           
                                           if(chq_acc == null || chq_acc.equals("")) {
                                         	  
                                        	   JOptionPane.showMessageDialog(btnNewButton, " Other's Account number does not exists !!!");
                                        	   lblNewLabel_10.setText("");
                                          }
                                          
                                           else {
                    			   
                        	   sav_bal -= cash;
                        	   chq_bal += cash;

                        	   Class.forName("oracle.jdbc.driver.OracleDriver");
       	                	
       	                    Connection connection3 = (Connection) DriverManager.getConnection(  
       	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
       	                    
          		             String sql3 = "UPDATE CUSTOMER SET balance ='" + sav_bal + "' WHERE Account_no='" + account + "'";
                             PreparedStatement st = (PreparedStatement) connection3.prepareStatement(sql3);
                           
    		                 st.execute(sql3);
    		               
    		                 Class.forName("oracle.jdbc.driver.OracleDriver");
        	                	
        	                    Connection connection4 = (Connection) DriverManager.getConnection(  
        	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
        	                    
    		          		             String sql4 = "UPDATE CUSTOMER SET balance ='" + chq_bal + "' WHERE Account_no='" + account2 + "'";
    		                             PreparedStatement st4 = (PreparedStatement) connection4.prepareStatement(sql4);
    		                             
    		    		                 st4.execute(sql4);
    		    		                 
    		    		                 sav_bal = 0;
    		    		                 chq_bal = 0;
    		    		                  
    		    		              
    		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully !!!");
    		                 getDetails();
    		                 textField_1.setText("");
                                           }
                    		   }
                    	   }
                       }
         		            
         		        catch (SQLException sqlException) {
         		            sqlException.printStackTrace();
         		        } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	 
                 }
				    
				
			}
		});
		btnNewButton.setBounds(118, 282, 96, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("Transfer to Account");
		lblNewLabel_7.setBounds(118, 194, 145, 13);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		textField.setBounds(290, 191, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Account type");
		lblNewLabel_8.setBounds(118, 156, 132, 13);
		contentPane.add(lblNewLabel_8);
		
		rdbtnNewRadioButton = new JRadioButton("Savings A/c");
		rdbtnNewRadioButton.setBounds(283, 152, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		lblNewLabel_9 = new JLabel("Enter amount ");
		lblNewLabel_9.setBounds(118, 239, 145, 13);
		contentPane.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(290, 236, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(290, 282, 96, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setEnabled(false);
		lblNewLabel_10.setVisible(false);
		lblNewLabel_10.setBounds(290, 213, 186, 13);
		contentPane.add(lblNewLabel_10);
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    
	    lblNewLabel_11 = new JLabel("Balance");
	    lblNewLabel_11.setEnabled(false);
	    lblNewLabel_11.setBounds(392, 133, 45, 13);
	    contentPane.add(lblNewLabel_11);
	    
	    lblNewLabel_12 = new JLabel("New label");
	    lblNewLabel_12.setEnabled(false);
	    lblNewLabel_12.setBounds(392, 156, 45, 13);
	    contentPane.add(lblNewLabel_12);
	    
	    JButton btnNewButton_4 = new JButton("Fetch A/c");
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String acc_no = textField.getText();
				String chq_name="";
	            String chq_lname="";

		        try {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");

		            st.setString(1, acc_no);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		         
		            	chq_name = rs.getString("firstname");
	               	    chq_lname = rs.getString("lastname");
		              
		                lblNewLabel_10.setVisible(true);
		                lblNewLabel_10.setText(chq_name+" "+chq_lname);
		               
		            } 
		            else {
		                JOptionPane.showMessageDialog(btnNewButton_1, " Account Number does not exists !!!");
		                System.out.println("Invalid credentials!!!.....Login unsuccessfull");
		                lblNewLabel_10.setText("");
		            }
		            } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		           } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		
	    	}
	    });
	    btnNewButton_4.setBounds(391, 190, 85, 21);
	    contentPane.add(btnNewButton_4);
	    
	 
	    

	}
	
	public String getupAccount() {
		return this.lblNewLabel_3.getText();
		} 


	public void setupAccount(String acc, String name, String lname) {
		// TODO Auto-generated method stub
		 String sub = acc.substring(17);
		 this.lblNewLabel_4.setText(sub);
		 this.lblNewLabel_5.setText(name);
		 this.lblNewLabel_6.setText(lname);
		 getDetails();
	}
	
	 public void getDetails() {
			
			String acc_no = lblNewLabel_4.getText();

	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
            	
                Connection connection = (Connection) DriverManager.getConnection(  
                		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                
	            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select balance, chequing_balance, investment_balance from CUSTOMER where Account_no=?");

	            st.setString(1, acc_no);
	           
	            ResultSet rs = st.executeQuery();
	            
	            if (rs.next()) {
	            	String bal = rs.getString("balance");
	                lblNewLabel_12.setText("$ "+bal);
	              
	               
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
}
