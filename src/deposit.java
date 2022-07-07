import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JTextField;

public class deposit extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton_1;

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
					deposit frame = new deposit();
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
	public deposit() {
		setTitle("Deposit Money");
		
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
		lblNewLabel_5.setBounds(281, 126, 103, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Deposit Menu", SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(0, 44, 476, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Account Type");
		lblNewLabel_7.setBounds(136, 149, 122, 13);
		contentPane.add(lblNewLabel_7);
		
		rdbtnNewRadioButton = new JRadioButton("Chequing A/c");
		rdbtnNewRadioButton.setBounds(274, 169, 90, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Investment A/c");
		rdbtnNewRadioButton_1.setBounds(274, 192, 96, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Savings A/c");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setBounds(274, 145, 79, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    group.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                
                String account= lblNewLabel_1.getText();
            
                String sav="";
              
                String sav_acc="";
                
                int bal= 0;
                		
                
                if (rdbtnNewRadioButton.isSelected())  {
              	  
              	try {
     		           
              		Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection1 = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
      		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
      		       
      		         st1.setString(1, account);
      		           
                    ResultSet rs = st1.executeQuery();
                    
                    if (rs.next()) {
                  	  sav_acc = rs.getString("chequing_no");
                  	  sav = rs.getString("chequing_balance");
                      bal = Integer.parseInt(sav);  
		                } 
                    
                   if(sav_acc == null || sav_acc.equals("")) {
                  	  
                  	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any chequing A/c.  Open chequing account first !!!");
                    }
                    
               
                   else {
                     
              		   int cash = Integer.parseInt(textField.getText());
                  	   bal += cash;
                  	   
                  	    Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                    Connection connection = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
    		          String sql = "UPDATE CUSTOMER SET chequing_balance ='" + bal + "' WHERE Account_no='" + account + "'";
                     PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                     
		                 st.execute(sql);
		            
		                 JOptionPane.showMessageDialog(btnNewButton, "Amount deposited successfully. Total Amount : $ "+bal);
		                 getDetails();
		                 textField.setText("");
              	   }
                }
   		            
   		        catch (SQLException sqlException) {
   		            sqlException.printStackTrace();
   		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              }
                
                else if (rdbtnNewRadioButton_1.isSelected())  {
              	  
              	try {
     		           
              		Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection1 = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
      		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
      		       
      		         st1.setString(1, account);
      		           
                    ResultSet rs = st1.executeQuery();
                    
                    if (rs.next()) {
                  	    sav_acc = rs.getString("investment_no");
                  	    sav = rs.getString("investment_balance");
                        bal = Integer.parseInt(sav);  
		                } 
                    
                   if(sav_acc == null || sav_acc.equals("")) {
                  	  
                  	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any investment A/c.  Open investment account first !!!");
                    }
                    
               
                 else {
                     
              		   int cash = Integer.parseInt(textField.getText());
                  	   bal += cash;
                  	   
                  	   Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                   Connection connection = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
    		           String sql = "UPDATE CUSTOMER SET investment_balance ='" + bal + "' WHERE Account_no='" + account + "'";
                       PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                     
		                 st.execute(sql);
		                 JOptionPane.showMessageDialog(btnNewButton, "Amount deposited successfully. Total Amount : $"+bal);
		                 getDetails();
		                 textField.setText("");
              	      }
                    }
   		            
   		        catch (SQLException sqlException) {
   		            sqlException.printStackTrace();
   		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              }
                
                else if (rdbtnNewRadioButton_2.isSelected()) {
                	  
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
                          bal = Integer.parseInt(sav);  
  		                } 
                      
                     if(sav_acc == null || sav_acc.equals("")) {
                    	  
                    	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                      }
                      
                 
                   else {
                       
                		   int cash = Integer.parseInt(textField.getText());
                    	   bal += cash;
                    	   
                    	   Class.forName("oracle.jdbc.driver.OracleDriver");
   	                	
   	                    Connection connection = (Connection) DriverManager.getConnection(  
   	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
   	                    
      		          String sql = "UPDATE CUSTOMER SET balance ='" + bal + "' WHERE Account_no='" + account + "'";
                       PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                       
		                 st.execute(sql);
		            
		                 JOptionPane.showMessageDialog(btnNewButton, "Amount deposited successfully. Total Amount : $"+bal);
		                 getDetails();
		                 textField.setText("");
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
		btnNewButton.setBounds(136, 270, 103, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(268, 270, 103, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("Amount to be deposited");
		lblNewLabel_8.setBounds(138, 228, 120, 13);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(275, 225, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Balance");
		lblNewLabel_9.setEnabled(false);
		lblNewLabel_9.setBounds(380, 126, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setEnabled(false);
		lblNewLabel_10.setBounds(380, 149, 106, 13);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setEnabled(false);
		lblNewLabel_11.setBounds(380, 173, 106, 13);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setEnabled(false);
		lblNewLabel_12.setBounds(380, 196, 106, 13);
		contentPane.add(lblNewLabel_12);

		
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
            
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select balance, chequing_balance, investment_balance from CUSTOMER where Account_no=?");

            st.setString(1, acc_no);
           
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
            	String bal = rs.getString("balance");
                String chq_bal = rs.getString("chequing_balance");
                String env_bal = rs.getString("investment_balance");
                lblNewLabel_10.setText("$ "+bal);
                lblNewLabel_11.setText("$ "+chq_bal);
                lblNewLabel_12.setText("$ "+env_bal);
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

