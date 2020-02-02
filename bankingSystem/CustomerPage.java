package bankingSystem;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerPage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtGender;
	private JTextField txtMobileNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage frame = new CustomerPage();
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
	public CustomerPage() {
		setBorder(new LineBorder(new Color(0, 51, 204)));
		setTitle("Banking Management System - Customer Page");
		setBounds(100, 100, 452, 347);
		getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setForeground(new Color(255, 153, 0));
		lblCustomer.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
		lblCustomer.setBounds(10, 23, 116, 29);
		getContentPane().add(lblCustomer);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(20, 73, 77, 14);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(20, 118, 77, 14);
		getContentPane().add(lblLastName);
		
		JLabel lbDOB = new JLabel("Date Of Birth");
		lbDOB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbDOB.setBounds(20, 159, 77, 14);
		getContentPane().add(lbDOB);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(20, 197, 77, 14);
		getContentPane().add(lblGender);
		
		JLabel lblMobinleNo = new JLabel("Mobile No");
		lblMobinleNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMobinleNo.setBounds(20, 240, 77, 14);
		getContentPane().add(lblMobinleNo);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(158, 71, 116, 20);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(158, 116, 116, 20);
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(158, 157, 116, 20);
		getContentPane().add(txtDOB);
		txtDOB.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setBounds(158, 195, 117, 20);
		getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(158, 238, 116, 20);
		getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/BankGCT","root","student");
					Statement st = con.createStatement();
					String fname = txtFirstName.getText();
					String lname = txtLastName.getText();
					String dob = txtDOB.getText();
					String gender = txtGender.getText();
					String mobno = txtMobileNo.getText();
					
					//insert
					String sql = "insert into customer(first_name,last_name,dob,gender,mobno) values('"+fname+"','"+lname+"','"+dob+"','"+gender+"',"+mobno+");";
					System.out.println(sql);
					st.executeUpdate(sql);
					
					//print recently added cus_id
					ResultSet rs = st.executeQuery("select max(cus_id) from customer");
					rs.next();
					rs.getString(1);
					JOptionPane.showMessageDialog(null, "Successfully added! your Customer ID is CS"+rs.getString(1));
					
					//clear
					txtFirstName.setText("");
					txtLastName.setText("");
					txtDOB.setText("");
					txtGender.setText("");
					txtMobileNo.setText("");
					
					//focusing cursor
					txtFirstName.requestFocus();
					
				}
				catch(ClassNotFoundException | SQLException ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(323, 118, 82, 39);
		getContentPane().add(btnAdd);
		
     	JButton btnCancel = new JButton("Cancel");
     	btnCancel.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {
     			setVisible(false);
     			dispose();
     		}
     	});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBounds(323, 197, 82, 39);
		getContentPane().add(btnCancel);
	
	}
}
