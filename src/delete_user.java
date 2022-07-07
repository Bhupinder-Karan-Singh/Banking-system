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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delete_user extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel; 
	private JLabel lblNewLabel_1; 
	private JLabel lblNewLabel_2; 
	private JLabel lblNewLabel_3; 
	private JLabel lblNewLabel_4; 
	private JLabel lblNewLabel_5; 
	private JLabel lblNewLabel_6; 
	private JButton btnNewButton;
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
					delete_user frame = new delete_user();
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
	public delete_user() {
		setTitle("Delete User");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Delete profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(187, 50, 96, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Savings A/c");
		lblNewLabel_1.setBounds(124, 94, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(124, 117, 79, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(124, 140, 78, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(238, 94, 136, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(238, 117, 136, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(238, 140, 112, 13);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Delete User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc_no = lblNewLabel_4.getText();
				
			    try {
			    	
			    	Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
		           
		           String sql = "DELETE FROM CUSTOMER WHERE Account_no='" + acc_no + "'";
		        		   
                   PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
                
		           st.execute(sql);
		            
		           JOptionPane.showMessageDialog(btnNewButton, "User deleted successfully !!!");
		           start_menu start = new start_menu();   				
   				   start.setVisible(true);
   				dispose();
		            
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(124, 189, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(232, 189, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	public String getupAccount() {
		return this.lblNewLabel_4.getText();
		} 


	public void setupAccount(String acc, String name, String lname) {
		// TODO Auto-generated method stub
		 String sub = acc.substring(17);
		 this.lblNewLabel_4.setText(sub);
		 this.lblNewLabel_5.setText(name);
		 this.lblNewLabel_6.setText(lname);
		 
	}
	
	
}
