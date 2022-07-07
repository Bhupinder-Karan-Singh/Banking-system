import java.awt.BorderLayout;
import oracle.jdbc.driver.OracleDriver;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class update_profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
		    catch (UnsupportedLookAndFeelException e) { }
		    catch (ClassNotFoundException e) { }
		    catch (InstantiationException e) { }
		    catch (IllegalAccessException e) { }
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_profile frame = new update_profile();
					frame.setLocationRelativeTo(null);
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
	public update_profile() {
		
		
		
		setTitle("Update Profile");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(178, 68, 196, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label2 = new JLabel("First name");
		label2.setBounds(80, 105, 88, 13);
		contentPane.add(label2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 102, 196, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label3 = new JLabel("Last name");
		label3.setBounds(80, 138, 88, 13);
		contentPane.add(label3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 135, 196, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label1 = new JLabel("Saving Account");
		label1.setBounds(80, 71, 88, 13);
		contentPane.add(label1);
		
		JLabel label4 = new JLabel("Contact Number");
		label4.setBounds(80, 173, 88, 13);
		contentPane.add(label4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 170, 196, 19);
		contentPane.add(textField_3);
		
		JLabel label5 = new JLabel("Email Address");
		label5.setBounds(80, 207, 88, 13);
		contentPane.add(label5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 204, 196, 19);
		contentPane.add(textField_4);
		
		JLabel label6 = new JLabel("Home Address");
		label6.setBounds(80, 241, 88, 13);
		contentPane.add(label6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 238, 196, 19);
		contentPane.add(textField_5);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	
				String txt1 = textField_1.getText();
				String txt2 = textField_2.getText();
				String txt3 = textField_3.getText();
				String txt4 = textField_4.getText();
				String txt5 = textField_5.getText();
				
				String acc = textField.getText();
				
			    try {
			    	Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		           String sql = "UPDATE CUSTOMER SET firstname ='" + txt1 + "',lastname='" + txt2 + "',contact_number='" + txt3 + "',email='" + txt4 +"',address='" + txt5 + "' WHERE Account_no='" + acc + "'";
                   PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
		      		        
		           st.execute(sql);
		            
		           JOptionPane.showMessageDialog(btnNewButton, "Database updation successfull !!!");
		           dispose();
		            
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(178, 290, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(289, 290, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Update Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(195, 22, 172, 19);
		contentPane.add(lblNewLabel);
		
		
	}
	
	public String getupAccount() {
		return this.textField.getText();
		} 


	public void setupAccount(String acc, String name, String lname) {
		// TODO Auto-generated method stub
		 String sub = acc.substring(17);
		 this.textField.setText(sub);
		 this.textField_1.setText(name);
		 this.textField_2.setText(lname);
		 fetch_details();
	}	
	
	public void fetch_details()
	{
		String acc_no = textField.getText();

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	
            Connection connection = (Connection) DriverManager.getConnection(  
            		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select Account_no, contact_number, email, address from CUSTOMER where Account_no=?");

            st.setString(1, acc_no);
           
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
                String contact = rs.getString("contact_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                
                textField_3.setText(contact);
                textField_4.setText(email);
                textField_5.setText(address);

            } else {
                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
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
