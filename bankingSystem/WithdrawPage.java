package bankingSystem;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class WithdrawPage extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAccountNo;
	private JTextField txtWithdraw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawPage frame = new WithdrawPage();
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
	public WithdrawPage() {
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Banking Management System - Withdraw Page");
		setBounds(100, 100, 455, 385);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Account No", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 102, 204)));
		panel.setBounds(10, 11, 238, 146);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterAccountNo = new JLabel("Enter Account No");
		lblEnterAccountNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblEnterAccountNo.setBounds(10, 28, 156, 14);
		panel.add(lblEnterAccountNo);
		
		txtAccountNo = new JTextField();
		txtAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAccountNo.setBounds(33, 61, 156, 20);
		panel.add(txtAccountNo);
		txtAccountNo.setColumns(10);
		
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerId.setBounds(10, 187, 120, 14);
		getContentPane().add(lblCustomerId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(10, 220, 120, 14);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(10, 255, 120, 14);
		getContentPane().add(lblLastName);
		
		JLabel lblcustomerid = new JLabel("");
		lblcustomerid.setForeground(new Color(153, 204, 0));
		lblcustomerid.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblcustomerid.setBounds(140, 188, 108, 14);
		getContentPane().add(lblcustomerid);
		
		JLabel lblfirstname = new JLabel("");
		lblfirstname.setForeground(new Color(153, 204, 0));
		lblfirstname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblfirstname.setBounds(140, 221, 108, 14);
		getContentPane().add(lblfirstname);
		
		JLabel lbllastname = new JLabel("");
		lbllastname.setForeground(new Color(153, 204, 0));
		lbllastname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lbllastname.setBounds(140, 256, 108, 23);
		getContentPane().add(lbllastname);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Balance", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 102, 204)));
		panel_1.setBounds(258, 11, 159, 146);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblBalance.setBounds(10, 28, 108, 14);
		panel_1.add(lblBalance);
		
		JLabel lblbalance = new JLabel("Rs.");
		lblbalance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblbalance.setBounds(39, 74, 79, 32);
		panel_1.add(lblbalance);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Withdraw", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 102, 204)));
		panel_2.setBounds(258, 168, 159, 130);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblWithdraw.setBounds(10, 30, 104, 14);
		panel_2.add(lblWithdraw);
		
		txtWithdraw = new JTextField();
		txtWithdraw.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtWithdraw.setText("Rs.");
		txtWithdraw.setBackground(new Color(135, 206, 235));
		txtWithdraw.setBounds(40, 67, 86, 35);
		panel_2.add(txtWithdraw);
		txtWithdraw.setColumns(10);
		
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String acc_id = txtAccountNo.getText().substring(2);
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/BankGCT","root","student");
					Statement st = con.createStatement();
					
					
					ResultSet rs = st.executeQuery("select * from account where acc_id="+acc_id+";");
					rs.next();
					System.out.println(rs.getString(2));
					lblcustomerid.setText("CS"+rs.getString(2));
					lblbalance.setText("Rs."+rs.getString(5));
					String cus_id = rs.getString(2);
					
					
					rs = st.executeQuery("select * from customer where cus_id="+cus_id+";");
					rs.next();
					lblfirstname.setText(rs.getString(2));
					lbllastname.setText(rs.getString(3));
				}
				catch(ClassNotFoundException | SQLException ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnFind.setBounds(68, 103, 89, 23);
		panel.add(btnFind);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Connection con;
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/BankGCT","root","student");
					Statement st = con.createStatement();
					
					String amnt = txtWithdraw.getText().substring(3);
					double amount = Double.parseDouble(amnt);
					String acc_id = txtAccountNo.getText().substring(2);
					ResultSet rs = st.executeQuery("select * from account where acc_id="+acc_id+";");
					rs.next();
					double preAmount = Double.parseDouble(rs.getString(5));
					amount = preAmount - amount;

					st.executeUpdate("update account set amount="+amount+" where acc_id="+acc_id+";");
					lblbalance.setText(Double.toString(amount));
					
					txtAccountNo.setText("");
					txtWithdraw.setText("Rs.");
					lblfirstname.setText("");
					lbllastname.setText("");
					lblcustomerid.setText("");
					lblbalance.setText("");
					
					
				}
				catch(ClassNotFoundException | SQLException ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnOk.setBounds(52, 309, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(282, 309, 89, 23);
		getContentPane().add(btnCancel);

	}
}
