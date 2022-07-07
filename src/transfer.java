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
import javax.swing.JTextField;

public class transfer extends JFrame {

	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblNewLabel_8;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnInvestmentAc;
	private JTextField textField;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
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
	    catch (UnsupportedLookAndFeelException e) { }
	    catch (ClassNotFoundException e) { }
	    catch (InstantiationException e) { }
	    catch (IllegalAccessException e) { }
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfer frame = new transfer();
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
	public transfer() {
		setTitle("Transfer Money");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Savings A/c");
		lblNewLabel.setBounds(136, 43, 70, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(281, 43, 303, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(136, 66, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(281, 66, 303, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setBounds(136, 89, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(281, 89, 303, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Transfer", SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(0, 10, 476, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Transfer from ");
		lblNewLabel_7.setBounds(136, 123, 122, 13);
		contentPane.add(lblNewLabel_7);
		
		rdbtnNewRadioButton = new JRadioButton("Chequing A/c");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_3.setEnabled(true); 
            	rdbtnInvestmentAc.setEnabled(true);
            	rdbtnNewRadioButton_4.setEnabled(false); 
			}
		});
		rdbtnNewRadioButton.setBounds(273, 142, 87, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Investment A/c");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_3.setEnabled(true); 
				rdbtnNewRadioButton_4.setEnabled(true);
				rdbtnInvestmentAc.setEnabled(false);
			}
		});
		rdbtnNewRadioButton_1.setBounds(273, 165, 96, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Savings A/c");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                	rdbtnNewRadioButton_4.setEnabled(true); 
                	rdbtnInvestmentAc.setEnabled(true);
                	rdbtnNewRadioButton_3.setEnabled(false);
			}
		});
		rdbtnNewRadioButton_2.setBounds(273, 119, 79, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Savings A/c");
		rdbtnNewRadioButton_3.setEnabled(false);
		rdbtnNewRadioButton_3.setBounds(273, 195, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Chequing A/c");
		rdbtnNewRadioButton_4.setEnabled(false);
		rdbtnNewRadioButton_4.setBounds(273, 218, 103, 21);
		contentPane.add(rdbtnNewRadioButton_4);
		
		rdbtnInvestmentAc = new JRadioButton("Investment A/c");
		rdbtnInvestmentAc.setEnabled(false);
		rdbtnInvestmentAc.setBounds(273, 241, 103, 21);
		contentPane.add(rdbtnInvestmentAc);
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    group.add(rdbtnNewRadioButton_2);
	    
	    ButtonGroup group2 = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group2.add(rdbtnNewRadioButton_3);
	    group2.add(rdbtnNewRadioButton_4);
	    group2.add(rdbtnInvestmentAc);
		
		JButton btnNewButton = new JButton("Transfer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                
                String account= lblNewLabel_1.getText();
               
                String sav="";
                String sav_acc="";
                int sav_bal= 0;
                
                String chq="";
                String chq_acc="";
                int chq_bal= 0;
                
                String inv="";
                String inv_acc="";
                int inv_bal= 0;
                
                
                if (rdbtnNewRadioButton_2.isSelected()) {    //saving
              	  
                     if(rdbtnNewRadioButton_4.isSelected()) {    //chq
                    	 
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
                                 
                                  
                                  chq_acc = rs.getString("chequing_no");
                            	  chq = rs.getString("chequing_balance");
                                  chq_bal = Integer.parseInt(chq); 

          		                } 
                              
                             if(sav_acc == null || sav_acc.equals("")) {
                            	  
                            	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                              }
                             
                             if(chq_acc == null || chq_acc.equals("")) {
                           	  
                          	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Chequing A/c.  Open chequing account first !!!");
                            }
                              
                         
                           else {
                        	   
                        		   int cash = Integer.parseInt(textField.getText());
                        		   
                        		   if (sav_bal <= 0 || sav_bal < cash) {
                                  	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                    }
                        		   
                        		   else {
                        		   
                            	   sav_bal -= cash;
                            	   chq_bal += cash;

                            	   Class.forName("oracle.jdbc.driver.OracleDriver");
           	                	
           	                    Connection connection = (Connection) DriverManager.getConnection(  
           	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
           	                    
              		          String sql = "UPDATE CUSTOMER SET balance ='" + sav_bal + "',chequing_balance='" + chq_bal + "' WHERE Account_no='" + account + "'";
                               PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                               
        		                 st.execute(sql);
        		                 
        		                 sav_bal = 0;
        		                 chq_bal = 0;
        		                 textField.setText("");
        		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
        		                 getDetails();
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
                     else if(rdbtnInvestmentAc.isSelected()) {    //investment
                    	 
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
                                  
                                  inv_acc = rs.getString("investment_no");
                            	  inv = rs.getString("investment_balance");
                                  inv_bal = Integer.parseInt(inv); 

          		                } 
                              
                             if(sav_acc == null || sav_acc.equals("")) {
                            	  
                            	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                              }
                             
                             if(inv_acc == null || inv_acc.equals("")) {
                           	  
                          	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Investment A/c.  Open Investment account first !!!");
                            }
                              
                         
                           else {
                        		   int cash = Integer.parseInt(textField.getText());
                        		   
                        		   if (sav_bal <= 0 || sav_bal < cash) {
                                   	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                     }
                         		   
                         		   else {
                            	   sav_bal -= cash;
                            	   inv_bal += cash;
                            	   
                            	   Class.forName("oracle.jdbc.driver.OracleDriver");
           	                	
           	                    Connection connection = (Connection) DriverManager.getConnection(  
           	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
           	                    
              		          String sql = "UPDATE CUSTOMER SET balance ='" + sav_bal + "',investment_balance='" + inv_bal + "' WHERE Account_no='" + account + "'";
                               
              		          PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                               
        		                 st.execute(sql);
        		                 
        		                 sav_bal = 0;
        		                 inv_bal = 0;
        		                 textField.setText("");
        		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
        		                 getDetails();
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
                
           ///////////////////////////////////////////////////////////////////////////     
                
                else if (rdbtnNewRadioButton.isSelected()) {  // chequing
                	  
                         if(rdbtnNewRadioButton_3.isSelected()) {  // saving
                    	 
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
                                  
                                  chq_acc = rs.getString("chequing_no");
                            	  chq = rs.getString("chequing_balance");
                                  chq_bal = Integer.parseInt(chq); 

          		                } 
                              
                             if(sav_acc == null || sav_acc.equals("")) {
                            	  
                            	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                              }
                             
                             if(chq_acc == null || chq_acc.equals("")) {
                           	  
                          	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Chequing A/c.  Open chequing account first !!!");
                            }
                              
                         
                           else {
                        		   int cash = Integer.parseInt(textField.getText());
                        		   
                        		   if (chq_bal <= 0 || chq_bal < cash) {
                                   	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                     }
                         		   
                         		   else {
                            	   sav_bal += cash;
                            	   chq_bal -= cash;
                            	   
                            	   Class.forName("oracle.jdbc.driver.OracleDriver");
           	                	
           	                    Connection connection = (Connection) DriverManager.getConnection(  
           	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
           	                    
              		          String sql = "UPDATE CUSTOMER SET balance ='" + sav_bal + "',chequing_balance='" + chq_bal + "' WHERE Account_no='" + account + "'";
                               PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                               
        		                 st.execute(sql);
        		                 
        		                 sav_bal = 0;
        		                 chq_bal = 0;
        		                 textField.setText("");
        		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
        		                 getDetails();
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
                         
                     else if(rdbtnInvestmentAc.isSelected()) {     // investment
                    	 
                    	 try {
                    		 Class.forName("oracle.jdbc.driver.OracleDriver");
     	                	
     	                    Connection connection1 = (Connection) DriverManager.getConnection(  
     	                     		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
     	                    
                		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
                		       
                		         st1.setString(1, account);
                		           
                              ResultSet rs = st1.executeQuery();
                              
                              if (rs.next()) {
                            	  chq_acc = rs.getString("chequing_no");
                            	  chq = rs.getString("chequing_balance");
                                  chq_bal = Integer.parseInt(chq); 
                                  
                                  inv_acc = rs.getString("investment_no");
                            	  inv = rs.getString("investment_balance");
                                  inv_bal = Integer.parseInt(inv); 

          		                } 
                              
                              if(chq_acc == null || chq_acc.equals("")) {
                               	  
                             	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Chequing A/c.  Open chequing account first !!!");
                               }
                             
                             if(inv_acc == null || inv_acc.equals("")) {
                           	  
                          	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any investment A/c.  Open investment account first !!!");
                            }
                              
                         
                           else {
                        		   int cash = Integer.parseInt(textField.getText());
                        		   
                        		   if (chq_bal <= 0 || chq_bal < cash) {
                                    	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                      }
                          		   
                          		   else {
                            	   chq_bal -= cash;
                            	   inv_bal += cash;
                            	   
                                 Class.forName("oracle.jdbc.driver.OracleDriver");
           	                	
           	                     Connection connection = (Connection) DriverManager.getConnection(  
           	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
           	                    
              		             String sql = "UPDATE CUSTOMER SET chequing_balance ='" + chq_bal + "',investment_balance='" + inv_bal + "' WHERE Account_no='" + account + "'";
                                 PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                               
        		                 st.execute(sql);
        		                 
        		                 chq_bal = 0;
        		                 inv_bal = 0;
        		                 textField.setText("");
        		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
        		                 getDetails();
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
                
                ///////////////////////////////////
                
                else if (rdbtnNewRadioButton_1.isSelected()) {   // investment      
                    
                	if(rdbtnNewRadioButton_3.isSelected()) {  // saving
                   	 
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
                                 
                              inv_acc = rs.getString("investment_no");
                        	  inv = rs.getString("investment_balance");
                              inv_bal = Integer.parseInt(inv); 

         		                } 
                             
                             if(inv_acc == null || inv_acc.equals("")) {
                              	  
                            	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Investment A/c.  Open Invstment account first !!!");
                              }
                            
                            if(sav_acc == null || sav_acc.equals("")) {
                          	  
                         	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any saving A/c.  Open saving account first !!!");
                           }
                             
                        
                          else {
                       		   int cash = Integer.parseInt(textField.getText());
                       		   
                       		 if (inv_bal <= 0 || inv_bal < cash) {
                              	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                                }
                    		   
                    		   else {
                           	   sav_bal += cash;
                           	   inv_bal -= cash;
                           	   
                           	Class.forName("oracle.jdbc.driver.OracleDriver");
    	                	
    	                    Connection connection = (Connection) DriverManager.getConnection(  
    	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
    	                    
             		          String sql = "UPDATE CUSTOMER SET balance ='" + sav_bal + "',investment_balance='" + inv_bal + "' WHERE Account_no='" + account + "'";
                              PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                              
       		                 st.execute(sql);
       		                 
       		                 sav_bal = 0;
       		                 inv_bal = 0;
       		                 textField.setText("");
       		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
       		              getDetails();
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
                        
                    else if(rdbtnNewRadioButton_4.isSelected()) {   // chq
                   	 
                   	 try {
                             Class.forName("oracle.jdbc.driver.OracleDriver");
	                	
	                         Connection connection1 = (Connection) DriverManager.getConnection(  
	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
	                    
               		         PreparedStatement st1 = (PreparedStatement) connection1.prepareStatement("Select * from CUSTOMER where Account_no=?");
               		       
               		         st1.setString(1, account);
               		           
                             ResultSet rs = st1.executeQuery();
                             
                             if (rs.next()) {
                           	  chq_acc = rs.getString("chequing_no");
                           	  chq = rs.getString("chequing_balance");
                              chq_bal = Integer.parseInt(chq); 
                                 
                              inv_acc = rs.getString("investment_no");
                           	  inv = rs.getString("investment_balance");
                              inv_bal = Integer.parseInt(inv); 

         		                } 
                             
                             if(chq_acc == null || chq_acc.equals("")) {
                              	  
                            	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any Chequing A/c.  Open chequing account first !!!");
                              }
                            
                            if(inv_acc == null || inv_acc.equals("")) {
                          	  
                         	   JOptionPane.showMessageDialog(btnNewButton, "Can't find any investment A/c.  Open investment account first !!!");
                           }
                             
                        
                          else {
                        	  
                       		   int cash = Integer.parseInt(textField.getText());
                       		   
                       		 if (inv_bal <= 0 || inv_bal < cash) {
                             	  JOptionPane.showMessageDialog(btnNewButton, "Insufficient funds to transfer !!!");
                               }
                   		   
                   		   else {
                           	   chq_bal += cash;
                           	   inv_bal -= cash;
                           	   
                           	Class.forName("oracle.jdbc.driver.OracleDriver");
    	                	
    	                    Connection connection = (Connection) DriverManager.getConnection(  
    	                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
    	                    
             		          String sql = "UPDATE CUSTOMER SET chequing_balance ='" + chq_bal + "',investment_balance='" + inv_bal + "' WHERE Account_no='" + account + "'";
                              PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                              
       		                 st.execute(sql);
       		                 
       		                 chq_bal = 0;
       		                 inv_bal = 0;
       		                 
       		                 textField.setText("");
       		                 JOptionPane.showMessageDialog(btnNewButton, "Amount transferred successfully.");
       		                 getDetails();
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
             }
		});
		btnNewButton.setBounds(136, 315, 103, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(274, 315, 103, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("Transfer to");
		lblNewLabel_8.setBounds(136, 199, 122, 13);
		contentPane.add(lblNewLabel_8);
		
		
		
		textField = new JTextField();
		textField.setBounds(281, 275, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Transfer Amount");
		lblNewLabel_9.setBounds(136, 278, 103, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Balance");
		lblNewLabel_10.setEnabled(false);
		lblNewLabel_10.setBounds(390, 102, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setEnabled(false);
		lblNewLabel_11.setBounds(390, 123, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setEnabled(false);
		lblNewLabel_12.setBounds(390, 146, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setEnabled(false);
		lblNewLabel_13.setBounds(390, 169, 45, 13);
		contentPane.add(lblNewLabel_13);
		
		
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
                lblNewLabel_11.setText("$ "+bal);
                lblNewLabel_12.setText("$ "+chq_bal);
                lblNewLabel_13.setText("$ "+env_bal);
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

