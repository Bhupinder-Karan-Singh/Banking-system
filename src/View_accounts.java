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

public class View_accounts extends JFrame {

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
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JButton btnNewButton;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;

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
					View_accounts frame = new View_accounts();
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
	public View_accounts() {
		setTitle("Your accounts");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Accounts ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(193, 53, 72, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Savings A/c");
		lblNewLabel_1.setBounds(118, 95, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(118, 118, 79, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(118, 141, 79, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(290, 95, 186, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(290, 118, 186, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(290, 141, 186, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Chequing A/c");
		lblNewLabel_7.setBounds(118, 187, 79, 13);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Investment A/c");
		lblNewLabel_8.setBounds(118, 210, 79, 13);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(207, 187, 79, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(207, 210, 79, 13);
		contentPane.add(lblNewLabel_10);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(181, 256, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_11 = new JLabel("new label");
		lblNewLabel_11.setBounds(290, 187, 97, 13);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New Label");
		lblNewLabel_12.setBounds(290, 210, 97, 13);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Savings A/c");
		lblNewLabel_13.setBounds(118, 164, 79, 13);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(207, 164, 79, 13);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(290, 164, 186, 13);
		contentPane.add(lblNewLabel_15);
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
		 fetch_details();
	}
	
	public void fetch_details()
	{
		String acc_no = lblNewLabel_4.getText();

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	
            Connection connection = (Connection) DriverManager.getConnection(  
            		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
            
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select Account_no, chequing_no, investment_no, Balance, chequing_balance, investment_balance from CUSTOMER where Account_no=?");

            st.setString(1, acc_no);
           
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                
            	String primary = rs.getString("Account_no");
                String chq = rs.getString("chequing_no");
                String env = rs.getString("investment_no");
                
                String bal = rs.getString("Balance");
                String chq_bal = rs.getString("chequing_balance");
                String env_bal = rs.getString("investment_balance");
                
                lblNewLabel_14.setText(primary);
                lblNewLabel_15.setText("$ "+bal);
                lblNewLabel_9.setText(chq);
                lblNewLabel_10.setText(env);
                lblNewLabel_11.setText("$ "+chq_bal);
                lblNewLabel_12.setText("$ "+env_bal);


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
