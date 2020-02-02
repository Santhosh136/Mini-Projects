package bankingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frmBankingManagementSystem;
	private JTextField fieldUsername;
	private JTextField fieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmBankingManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankingManagementSystem = new JFrame();
		frmBankingManagementSystem.setTitle("Banking Management System - Login");
		frmBankingManagementSystem.setBounds(100, 100, 450, 300);
		frmBankingManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankingManagementSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 204, 0), 2));
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setBounds(10, 11, 414, 239);
		frmBankingManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(255, 153, 0));
		lblLogin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblLogin.setBounds(20, 23, 105, 24);
		panel.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(102, 102, 102));
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblUsername.setBounds(75, 78, 86, 24);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(102, 102, 102));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblPassword.setBounds(75, 126, 86, 24);
		panel.add(lblPassword);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(195, 78, 155, 25);
		panel.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		fieldPassword = new JTextField();
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(195, 129, 155, 25);
		panel.add(fieldPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(75, 184, 89, 23);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(261, 184, 89, 23);
		panel.add(btnCancel);
	}
}
