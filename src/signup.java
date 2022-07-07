import java.awt.BorderLayout;
import oracle.jdbc.driver.OracleDriver;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import java.awt.Font;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

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
					signup frame2 = new signup();
					frame2.setTitle("Sign Up");
					frame2.setLocationRelativeTo(null);
					frame2.setVisible(true);
					
					new start_menu().setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
		setTitle("Sign Up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(90, 113, 50, 13);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 110, 211, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(90, 142, 50, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 139, 211, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(90, 168, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(160, 164, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(312, 164, 59, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		ButtonGroup group = new ButtonGroup();  // grouping the radio buttons for one slection at a time
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	   
	    
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	            
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
                    String sqlInsert =
                    	     "INSERT INTO CUSTOMER(Account_no,firstname,lastname,Balance,gender,chequing_balance,investment_balance)"
                    	     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(sqlInsert);
                    
                    Random rand = new Random();
                    int rand_int = rand.nextInt(999999999);
                    String id = Integer.toString(rand_int);
                    
                    String input="";
                    
                    if (rdbtnNewRadioButton.isSelected()) {
                    	  
                        input = "Male";
                    }
                    else if (rdbtnNewRadioButton_1.isSelected()) {
      
                        input = "Female";
                    }
                    
                    String fname = textField_1.getText();
                    String lname = textField_2.getText();
                    String gen = input.toString();
                    
                    if(fname.equals("") || lname.equals("") || input.equals("")) {
                    	JOptionPane.showMessageDialog(btnNewButton, "Invalid credentials !!!");
                    }
                    else {
                    st.setString(1,id);
                    st.setString(2,fname);
                    st.setString(3,lname);
                    st.setString(4,"0");
                    st.setString(5,gen);
                    st.setString(6,"0");
                    st.setString(7,"0");
                    
                    st.executeUpdate();
                    connection.close();

                    System.out.println("User added");
                    
    				dispose();
    				
    				JOptionPane.showMessageDialog(btnNewButton, "Account Created successfully !!!");
    				JOptionPane.showMessageDialog(btnNewButton, "Your Account Number is: "+rand_int +". Please note it down for future reference");
    				new start_menu().setVisible(true);
    				dispose();
                    }
                   
                  } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                 } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
	
		});
		
		btnNewButton.setBounds(160, 201, 103, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home Page");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new start_menu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(273, 201, 98, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Create Account", SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(187, 41, 128, 32);
		contentPane.add(lblNewLabel_1);
	}
}
