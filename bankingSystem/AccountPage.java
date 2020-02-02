package bankingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AccountPage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCustomerID;
	private JTextField txtCustomerName;
	private JTextField txtAcctype;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountPage frame = new AccountPage();
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
	public AccountPage() {
		setBorder(new LineBorder(new Color(0, 51, 204)));
		setTitle("Banking Management System - Account Page");
		setBounds(100, 100, 452, 282);
		getContentPane().setLayout(null);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setForeground(new Color(255, 153, 0));
		lblAccount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
		lblAccount.setBounds(20, 22, 116, 29);
		getContentPane().add(lblAccount);
		
		JLabel lblCustomerID = new JLabel("Customer ID");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerID.setBounds(20, 75, 77, 14);
		getContentPane().add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerName.setBounds(20, 118, 99, 14);
		getContentPane().add(lblCustomerName);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountType.setBounds(20, 159, 77, 14);
		getContentPane().add(lblAccountType);
		
		JLabel lblAmountInRs = new JLabel("Amount in Rs.");
		lblAmountInRs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmountInRs.setBounds(20, 202, 99, 14);
		getContentPane().add(lblAmountInRs);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setBounds(158, 73, 116, 20);
		getContentPane().add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(158, 116, 116, 20);
		getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		txtAcctype = new JTextField();
		txtAcctype.setBounds(158, 157, 116, 20);
		getContentPane().add(txtAcctype);
		txtAcctype.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/BankGCT","root","student");
					Statement st = con.createStatement();
					String cus_id = txtCustomerID.getText().substring(2
							);
					String name = txtCustomerName.getText();
					String acc_type = txtAcctype.getText();
					String amount = txtAmount.getText();
					
					
					//insert
					String sql = "insert into account(cus_id,cus_name,acc_type,amount) values("+cus_id+",'"+name+"','"+acc_type+"',"+amount+");";
					System.out.println(sql);
					st.executeUpdate(sql);
					
					//print recently added cus_id
					ResultSet rs = st.executeQuery("select max(acc_id) from account");
					rs.next();
					rs.getString(1);
					JOptionPane.showMessageDialog(null, "Successfully added! your Account ID is AC"+rs.getString(1));
					
					//clear
					txtCustomerID.setText("");
					txtCustomerName.setText("");
					txtAcctype.setText("");
					txtAmount.setText("");
					
					//focusing cursor
					txtCustomerID.requestFocus();
					
				}
				catch(ClassNotFoundException | SQLException ex)
				{
					System.out.println(ex);
				}
			}
		});
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(158, 200, 116, 20);
		getContentPane().add(txtAmount);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(323, 123, 82, 39);
		getContentPane().add(btnAdd);
		
     	JButton btnCancel = new JButton("Cancel");
     	btnCancel.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {
     			setVisible(false);
     			dispose();
     		}
     	});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBounds(323, 190, 82, 39);
		getContentPane().add(btnCancel);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String cus_id = txtCustomerID.getText().substring(2);
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/BankGCT","root","student");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from customer where cus_id="+cus_id+";");
					rs.next();
					System.out.println(rs.getString(2));
					txtCustomerName.setText(rs.getString(2));
				}
				catch(ClassNotFoundException | SQLException ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFind.setBounds(323, 54, 82, 39);
		getContentPane().add(btnFind);
	
	}
}
