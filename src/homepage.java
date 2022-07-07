import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class homepage extends JFrame {

	private JPanel contentPane;
	private JLabel accountLabel;
	private JLabel nameLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnUser;
	private JMenu mnNewMenu_2;
	private JMenuItem update_profile;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem_10;
	private JLabel welcomeLabel;

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
					homepage frame = new homepage();
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
	public homepage() {
		
		setResizable(false);
		setTitle("Home page");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
			
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnUser = new JMenu("User profile");
		menuBar.add(mnUser);
		
		update_profile = new JMenuItem("Update profile");
		update_profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
		        	
		            Connection connection = (Connection) DriverManager.getConnection(  
		            		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
		            
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				update_profile update = new update_profile();
				update.setupAccount(acc,fname,lname);
				update.setVisible(true);
			}
		});
		mnUser.add(update_profile);
		
		mntmNewMenuItem_6 = new JMenuItem("Delete user");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				delete_user del = new delete_user();
				del.setupAccount(acc,fname,lname);
				del.setVisible(true);
			}
		});
		mnUser.add(mntmNewMenuItem_6);
		
		mnNewMenu = new JMenu("Accounts");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Open new account");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				open_account open = new open_account();
				open.setupAccount(acc,fname,lname);
				open.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("View accounts");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				View_accounts view = new View_accounts();
				view.setupAccount(acc,fname,lname);
				view.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Delete account");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				delete_account del = new delete_account();
				del.setupAccount(acc,fname,lname);
				del.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Cash transactions");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Deposit cash");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				deposit dep = new deposit();
				dep.setupAccount(acc,fname,lname);
				dep.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Cash withdrawal");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				withdrawal with = new withdrawal();
				with.setupAccount(acc,fname,lname);
				with.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mnNewMenu_2 = new JMenu("Transfer money");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_7 = new JMenuItem("Self accounts");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				transfer trf = new transfer();
				trf.setupAccount(acc,fname,lname);
				trf.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Others accounts");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = accountLabel.getText();
				String sub = acc.substring(17);
				String fname="";
				String lname="";
				
                JButton btnNewButton = new JButton("ok");
				
				System.out.println("inside 2 "+acc);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
                	
                    Connection connection = (Connection) DriverManager.getConnection(  
                    		"jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    
		            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from CUSTOMER where Account_no=?");
		            System.out.println("inside 4 "+sub);
		            st.setString(1, sub);
		           
		            ResultSet rs = st.executeQuery();
		            
		            if (rs.next()) {
		            	
		                fname = rs.getString("firstname");
		                lname = rs.getString("lastname");

		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Invalid Account Number !!!");
		                System.out.println("Invalid credentials!!!");
		            }
		        } catch (SQLException sqlException) {
		            sqlException.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				transfers trfs = new transfers();
				trfs.setupAccount(acc,fname,lname);
				trfs.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		mnNewMenu_4 = new JMenu("Exit");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_10 = new JMenuItem("Close");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, "Exit ?","EXIT",JOptionPane.YES_NO_OPTION);
		        if(confirmed == JOptionPane.YES_OPTION)
		        {
		        	new start_menu().setVisible(true);
					dispose();
		        }
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		welcomeLabel = new JLabel("Welcome !!!", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcomeLabel.setBounds(10, 106, 466, 31);
		contentPane.add(welcomeLabel);
		
		accountLabel = new JLabel("New Label", SwingConstants.CENTER);
		accountLabel.setBounds(0, 318, 486, 13);
		contentPane.add(accountLabel);
		
		nameLabel = new JLabel("New label", SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(10, 158, 466, 31);
		contentPane.add(nameLabel);
		getContentPane().setLayout(null);
		setVisible(true);
	   }
		
	 public String getAccount() {
		return this.accountLabel.getText();} 
	
	 public void setAccount(String acc) {
		 this.accountLabel.setText("Saving account : "+acc);
		 }
	 
	 public String getName() {
			return this.nameLabel.getText();} 
		
     public void setName(String name) {
			 this.nameLabel.setText(name);
		}			
}
